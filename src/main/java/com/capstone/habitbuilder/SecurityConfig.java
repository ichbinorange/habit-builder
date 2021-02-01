package com.capstone.habitbuilder;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                        .disable()
                    .antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/", "/indext.html")
                        .authenticated()
                    .anyRequest()
                        .authenticated()
                    .and()
                    .oauth2Login()
                        .permitAll()
                    .and()
                    .logout()
                        .logoutSuccessUrl("/");
    }
}