package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethoedDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);

    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void  logDeno() throws Exception {
        Reporter.log("这个是我添加的日志");
        throw new Exception("这是我与你新年股市的异常");
    }

    @Test
    public void  test4(){
        Assert.assertEquals("aaaa","aaaa");
        System.out.println("huifhiudhfksd112321424");
    }

}
