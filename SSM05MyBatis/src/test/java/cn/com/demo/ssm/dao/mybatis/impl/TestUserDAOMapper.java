package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestUserDAOMapper {
    IUserDAO userDAO = null;

    @Before
    public void before() {
        this.userDAO = MyBatisUtils.getSqlSession().getMapper(UserDAOMapper.class);
    }

    @Test
    public void testSave() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrUserName("yuangbo");
        userEntity.setUrName("袁博");
        userEntity.setUrAge(18);
        this.userDAO.save(userEntity);
        MyBatisUtils.getSqlSession().commit();
    }

    @Test
    public void testFindAll() {
        List<UserEntity> userList = this.userDAO.findAll();
        for (UserEntity user : userList) {
            System.out.println(user.getUrName() + "," + user.getUrUserName());
        }
    }
}
