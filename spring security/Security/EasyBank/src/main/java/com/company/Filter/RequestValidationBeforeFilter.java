package com.company.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public class RequestValidationBeforeFilter  implements Filter {

    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    private Charset credentialsCharset = StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String header = req.getHeader(AUTHORIZATION);//basic username:password //(encoded) base64 encoding
        if (header != null) {
            header = header.trim();
            if (StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME_BASIC)) {
                System.out.println("header: "+header);
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);//username:password (base64 encoded)
                System.out.println();
                System.out.print("base64Token: ");
                for(byte i:base64Token){
                    System.out.print(i+" ");
                }
                byte[] decoded;
                try {
                    decoded = Base64.getDecoder().decode(base64Token);//username:password is decoded into a byte array
                    System.out.println();
                    System.out.print("Decoded: ");
                    for(byte i:decoded){
                        System.out.print(i+" ");
                    }
                    String token = new String(decoded, credentialsCharset);//the byte array is converted to string as "MyUserName:MyPassword"
                    System.out.println(token);
                    int delim = token.indexOf(":");//delim--->index of the ":" is found so that the both can be differentiated..
                    if (delim == -1) {
                        throw new BadCredentialsException("Invalid basic authentication token");
                    }
                    String email = token.substring(0, delim);//email or the userName (same thing)
                    if (email.toLowerCase().contains("test")) {
                        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }
                    //if it doesnt contain test then the filter just passes the request to the next filter or class
                } catch (IllegalArgumentException e) {
                    throw new BadCredentialsException("Failed to decode basic authentication token");
                }
            }
        }
        chain.doFilter(request, response);
    }
}