package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MyOtherBeanImpl implements MyBean {

    @Override
    public void someMethod() {
        System.out.println(getClass() + ".someMethod()");
    }
}
