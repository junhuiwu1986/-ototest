package com.course.testng.Suite;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)//单位毫秒
    public void testSuscess(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("suscess");

    }
    @Test(timeOut = 2000)
    public void testFaile(){
        System.out.println("Faile");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
