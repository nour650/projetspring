package com.example.pfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfaApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer configure(){



        return  new WebMvcConfigurer (){
            @Override
            public void addCorsMappings (CorsRegistry req){
                req.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
