package com.example.demo.withInjection;

import com.example.demo.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBeanWithInjectionImpl implements MyBean {

    private final MyBean myBean;

    @Autowired
    public MyBeanWithInjectionImpl(final MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public void someMethod() {
        System.out.print("from injection: ");
        myBean.someMethod();
    }
}
