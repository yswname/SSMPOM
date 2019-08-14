package cn.com.demo.ssm.mybatis.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.impl.UserDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUserDAOImpl {
    private IUserDAO userDAO = null;

    @Before
    public void before() {
        userDAO = new UserDAOImpl();
    }

    @Test
    public void testSave() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(18);
        userEntity.setUrName("王五1");
        userEntity.setUrUserName("wangwu1");

        this.userDAO.save(userEntity);
    }

    @Test
    public void testFindByUserName() {
        UserEntity userEntity = this.userDAO.findByUserName("wangwu");
        Assert.assertEquals("王五", userEntity.getUrName());
    }
}
