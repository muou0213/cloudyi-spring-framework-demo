package com.ncepu.cloudyispringframeworkdemo.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
@ComponentScan("com.ncepu.cloudyispringframeworkdemo.aopdemo")
public class AppConfig {
}
