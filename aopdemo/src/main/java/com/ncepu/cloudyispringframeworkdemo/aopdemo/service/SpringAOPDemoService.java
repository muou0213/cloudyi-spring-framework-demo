package com.ncepu.cloudyispringframeworkdemo.aopdemo.service;

import org.springframework.stereotype.Service;

@Service("springAOPDemoService")
public class SpringAOPDemoService {

    public void wakeUpSleepyJoe(Long sleepTimeInMillisecond) {
        System.out.println("wake up joe!");
        try {
            Thread.sleep(sleepTimeInMillisecond);
//            throw new IllegalStateException("Joe does not want to wake up!");
        } catch (InterruptedException e) {
            System.out.println();
        }/* catch (IllegalStateException e) {
            System.out.println("exception caught in wakeUpSleepyJoe");
        }*/
        System.out.println("joe is wake");
    }
}
