package com.ncepu.cloudyispringframeworkdemo.jdbc;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<User> users = template.query("select userName, accountName, description from `user`;",
                (rs, rowNum) -> new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
        System.out.println("user list 的元素个数是：" + users.size());
        System.out.println("hello " + users.get(0).getAccountName());

    }
}
