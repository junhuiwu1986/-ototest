package course.cases;

import course.config.TestCongfig;
import course.model.InterfaceName;
import course.model.LoginCase;
import course.utils.ConfigFile;
import course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "",description = "")
    public void beforeTest(){
        TestCongfig.loginUrl= ConfigFile.getUrl(InterfaceName.LOGIN) ;
        TestCongfig.getUserInfoUrl=ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestCongfig.getUserListUrl=ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestCongfig.addUserUrl=ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestCongfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestCongfig.defaultHttpClient=new DefaultHttpClient();
    }

    @Test(groups = "loginTrue",description = "用户登录接口测试成功")
    public void  loginTrue() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("longin","1");
        System.out.println(TestCongfig.loginUrl);
        System.out.println(loginCase.toString());

    }

    @Test(groups = "loginFalse",description = "用户登录接口测试失败")
    public void  loginFalse() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("longin","2");
        System.out.println(TestCongfig.loginUrl);
        System.out.println(loginCase.toString());

    }


}
