package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

public class TestSearchUser {
    public static void main(String[] args) {
        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        UserEntity userEntity = userDAO.findById(17);
        System.out.println(userEntity.getUrName());
        System.out.println(userEntity.getCard().getIcAddress());

        userEntity = userDAO.findByUserName("likang2");
        System.out.println(userEntity.getUrName());
        System.out.println(userEntity.getCard().getIcAddress());
    }
}
