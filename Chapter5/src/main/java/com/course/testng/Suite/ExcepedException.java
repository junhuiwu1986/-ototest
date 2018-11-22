package com.course.testng.Suite;

import org.testng.annotations.Test;

public class ExcepedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void  runTimeExcepitionFalied(){


        System.out.println("Failed");
    }
    @Test(expectedExceptions =RuntimeException.class )
    public void runTimeExcceptionSucess(){
        System.out.println("sucess");
        throw new   RuntimeException();
    }
}
