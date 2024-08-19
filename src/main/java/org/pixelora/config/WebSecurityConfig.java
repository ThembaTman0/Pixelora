package org.pixelora.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class); // Logger to log information and errors

    private static final String[] WHITELIST = { // List of URL patterns that are accessible without authentication
            "/",
            "/login",
            "/register",
            "/db-console/**",  // H2 database console access
            "/css/**",         // Static resources: CSS files
            "/fonts/**",       // Static resources: Font files
            "/images/**",      // Static resources: Image files
            "/js/**",          // Static resources: JavaScript files
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Applying security configuration...");  // Logs that the security configuration is being applied

        http.authorizeHttpRequests()
                .requestMatchers(WHITELIST)
                .permitAll()           // Permits access to the URLs defined in the whitelist without authentication
                .anyRequest()
                .authenticated()       // Requires authentication for any other request
                //TODO: remove these after upgrading the DB from H2 in-file DB

                .and()
                .csrf().disable()      // Disables CSRF protection (should be enabled in production for security)
                .headers().frameOptions().disable();  // Disables frame options to allow the H2 console to be loaded in a frame

        return http.build();  // Builds the SecurityFilterChain with the configured security settings
    }
}
