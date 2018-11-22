package com.course.testng;

import org.testng.annotations.Test;

public class IngnorTest {
    @Test
    public void ingnor1(){

        System.out.println("ingnor1");
    }
    //不执行测试
    @Test(enabled = false)
    public  void ingnor2(){
        System.out.println("ingnor2");
    }

    @Test(enabled = true)
    public  void ingnor3(){
        System.out.println("ingnor3");
    }
}
