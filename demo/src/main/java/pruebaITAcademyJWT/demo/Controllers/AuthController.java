package pruebaITAcademyJWT.demo.Controllers;

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
import pruebaITAcademyJWT.demo.model.repository.JugadorRepository;
import pruebaITAcademyJWT.demo.payload.request.LoginRequest;
import pruebaITAcademyJWT.demo.payload.request.SignupRequest;
import pruebaITAcademyJWT.demo.payload.response.JwtResponse;
import pruebaITAcademyJWT.demo.payload.response.MessageResponse;
import pruebaITAcademyJWT.demo.security.WebSecurityConfiguration;
import pruebaITAcademyJWT.demo.security.jwt.JwtUtils;
import pruebaITAcademyJWT.demo.security.services.CustomAuthenticationManager;
import pruebaITAcademyJWT.demo.security.services.UserDetailsImpl;

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
		
		 /*SecurityContext context = SecurityContextHolder.createEmptyContext();
		 context.setAuthentication(authentication);
		 SecurityContextHolder.setContext(context);*/

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
		//return new ResponseEntity<>("todo OK", HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsById(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		return new ResponseEntity<>("", HttpStatus.OK);

		// Create new user's account
		/*
		 * Jugador newuser = new Jugador(signUpRequest.getUsername(),
		 * signUpRequest.getRole(), encoder.encode(signUpRequest.getPassword()));
		 */

		// Set<String> strRoles = signUpRequest.getRole();
		// Set<Role> roles = new HashSet<>();

		/*
		 * if (strRoles == null) { Role userRole =
		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
		 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
		 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
		 * 
		 * break; case "mod": Role modRole =
		 * roleRepository.findByName(ERole.ROLE_MODERATOR) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(modRole);
		 * 
		 * break; default: Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		 * roles.add(userRole); } }); }
		 * 
		 * user.setRoles(roles); userRepository.save(user);
		 * 
		 * return ResponseEntity.ok(new
		 * MessageResponse("User registered successfully!")); }
		 */
	}
}