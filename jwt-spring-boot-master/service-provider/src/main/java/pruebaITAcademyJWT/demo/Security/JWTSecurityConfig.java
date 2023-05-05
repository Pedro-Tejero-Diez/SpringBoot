package pruebaITAcademyJWT.demo.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/*@Configuration
public class JWTSecurityConfig {
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authz -> authz.requestMatchers(HttpMethod.GET, "/Players/**")
				.hasAuthority("SCOPE_read")
				.requestMatchers(HttpMethod.POST, "/Players")
				.hasAuthority("SCOPE_write")
				.anyRequest()
				.authenticated()).oauth2ResourceServer(oauth2 -> oauth2.jwt());
				
				
		return http.build();
		
	}

}
*/
