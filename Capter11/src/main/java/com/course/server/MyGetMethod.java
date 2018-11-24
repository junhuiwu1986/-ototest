package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我的ｇｅｔ方法")
public class MyGetMethod {
    @RequestMapping(value = "/get/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "zhegget",httpMethod = "get")
   public String getCookies(HttpServletResponse response){

        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
       return "恭喜你获得cookies信息成功";
   }

//要求客户端谢带一个ｃｏｏｋｉｅｓ
@RequestMapping(value = "/get/with/cookies",method =RequestMethod.GET)
@ApiOperation(value = "要求客户端谢带一个ｃｏｏｋｉｅｓ",httpMethod = "get")
public String getWithCookies(HttpServletRequest request){
    Cookie[] cookies= request.getCookies();
     if (Objects.isNull(cookies)) {
         return  "请带个ｃｏｏｋｉ来";
     }
     for (Cookie cookie:cookies) {
         if (cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
                return "恭喜你访问成功";
         }
     }
        return "你必须携带ｃｏｏｋｉｅｓif访问";
}
/**
 *开发一个需要携带参数才能访问的ｇｅｔ请求
 * 第一种实现方式　　ＵＲＬ：ｋｅｙ＝ｖａｌｕｅ＆ｋｅｙ＝ｖａｌｕｅ
 * 我们来模拟商品列表
 */
@RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
@ApiOperation(value = "开发一个需要携带参数才能访问的ｇｅｔ请求",httpMethod = "get")
public Map<String,Integer>  getList(@RequestParam Integer start,@RequestParam Integer end){
    Map<String,Integer>  myList=new HashMap<>();
    myList.put("lisi",1213);
    myList.put("eeeeee",3333);
    myList.put("ehjerjehr",11111);
    return  myList;
}
/**
 *开发一个需要携带参数才能访问的ｇｅｔ请求
 * 第一种实现方式　　ＵＲＬ：ip:port/get/with/param/10/20
 * 我们来模拟商品列表
 */
@RequestMapping(value = "/get/with/param/{start}/{end}")
@ApiOperation(value ="开发一个需要携带参数才能访问的ｇｅｔ请求" ,httpMethod = "get")
public Map myGetList( @PathVariable Integer start,Integer end){
    Map<String,Integer>  myList=new HashMap<>();
    myList.put("lisi",1213);
    myList.put("eeeeee",3333);
    myList.put("ehjerjehr",11111);
    return  myList;
}





}
