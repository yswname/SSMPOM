package cn.com.demo.ssm.mybatis.utils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class TestMyBatisUtils {
    @Test
    public void testGetSession() {
        SqlSession session = MyBatisUtils.getSqlSession();
        Assert.assertNotNull(session);
    }
}
