package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "tea")
public class GroupsOnClass1 {
    public void teacher(){
        System.out.println("teacher");
    }
}
