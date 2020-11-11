package com.ncepu.cloudyispringframework.transactiondemo.service;

import java.util.List;

import com.ncepu.cloudyispringframworkdemo.common.entity.User;

public interface UserService {
    List<User> getAllUser();
    List<User> getAllUserByOrder(String orderColumn);
    User getUserByAccountName(String accountName);
    void addUser();

}
