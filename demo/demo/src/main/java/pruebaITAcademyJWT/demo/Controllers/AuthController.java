package pruebaITAcademyJWT.demo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pruebaITAcademyJWT.demo.model.domain.Jugador;
import pruebaITAcademyJWT.demo.model.domain.Role;
import pruebaITAcademyJWT.demo.model.repository.JugadorRepository;
import pruebaITAcademyJWT.demo.payload.request.LoginRequest;
import pruebaITAcademyJWT.demo.payload.request.SignupRequest;
import pruebaITAcademyJWT.demo.payload.response.JwtResponse;
import pruebaITAcademyJWT.demo.payload.response.MessageResponse;
import pruebaITAcademyJWT.demo.security.jwt.JwtUtils;
import pruebaITAcademyJWT.demo.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JugadorRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));

	}

	@PostMapping("/signup")
	public String registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsById(signUpRequest.getUsername())) {
			//error: nombre de usuario ya en la base de datos
			return "Error";
		}

//creación nuevo jugador
		
		  Jugador newuser = new Jugador(signUpRequest.getUsername(),
		  encoder.encode(signUpRequest.getPassword()));
		  List<Role> roles = new ArrayList<>();
		  Role rol = new Role("USER");
		  roles.add(rol);		  
		  newuser.setRoles(roles); userRepository.save(newuser);
		  
		  return "exito";
		 
	}
}