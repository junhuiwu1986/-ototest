package com.course.testng.Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void beforSuite(){
        System.out.println(" 这是一个beforSuite方法   ");
    }
    @AfterSuite
    public void aftorSuite(){
        System.out.println("这是一个aftorSuite方法 ");
    }
}
