package S05T02N01F03GPedroTejero.security.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import S05T02N01F03GPedroTejero.security.services.UserDetailsImpl;
import S05T02N01F03GPedroTejero.security.services.UserDetailsServiceImpl;

@Component
public class AuthManager implements AuthenticationManager{
	
	@Autowired
	UserDetailsServiceImpl userdetailserviceimpl;

		    @Override
		    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		        String username = authentication.getName();
		        String password = authentication.getCredentials().toString();
		        UserDetailsImpl userimpl = userdetailserviceimpl.loadUserByUsername(username);

		        if ( userimpl.getPassword().equals(password)&&userimpl.getUsername().equals(username)) {
		             return new UsernamePasswordAuthenticationToken(userimpl, password, userimpl.getAuthorities());
		          
		            
		        } else {
		            throw new AuthenticationException("Authentication failed") {
		            };
		        }	
	}

}
