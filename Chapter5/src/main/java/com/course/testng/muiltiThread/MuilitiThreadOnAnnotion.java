package com.course.testng.muiltiThread;

import org.testng.annotations.Test;

public class MuilitiThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 10)
    public void test(){
        System.out.println("1");
        System.out.printf("Thresd : %s%n",Thread.currentThread().getId());
    }
}
