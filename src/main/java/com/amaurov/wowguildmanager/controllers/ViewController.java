package com.amaurov.wowguildmanager.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
        registry.addViewController( "/" ).setViewName( "forward:/user/characters" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
    }
}
