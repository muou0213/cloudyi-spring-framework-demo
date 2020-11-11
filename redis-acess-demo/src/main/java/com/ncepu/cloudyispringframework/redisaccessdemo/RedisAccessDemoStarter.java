package com.ncepu.cloudyispringframework.redisaccessdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RedisAccessDemoStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccessExample accessExample = context.getBean("accessExample", AccessExample.class);
        accessExample.testOpHash();
    }
}
