package S05T02N01F03GPedroTejero.Controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import S05T02N01F03GPedroTejero.model.domain.Role;
import S05T02N01F03GPedroTejero.model.repository.JugadorRepository;
import S05T02N01F03GPedroTejero.security.CustomAuthenticationManager;
import S05T02N01F03GPedroTejero.security.jwt.JwtUtils;
import S05T02N01F03GPedroTejero.payload.request.LoginRequest;
import S05T02N01F03GPedroTejero.payload.request.SignupRequest;
import S05T02N01F03GPedroTejero.payload.response.JwtResponse;
import S05T02N01F03GPedroTejero.security.services.UserDetailsImpl;
import S05T02N01F03GPedroTejero.model.domain.Jugador;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	CustomAuthenticationManager authenticationManager;

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

	// Create new user's account

	@PostMapping("/signup")
	public String registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsById(signUpRequest.getUsername())) {
			// error: nombre de usuario ya en la base de datos
			return "Error";
		}

		// creación nuevo jugador

		Jugador newuser = new Jugador(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

		List<Role> roles = new ArrayList<>();
		Role rol = new Role("USER");
		roles.add(rol);
		newuser.setRoles(roles);
		userRepository.save(newuser);

		return "exito";

	}
}