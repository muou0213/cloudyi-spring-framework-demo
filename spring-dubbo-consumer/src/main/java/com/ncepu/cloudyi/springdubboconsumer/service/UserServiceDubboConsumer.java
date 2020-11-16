package com.ncepu.cloudyi.springdubboconsumer.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import com.ncepu.cloudyi.cloudyiapi.api.UserServiceApi;
import com.ncepu.cloudyi.cloudyiapi.entity.User;

@Component("userServiceDubboConsumer")
public class UserServiceDubboConsumer {

    @DubboReference(version = "1.0.0")
    private UserServiceApi userService;


    public List<User> getUsers() {
        return userService.getUsers();
    }
}
