package com.ncepu.cloudyispringframework.transactiondemo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ncepu.cloudyispringframework.transactiondemo.service.UserService;
import com.ncepu.cloudyispringframworkdemo.common.entity.User;

public class TestSpringTransaction {

    @Test
    public void testSpringTransaction() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userServiceImpl", UserService.class);

        // test $ statement does not need @param
        /* List<User> allUser = userService.getAllUserByOrder("accountName");
        System.out.println(allUser.get(0).getAccountName());
        System.out.println(allUser.get(1).getAccountName());
        Assert.assertFalse(allUser.isEmpty());*/

        // test IF statement does not need @param
       /* User admin = userService.getUserByAccountName("admin");
        Assert.assertTrue(admin != null);
        Assert.assertTrue("admin".equals(admin.getAccountName()));*/

        userService.addUser();
        Assert.assertTrue(true);
    }
}
