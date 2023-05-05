package pruebaITAcademyJWT.demo.security;

import org.springframework.context.annotation.Configuration;

/*@Configuration
public class JWTSecurityConfig {


    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authz -> authz.antMatchers(HttpMethod.GET, "/foos/**")
            .hasAuthority("SCOPE_read")
            .antMatchers(HttpMethod.POST, "/foos")
            .hasAuthority("SCOPE_write")
            .anyRequest()
            .authenticated())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }
}*/