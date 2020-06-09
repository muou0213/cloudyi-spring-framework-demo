package com.ncepu.cloudyispringframeworkdemo.aopdemo;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Map<Class<?>, Logger> loggerCache = new HashMap();

    //定义切入点
    @Pointcut(value = "execution(public * com.ncepu.cloudyispringframeworkdemo"
            + ".aopdemo.service.*.*(..))")
    private void allPublicServiceMethods() {}

    // 方法执行之前打印进入日志
    @Before("com.ncepu.cloudyispringframeworkdemo.aopdemo.LogAspect.allPublicServiceMethods()")
    public void enterMethodLogger(JoinPoint joinPoint) {
        Class<?> aClass = joinPoint.getTarget().getClass();
        Logger logger = getLogger(aClass);

        logger.info("before");
    }

    // 方法执行之后打印日志
    @After("com.ncepu.cloudyispringframeworkdemo.aopdemo.LogAspect.allPublicServiceMethods()")
    public void exitMethodLogger(JoinPoint joinPoint) {
        Class<?> aClass = joinPoint.getTarget().getClass();
        Logger logger = getLogger(aClass);

        logger.info("after");
    }

    @Around("com.ncepu.cloudyispringframeworkdemo.aopdemo.LogAspect.allPublicServiceMethods()"
            + "&& args(sleepTimeInMillisecond, ..)")
    public void runTimeRecorder(ProceedingJoinPoint pjp, Long sleepTimeInMillisecond) throws Throwable {
        Class<?> aClass = pjp.getTarget().getClass();
        Logger logger = getLogger(aClass);
        logger.info("around starts");

        long start = System.currentTimeMillis();
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            logger.info("exception caught in runTimeRecorder");
        }
//        pjp.proceed();
        long end = System.currentTimeMillis();

        logger.info("around ends");
    }

    @AfterThrowing(pointcut="com.ncepu.cloudyispringframeworkdemo.aopdemo.LogAspect.allPublicServiceMethods()",
    throwing = "ex")
    public void throwableCaseHandler(JoinPoint jp, IllegalStateException ex) {
        Class<?> aClass = jp.getTarget().getClass();
        Logger logger = getLogger(aClass);
        logger.info("after throwing");
    }

    private Logger getLogger(Class<?> aClass) {
        Logger logger = loggerCache.get(aClass);
        if (logger == null) {
            logger = LoggerFactory.getLogger(aClass);
            loggerCache.put(aClass, logger);
        }
        return logger;
    }


    @DeclareParents(value="com.ncepu.cloudyispringframeworkdemo.aopdemo.service.*+", defaultImpl=IntroductionDemoImpl
            .class)
    public static IntroductionDemoInterface mixin;

    @Before("com.ncepu.cloudyispringframeworkdemo.aopdemo.LogAspect.allPublicServiceMethods() && this(introductionDemo)")
    public void recordUsage(IntroductionDemoInterface introductionDemo) {
        introductionDemo.printIntroductionInfo();
    }
}
