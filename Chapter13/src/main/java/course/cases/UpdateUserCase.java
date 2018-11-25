package course.cases;

import course.config.TestCongfig;
import course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserCase {
    @Test(dependsOnGroups = "longinTrue",description = "这是一个更新操作")
    public  void updateUserInfo() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase=session.selectOne("updateUserInfo","1");
        System.out.println(TestCongfig.updateUserInfoUrl);
    }
    @Test(dependsOnGroups = "longinTrue",description = "这是一个删除新操作")
    public  void deleteUserInfo() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase=session.selectOne("updateUserInfo","2");
        System.out.println(TestCongfig.updateUserInfoUrl);
    }
}
