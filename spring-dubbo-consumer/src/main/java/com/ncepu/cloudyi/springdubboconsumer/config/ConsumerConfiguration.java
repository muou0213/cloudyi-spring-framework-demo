package com.ncepu.cloudyi.springdubboconsumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.ncepu.cloudyi.springdubboconsumer.service")
@PropertySource("classpath:dubbo-consumer.properties")
@ComponentScan(value = {"com.ncepu.cloudyi.springdubboconsumer.service"})
public class ConsumerConfiguration {

}
