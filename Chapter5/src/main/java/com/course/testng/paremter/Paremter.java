package com.course.testng.paremter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paremter {
    @Test
    @Parameters({"name","age"})
    public  void pareter(String name,int age){
        System.out.println("name="+name  +";  age="+age);
    }



}
