package ru.netology.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Admin").password("password")
                .authorities("read", "write").build();
        UserDetails user = User.builder()
                .username("Vladimir").password("{noop}1234")
                .authorities("write").build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/persons/welcome").permitAll()
                .requestMatchers("/persons/by-city").hasAuthority("read")
                .requestMatchers("/persons/by-age").hasAuthority("write")
                .requestMatchers("/persons/name-and-surname").hasAuthority("write")
                .anyRequest().authenticated()).formLogin(withDefaults());
        return http.build();
    }
}
