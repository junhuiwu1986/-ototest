package course.cases;

import course.config.TestCongfig;
import course.model.GetUserInfoCase;
import course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取ｕｅｒｓｉｄ为１的用户信息")
    public  void getUserInfo() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase=session.selectOne("getUserInfo","1");
        System.out.println(TestCongfig.getUserInfoUrl);
    }

}
