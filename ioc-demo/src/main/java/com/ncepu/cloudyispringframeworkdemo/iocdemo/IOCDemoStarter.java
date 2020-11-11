package com.ncepu.cloudyispringframeworkdemo.iocdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;

public class IOCDemoStarter {
    public static void main(String[] args) throws ClassNotFoundException {
        // 测试单例模式以及非单例模式的循环依赖
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DependencyA dependencyA = context.getBean("dependencyA", DependencyA.class);
        dependencyA.sayHello();

        PrototypeClass prototypeInstance = context.getBean("prototypeClass", PrototypeClass.class);

        prototypeInstance.sayHello();

        context.close();*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        List<String> classNames =
                SpringFactoriesLoader.loadFactoryNames(AppConfig.class, IOCDemoStarter.class.getClassLoader());
        System.out.println(classNames.get(0));
        context.register(Class.forName(classNames.get(0)));
        context.refresh();
        DependencyA dependencyA = context.getBean("dependencyA", DependencyA.class);
        dependencyA.sayHello();
        context.close();
    }
}
