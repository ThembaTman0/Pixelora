package org.pixelora.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    private static final String[] WHITELIST = {
            "/",
            "/login",
            "/register",
            "/db-console/**",
            "/css/**",
            "/fonts/**",
            "/images/**",
            "/js/**",
    };

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Applying security configuration...");

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                ) // End of formLogin configuration
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout?success")
                        .permitAll()
                ) // End of logout configuration
                .httpBasic(withDefaults()) // Adds basic authentication
                .csrf((csrf) -> csrf.disable())  // Disable CSRF protection
                .headers((headers) -> headers.frameOptions().disable());  // Disable frame options for H2 console

        return http.build();
    }
}

