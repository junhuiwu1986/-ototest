package course.cases;

import course.config.TestCongfig;
import course.model.AddUserCase;
import course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class ＡddUserCase {
    @Test(dependsOnGroups = "longinTrue",description = "添加用户接口测试")
    public  void addUser() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        AddUserCase addUserCase=session.selectOne("addUserCase","1");
        System.out.println(TestCongfig.addUserUrl);
    }

}
