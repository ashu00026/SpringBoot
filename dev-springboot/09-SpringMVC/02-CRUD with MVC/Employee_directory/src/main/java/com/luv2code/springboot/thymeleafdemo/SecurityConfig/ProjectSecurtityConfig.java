package com.luv2code.springboot.thymeleafdemo.SecurityConfig;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class ProjectSecurtityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id,pw,active from members where user_id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id,role from roles where user_id = ?");
        return jdbcUserDetailsManager;
    }
    @Bean
    SecurityFilterChain projectSecurityFilterChain(HttpSecurity http)throws Exception{
//        CsrfTokenRequestAttributeHandler requestHandler=new CsrfTokenRequestAttributeHandler();
//        requestHandler.setCsrfRequestAttributeName("_csrf");
        http
                .cors(corsCustomizer->corsCustomizer.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config=new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("*"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
//                config.setAllowedHeaders(Collections.singletonList("*"));
////                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }
        }))
//                .csrf((csrf)->csrf.csrfTokenRequestHandler(requestHandler)
////                        .ignoringRequestMatchers()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                . authorizeHttpRequests(configurer->
                        configurer
                                .requestMatchers("/","/registerUser","/user/processForm").permitAll()
                                .requestMatchers("/employees/list").hasRole("EMPLOYEE")
                                .requestMatchers("/employees/showFormForAdd").hasRole("MANAGER")
                                .requestMatchers("/employees/showFormForUpdate").hasRole("MANAGER")
                                .requestMatchers("/employees/processForm").hasRole("MANAGER")
                                .requestMatchers("/employees/delete").hasRole("ADMIN")

//                                .requestMatchers(HttpMethod.POST,"/api/cars").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.PUT,"/api/cars").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.DELETE,"/api/cars/**").hasRole("ADMIN")
                );
                    http.formLogin(form->
                            form
                                    .loginPage("/showMyLoginPage")
                                    .loginProcessingUrl("/authenticateUser")
                                    .permitAll())
                            .logout(logout->
                                    logout.permitAll()
                            );
//                http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                    http.httpBasic(Customizer.withDefaults());

                    http.csrf(csrf->csrf.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
