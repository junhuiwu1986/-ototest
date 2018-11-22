package com.course.testng.Suite;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    public void denPendTest(){
        System.out.println("run test");
    }
}
