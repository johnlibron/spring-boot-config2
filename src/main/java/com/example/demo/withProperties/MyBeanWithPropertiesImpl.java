package com.example.demo.withProperties;

import com.example.demo.MyBean;

public class MyBeanWithPropertiesImpl implements MyBean {

    private final String propertyOne;
    private final String propertyTwo;

    public MyBeanWithPropertiesImpl(String propertyOne, String propertyTwo) {
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    @Override
    public void someMethod() {
        System.out.println(getClass()
                + ".someMethod() with properties: "
                + " propertyOne = " + propertyOne
                + ", propertyTwo = " + propertyTwo
        );
    }
}
