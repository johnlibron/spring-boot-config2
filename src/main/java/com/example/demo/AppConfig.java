package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        return new MyBeanImpl();
    }

    @Bean({"myOtherBean", "beanNameTwo"})
    public MyBean myOtherBeanWithDifferentName() {
        return new MyOtherBeanImpl();
    }
}
