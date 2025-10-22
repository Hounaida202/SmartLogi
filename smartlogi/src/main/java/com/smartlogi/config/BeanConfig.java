package com.smartlogi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    // ✅ Bean avec scope singleton (par défaut)
    @Bean
    public String messageSingleton() {
        return "Je suis un bean singleton";
    }

    // ✅ Bean avec scope prototype
    @Bean
    @Scope("prototype")
    public String messagePrototype() {
        return "Je suis un bean prototype - nouvelle instance à chaque fois";
    }
}