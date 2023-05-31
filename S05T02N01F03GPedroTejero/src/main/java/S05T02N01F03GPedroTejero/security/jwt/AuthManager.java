package S05T02N01F03GPedroTejero.security.jwt;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import S05T02N01F03GPedroTejero.security.services.UserDetailsImpl;

@Component
public class AuthManager implements AuthenticationManager{

		    @Override
		    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		        String username = authentication.getName();
		        String password = authentication.getCredentials().toString();


		        // Example: Simple authentication with hardcoded credentials
		        if ("admin".equals(username) && "password".equals(password)) {
		        	String id = "1";
		        	 UserDetailsImpl userDetails = new UserDetailsImpl(id, username, password, Collections.emptyList());
		             return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		          
		            
		        } else {
		            throw new AuthenticationException("Authentication failed") {
		                // Implement your own exception handling logic if needed
		            };
		        }

	
	}

}
