package com.company.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                                                         .requestMatchers("/myAccount","/myBalance","myLoans","myCards").authenticated()
                                                         .requestMatchers("/notices","/contact","/register").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    InMemoryUserDetailsManager userDetailsService(){
//        UserDetails admin= User.withUsername("admin")
////                .password("{noop}12345")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user=User.withUsername("user")
////                .password("{noop}12345")
//                .password("12345")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }
//    @Bean
//    public UserDetailsService userDetailsService(DataSource theDataSource){
//        return new JdbcUserDetailsManager(theDataSource);
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
