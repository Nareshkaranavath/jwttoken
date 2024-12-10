package com.jwttoken.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
      httpSecurity
              .csrf(csrf -> csrf.disable())
                             .authorizeHttpRequests(request ->
                              request
                                      .requestMatchers("register", "login").permitAll()
                                      .anyRequest()
                                          .authenticated())
                                        //  .formLogin(Customizer.withDefaults())
                                          .httpBasic(Customizer.withDefaults());
                             return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails =
                User.withUsername("naresh")
                .password("{noop}Rainier@1995")
                .roles("USER")
                .build();
       UserDetails userDetails1 =
               User.withUsername("nikhle")
               .password("{noop}nikhle")
               .roles("USER")
               .build();
       return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }
}
