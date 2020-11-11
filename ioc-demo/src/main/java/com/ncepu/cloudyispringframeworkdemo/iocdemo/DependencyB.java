package com.ncepu.cloudyispringframeworkdemo.iocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyB {

    @Autowired
    private DependencyA dependencyA;
}
