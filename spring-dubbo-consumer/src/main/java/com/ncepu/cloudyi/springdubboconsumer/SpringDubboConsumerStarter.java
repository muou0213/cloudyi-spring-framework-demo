package com.ncepu.cloudyi.springdubboconsumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ncepu.cloudyi.cloudyiapi.entity.User;
import com.ncepu.cloudyi.springdubboconsumer.config.ConsumerConfiguration;
import com.ncepu.cloudyi.springdubboconsumer.service.UserServiceDubboConsumer;

public class SpringDubboConsumerStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final UserServiceDubboConsumer userServiceDubboConsumer = (UserServiceDubboConsumer) context.getBean(
                "userServiceDubboConsumer");
        List<User> users = userServiceDubboConsumer.getUsers();
        System.out.println(users);
    }
}
