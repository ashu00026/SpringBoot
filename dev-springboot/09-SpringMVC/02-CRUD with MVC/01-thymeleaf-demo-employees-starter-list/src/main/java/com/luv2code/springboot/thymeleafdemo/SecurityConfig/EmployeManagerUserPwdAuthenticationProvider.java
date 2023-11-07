package com.luv2code.springboot.thymeleafdemo.SecurityConfig;

import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class EmployeManagerUserPwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<Members> employee = employeeService.findByUserName(username);
        List<Roles> roles=employeeService.findByRole(username);

        if (employee.size() > 0) {
            if (passwordEncoder.matches(pwd, employee.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(roles.get(0).getRole()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }
    private List<GrantedAuthority> getGrantedAuthorities(Set<Roles> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Roles authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole().toString()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
