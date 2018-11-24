package com.course.httpclient.cookies;

import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
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
        HttpResponse response =client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("12122324"+result);
//  获取cookies信息
        this.store =client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for (Cookie cookie:cookieList
        ) {
            String  name= cookie.getName();
            String  value= cookie.getValue();
            System.out.println("name ="+name+";value  ="+value);

        }
    }
    //        get请求
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostGetCookies() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testUrl=this.url+uri;
//        声明一个ｃｌｉｅｎｔ方法
        DefaultHttpClient client=new DefaultHttpClient();
//        声明一个ｐｏｓｔ方法
        HttpPost  posts= new HttpPost(testUrl);
//        s申明一个ｊｓｏｎ对象
        JSONObject  parame=new JSONObject();
        parame.put("name","lisi");
        parame.put("age",10);
//   设置请求头信息  header
        posts.setHeader("content-type","application/json");
//        将参数信息添加到方法里面
        StringEntity  entity=new StringEntity(parame.toString(),"utf-8");
        posts.setEntity(entity);
        //声明一个对象存储
        String result;
//        设置ｃｏｏｋｉｅｓ
        client.setCookieStore(this.store);
       HttpResponse response= client.execute(posts);
//       获取相应结果
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("12122324"+result);
//将返回接转换ｗｅｉｊｓｏｎ
        JSONObject  resultjson=new JSONObject(result);


//处理结果，判断是否符合预期
       String  names= (String) resultjson.get("lisi");
       String status =(String) resultjson.get("status");
        Assert.assertEquals("sucess",names);
        Assert.assertEquals("1ha和",status);




    }
}
