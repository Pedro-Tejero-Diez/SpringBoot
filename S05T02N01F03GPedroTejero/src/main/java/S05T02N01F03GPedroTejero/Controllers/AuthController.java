package S05T02N01F03GPedroTejero.Controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import S05T02N01F03GPedroTejero.model.repository.JugadorRepository;
import S05T02N01F03GPedroTejero.security.jwt.AuthManager;
import S05T02N01F03GPedroTejero.security.jwt.JwtUtils;
import S05T02N01F03GPedroTejero.payload.request.LoginRequest;
import S05T02N01F03GPedroTejero.payload.request.SignupRequest;
import S05T02N01F03GPedroTejero.payload.response.JwtResponse;
import S05T02N01F03GPedroTejero.payload.response.MessageResponse;
import S05T02N01F03GPedroTejero.security.services.UserDetailsImpl;
import S05T02N01F03GPedroTejero.model.domain.Jugador;
import S05T02N01F03GPedroTejero.model.domain.Role;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthManager authenticationManager;

	@Autowired
	JugadorRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	SignupRequest signuprequest;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByusername(signuprequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		Jugador user = new Jugador(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

		List<String> strRoles = signUpRequest.getRole();
		List<Role> roles = new ArrayList<>();
		Role userrol = new Role("USER");
		Role adminrol = new Role("ADMIN");

		if (strRoles == null) {
			roles.add(userrol);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ADMIN":
					roles.add(adminrol);
					break;
				default:
					roles.add(userrol);
				}
			});
		}
			user.setRoles(roles);
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

		
	}
}
