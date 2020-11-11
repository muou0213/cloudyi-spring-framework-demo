package com.ncepu.cloudyispringframework.transactiondemo;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ncepu.cloudyispringframework.transactiondemo")
@MapperScan("com.ncepu.cloudyispringframework.transactiondemo.mapper")
public class AppConfig {
    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = BeanUtils.instantiateClass(BasicDataSource.class);
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("passwd");
        return basicDataSource;
    }

    @Bean
    @DependsOn("dataSource")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource());
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @DependsOn("dataSource")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        //        sessionFactory.setDataSource(dataSource());
        sessionFactory.setDataSource(dataSource);
        //第一种方法使用BeanWrapperImpl
       /* BeanWrapperImpl beanWrapper = new BeanWrapperImpl(sessionFactory);
        Resource[] mapperLocations = (Resource[])beanWrapper.convertForProperty("classpath:mappers/*.xml", "mapperLocations");
        sessionFactory.setMapperLocations(mapperLocations);*/

        // 第二种方法使用resourceResolver
        Resource[] resources = resourceResolver.getResources("classpath:mappers/*.xml");
        sessionFactory.setMapperLocations(resources);
        return sessionFactory.getObject();
    }
}
