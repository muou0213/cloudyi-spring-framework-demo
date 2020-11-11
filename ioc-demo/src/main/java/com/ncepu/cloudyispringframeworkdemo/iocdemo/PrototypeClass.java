package com.ncepu.cloudyispringframeworkdemo.iocdemo;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// SCOPE_PROTOTYPE不支持DisposableBean接口方式
@Component
@Scope(value = SCOPE_PROTOTYPE)
public class PrototypeClass implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("prototype class destroy");
    }

    public void sayHello() {
        System.out.println("I am prototype class");
    }
}
