package com.losung360.contact.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addRedirectViewController("/","/swagger-ui/index.html");
    }
}
