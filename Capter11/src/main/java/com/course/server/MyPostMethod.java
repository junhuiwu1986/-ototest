package com.course.server;

import com.course.Bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description ="这是我全部的ｐｏｓｔｇｅｔ请求")
@RequestMapping("/v1")
public class MyPostMethod {
//    这个变量存储ｃｏｏｋｉｅｓ
    private static Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个登录接口",httpMethod = "post")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userNme",required = true) String userNme,
                        @RequestParam(value = "password",required = true)String password ){
        if (userNme.equals("lisi")&&password.equals("123456")) {
            cookie=new Cookie("login","1111");
            response.addCookie(cookie);
            return "恭喜你登陆成功";
        }
        return "用户名或密码错误！！！！";
    }


    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "post")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u
                            ){
           Cookie [] cookies=request.getCookies();
           User user;
        for (Cookie c:cookies
             ) {
            if (c.getName().equals("login")
                    &&c.getValue().equals("true")
                    &&u.getUserName().equals("lisi")
                    &&u.getPassword().equals("123456")
            ) {
                user=new User();
                user.setAge("100");
                user.setName("zhansan");
                user.setSex("111");

                return  user.toString();

            }

        }
     return "参数非法，清蒸确输入";

    }
}
