package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

//
    @Test
    public void testCase1(){
        System.out.println("这是testCase11111方法");

    }

    @Test
    public void testCase2(){
           System.out.println("这是testCase222222方法");
       }



    @BeforeMethod
    public void beforMthod(){
        System.out.println("这是beforMthod方法");
    }
    @AfterMethod
    public  void afterMthod(){

        System.out.println("这是afterMthod方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是afterClass方法");
    }

    @BeforeClass
    public void beforClass(){
        System.out.println("这是beforClass方法");
    }
    @BeforeSuite
    public void beforSuit(){
        System.out.println("这是beforSuit方法");
    }

    @AfterSuite
    public  void aftorSuit(){
        System.out.println("这是aftorSuite方法");
    }

}
