package S05T02N01F03GPedroTejero.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthManager implements AuthenticationManager{

		    @Override
		    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		        String username = authentication.getName();
		        String password = authentication.getCredentials().toString();

		        // Perform your authentication logic here
		        // You can use your own authentication provider or validate the credentials against your user database

		        // Example: Simple authentication with hardcoded credentials
		        if ("admin".equals(username) && "password".equals(password)) {
		            return new UsernamePasswordAuthenticationToken(username, password);
		        } else {
		            throw new AuthenticationException("Authentication failed") {
		                // Implement your own exception handling logic if needed
		            };
		        }

	
	}

}
