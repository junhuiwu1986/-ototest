package com.course.httpclient.demo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpclientDemo {
    @Test
    public void test(){

//存放我们的结果
        String result;
//        获取服务端ｕｒｌ
        HttpGet  get=new HttpGet("https://www.baidu.com");
        HttpClient client=new DefaultHttpClient();
        try {
//            执行客户端的访问
            HttpResponse response= client.execute(get);
            result= EntityUtils.toString(response.getEntity(),"utf-8");
//            打印访问结果
            System.out.println(result+"baiduuiui111111");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("用来存放我们的结果");
    }
}