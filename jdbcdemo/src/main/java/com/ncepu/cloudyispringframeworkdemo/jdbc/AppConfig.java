package com.ncepu.cloudyispringframeworkdemo.jdbc;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver)aClass.newInstance();
            DataSource dataSource = new SimpleDriverDataSource(driver,
                    "jdbc:mysql://127.0.0.1:3306/spring_demo?useUnicode=true&characterEncoding=UTF-8"
                            + "&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
                    "root",
                    "passwd");
            return dataSource;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
