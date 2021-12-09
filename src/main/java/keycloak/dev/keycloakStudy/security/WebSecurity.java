package keycloak.dev.keycloakStudy.security;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class WebSecurity {

    protected void configure(HttpSecurity http) throws Exception {
//        logger.debug("Userseiofjweiof");

        http
            .authorizeHttpRequests()
                    .antMatchers(HttpMethod.GET, "/users/status/check")
                    .hasAuthority("SCOPE_profile")
                .anyRequest().authenticated()
                .and()
            .oauth2ResourceServer()
            .jwt();
    }

}
