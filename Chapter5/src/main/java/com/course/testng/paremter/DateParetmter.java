package com.course.testng.paremter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DateParetmter {
    @Test(dataProvider = "date")
    public void testDateParetmer(String  name,int age){


        System.out.println("name ="+ name +"  ;age ="+ age );

    }


    @DataProvider(name="date")
    public  Object[][] providerdate(){
                  Object[][]  o= new Object[][]{
                          {"zhansan",10},
                          {"lisi",25},
                          {"wanger",34},

                  };

            return o;
    }

    @Test(dataProvider = "mehthed")
    public void testDateParetmer2(String  name,int age){


        System.out.println("name222 ="+ name +"  ;age ="+ age );

    }

    @Test(dataProvider = "mehthed")
    public void testDateParetmer1(String  name,int age){


        System.out.println("name111 ="+ name +"  ;age ="+ age );

    }

    @DataProvider(name="mehthed")
    public  Object[][] mehthedtest(Method method){
        Object[][]  o= null;
        if ( method.getName().equals("testDateParetmer2")){
            o= new Object[][]{
                    {"zhansan33333",10},
                    {"lisi",25},
                    {"wanger",34},

            };
        }else if (method.getName().equals("testDateParetmer1")){

            o= new Object[][]{
                    {"zhansan1111",10},
                    {"lisi",25},
                    {"wanger",34},

            };


        };

        return o;
    }

}
