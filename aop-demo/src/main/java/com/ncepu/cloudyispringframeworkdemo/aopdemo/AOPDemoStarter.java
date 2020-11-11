package com.ncepu.cloudyispringframeworkdemo.aopdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ncepu.cloudyispringframeworkdemo.aopdemo.service.SpringAOPDemoService;

public class AOPDemoStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SpringAOPDemoService
                springAOPDemoService = context.getBean("springAOPDemoService", SpringAOPDemoService.class);
        springAOPDemoService.wakeUpSleepyJoe(500L);
    }
}
