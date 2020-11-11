package com.ncepu.cloudyispringframework.transactiondemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncepu.cloudyispringframework.transactiondemo.mapper.UserMapper;
import com.ncepu.cloudyispringframework.transactiondemo.service.UserService;
import com.ncepu.cloudyispringframworkdemo.common.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<User> getAllUserByOrder(String orderColumn) {
        return userMapper.selectAllUserByOrder(orderColumn);
    }

    @Override
    public User getUserByAccountName(String accountName) {
        return userMapper.selectByAccountName(accountName);
    }

    @Transactional
    @Override
    public void addUser() {
        User user = new User("spring-transaction-test","spring-transaction-test", "test spring transaction");
        userMapper.insertUser(user);
        int a = 1 / 0;
    }
}
