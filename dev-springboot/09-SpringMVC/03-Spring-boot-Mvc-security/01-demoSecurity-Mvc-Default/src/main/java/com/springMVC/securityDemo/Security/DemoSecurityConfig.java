package com.springMVC.securityDemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john= User.builder()
                .username("john")
                .password("{noop}Test123")
                .roles("USER")
                .build();
        UserDetails marry= User.builder()
                .username("marry")
                .password("{noop}Test123")
                .roles("USER","MANAGER")
                .build();
        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}Test123")
                .roles("USER","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,marry,susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer->
                    configurer
                        .anyRequest()
                        .authenticated()
                ).formLogin(form->
                    form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll()
                )
                .logout(logout->
                        logout.permitAll()
                );

        return http.build();
    }

}
