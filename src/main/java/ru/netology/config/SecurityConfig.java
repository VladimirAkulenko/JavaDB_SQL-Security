package ru.netology.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Admin").password(encoder().encode("password"))
                .roles("READ", "WRITE", "DELETE").build();
        UserDetails user1 = User.builder()
                .username("Vladimir").password(encoder().encode("1234"))
                .roles("WRITE").build();
        UserDetails user2 = User.builder()
                .username("Ivan").password(encoder().encode("5678"))
                .roles("READ").build();
        return new InMemoryUserDetailsManager(admin, user1, user2);
    }

}
