package com.example.demo.withProperties;

import com.example.demo.MyBean;
import com.example.demo.withInjection.MyBeanWithInjectionImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWithPropertyInjectionConfig {

    @Value("${propertyOne}")
    private String propertyOne;

    @Value("${propertyTwo}")
    private String propertyTwo;

    @Bean
    public MyBean myBeanWithProperties() {
        return new MyBeanWithPropertiesImpl(propertyOne, propertyTwo);
    }

    @Bean
    public MyBean myOtherBeanWithProperties(@Value("${propertyOne}") final String propertyOne,
                                            @Value("${propertyTwo}") final String propertyTwo) {
        return new MyBeanWithPropertiesImpl(propertyOne, propertyTwo);
    }

    @Bean
    public MyBean myBeanWithMethodInjectedProperties() {
        return new MyBeanWithInjectionImpl(myOtherBeanWithProperties(null, null));
    }
}
