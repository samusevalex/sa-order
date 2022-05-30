package ru.iteco.saorder.service.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.iteco.config.security.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Slf4j
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenService tokenService;

    private final JwtAccessDeniedHandler accessDeniedHandler;

    private final TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/**",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/documentation/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and().addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .and().exceptionHandling()
                .authenticationEntryPoint(tokenAuthenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

    public TokenAuthenticationFilter authenticationFilter() {
        var filter = new TokenAuthenticationFilter("/api/v1/**");
        var authenticationManager = new TokenAuthenticationManager(tokenService);
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }
}