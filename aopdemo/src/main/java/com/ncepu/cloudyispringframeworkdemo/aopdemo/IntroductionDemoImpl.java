package com.ncepu.cloudyispringframeworkdemo.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroductionDemoImpl implements IntroductionDemoInterface {
    private final static Logger logger = LoggerFactory.getLogger(IntroductionDemoImpl.class);

    @Override
    public void printIntroductionInfo() {
        logger.info("introduction method");
    }
}
