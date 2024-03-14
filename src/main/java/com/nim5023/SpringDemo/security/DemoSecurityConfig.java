package com.nim5023.SpringDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(config ->
                config.requestMatchers(HttpMethod.GET, "/students").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/students/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
*/

}
