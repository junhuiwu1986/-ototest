package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMthod {
    @Test(groups = "service")
    public void  test1(){
        System.out.println("service-1111111");
    }

    @Test(groups = "service")
    public void test2(){
        System.out.println("service--222222");
    }


    @Test(groups = "client")
    public  void test3(){
        System.out.println("33333");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("4444444");
    }
    @AfterGroups("service")
    public  void test5(){
        System.out.println("service---5555555");
    }
    @BeforeGroups("service")
    public  void test6(){
        System.out.println("secvice-----666666");
    }
    @AfterGroups("client")
    public void test7(){
        System.out.println("clinet---7777777");
    }

    @BeforeGroups("client")
    public void test8(){
        System.out.println("clinet---8888");
    }

}
