package com.lorenzo.springit;

import com.lorenzo.springit.config.SpringitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication_Properties {
    @Autowired
    private SpringitProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication_Properties.class, args);
    }

    @Value("${my.property}")
    private String myProperty;

    @Bean
    @Profile("dev")
    CommandLineRunner runner() {
        return args -> {
            System.out.println(properties.getWelcomeMsg());
            System.out.println(myProperty);
        };
    }
}
