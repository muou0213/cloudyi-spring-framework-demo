package com.ncepu.cloudyispringframeworkdemo.iocdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DependencyA implements ApplicationContextAware {

    @Autowired
    private DependencyB dependencyB;

    private ApplicationContext context;

    public void sayHello() {
        System.out.println("hello I am dependency a");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("destroy dependency a");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("dependency a post construct");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
