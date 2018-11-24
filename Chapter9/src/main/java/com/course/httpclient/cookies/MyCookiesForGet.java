package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle  bundle;
    private     CookieStore store;
    @BeforeTest
    public void berFortest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String  uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client= new DefaultHttpClient();
        HttpResponse     response =client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("12122324"+result);
//  获取cookies信息
               this.store =client.getCookieStore();
                List<Cookie>    cookieList=store.getCookies();
        for (Cookie cookie:cookieList
             ) {
        String  name= cookie.getName();
        String  value= cookie.getValue();
            System.out.println("name ="+name+";value  ="+value);
            
        }
    }
    //        get请求
    @Test(dependsOnMethods = {"testGetCookies"})
    public  void testGetWithCookies() throws IOException {
    String uri=bundle.getString("test.get.with.cookies");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient   clinet = new DefaultHttpClient();
//        设置cookies信息
        clinet.setCookieStore(this.store);
      HttpResponse  response=clinet.execute(get);
//        获取响应状态吗
        int statsCode =response.getStatusLine().getStatusCode();
        System.out.println("statsCode＝＝＝"+statsCode);
        if (statsCode == 200) {
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result+"获取的ｇｅｔ信息");
        }

    }

}