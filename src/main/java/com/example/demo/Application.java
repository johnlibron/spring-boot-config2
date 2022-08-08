package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final MyBean myBean;

    @Resource(name = "myOtherBean")
    private MyBean myOtherBeanWithWrongName;

    private final MyBeanWithoutInterface myBeanWithoutInterface;

    private final MyBean myBeanWithMethodInjectedDependency;

    private final MyBean myBeanWithMethodInjectedProperties;

    @Autowired
    public Application(MyBean myBean, MyBeanWithoutInterface myBeanWithoutInterface, MyBean myBeanWithMethodInjectedDependency, MyBean myBeanWithMethodInjectedProperties) {
        this.myBean = myBean;
        this.myBeanWithoutInterface = myBeanWithoutInterface;
        this.myBeanWithMethodInjectedDependency = myBeanWithMethodInjectedDependency;
        this.myBeanWithMethodInjectedProperties = myBeanWithMethodInjectedProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        myBean.someMethod();
        myOtherBeanWithWrongName.someMethod();
        myBeanWithoutInterface.someMethod();
        myBeanWithMethodInjectedDependency.someMethod();
        myBeanWithMethodInjectedProperties.someMethod();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
