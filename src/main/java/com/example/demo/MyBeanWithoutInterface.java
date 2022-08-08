package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MyBeanWithoutInterface {

    public void someMethod() {
        System.out.println(getClass() + ".someMethod()");
    }
}
