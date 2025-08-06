package com.codewithmosh.store.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

@Configuration
public class SwaggerSecurityRules implements SecurityRules {
    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        registry.requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/swagger-ui.html/**").permitAll()
                .requestMatchers("/v3/api/docs/**").permitAll();
    }
}
