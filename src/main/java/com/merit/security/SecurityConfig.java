package com.merit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                .and()
                    .authorizeRequests()
                    .antMatchers("/error").permitAll()      //---- error log access - all access for production only

                    .antMatchers("/swagger-ui.html").permitAll()            //---- swagger access - all access for production only
                    .antMatchers("/swagger-ui.html/**").permitAll()         //---- swagger access - all access for production only
                    .antMatchers("/swagger-resources.html/**").permitAll()  //---- swagger access - all access for production only

                    .antMatchers("/h2-console/**").permitAll()              //---- h2 access - all access for production only

                    .antMatchers("/").permitAll()                               //---- access
                .and()
                    .formLogin();
        http.csrf().disable();
    }
}