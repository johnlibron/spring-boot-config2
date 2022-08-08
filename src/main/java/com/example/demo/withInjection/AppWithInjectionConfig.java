package com.example.demo.withInjection;

import com.example.demo.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWithInjectionConfig {

    private final MyBean myOtherBean;

    @Autowired
    public AppWithInjectionConfig(MyBean myOtherBean) {
        this.myOtherBean = myOtherBean;
    }

    @Bean
    public MyBean myBeanWithInjection(final MyBean myBean) {
        return new MyBeanWithInjectionImpl(myBean);
    }

    @Bean
    public MyBean myOtherBeanWithInjection(@Qualifier("myOtherBean") final MyBean myBean) {
        return new MyBeanWithInjectionImpl(myBean);
    }

    @Bean
    public MyBean myBeanWithAutowiredDependency() {
        return new MyBeanWithInjectionImpl(myOtherBean);
    }

    @Bean
    public MyBean myBeanWithMethodInjectedDependency() {
        return new MyBeanWithInjectionImpl(myBeanWithAutowiredDependency());
    }
}
