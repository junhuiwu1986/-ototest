package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "v1",description ="DEmo" )
@RequestMapping("/v1")
public class Demo {
//    执行ｓｑｌ语句的对象
    @Autowired
    private SqlSessionTemplate template;
//    执行ｓｑｌ语句
   @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
   @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
   public int getUserCount(){
    int rseult= template.selectOne("getUserCount");

     return rseult;
    }


}
