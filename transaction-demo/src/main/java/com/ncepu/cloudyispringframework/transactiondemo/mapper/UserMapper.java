package com.ncepu.cloudyispringframework.transactiondemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ncepu.cloudyispringframworkdemo.common.entity.User;

@Mapper
public interface UserMapper {
    List<User> selectAllUser();
    List<User> selectAllUserByOrder(String accountName);
    User selectByAccountName(String accountName);

    void insertUser(User user);


}
