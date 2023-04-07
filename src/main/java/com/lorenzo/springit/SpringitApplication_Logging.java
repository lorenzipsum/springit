package com.lorenzo.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//@SpringBootApplication
public class SpringitApplication_Logging {

    private static Logger log = LoggerFactory.getLogger(SpringitApplication.class);
    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication_Logging.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.error("error");
            log.warn("warn");
            log.info("info");
            log.debug("debug");
            log.trace("trace");

//            String[] beans = appContext.getBeanDefinitionNames();
//            Arrays.sort(beans);

//            System.out.printf("application context has %d beans%n", beans.length);
//            System.out.println("---------------------------------");
//            for (String bean: beans){
//                System.out.println(bean);
//            }
        };
    }
}
