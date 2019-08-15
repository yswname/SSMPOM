package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.RoleEntity;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

import java.util.List;

public class TestSeachMany {
    public static void main(String[] args) {
        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        UserEntity userEntity = userDAO.findById(1);
        List<RoleEntity> roleList = userEntity.getRoleList();
        System.out.println(userEntity.getUrName());
        if (roleList != null) {
            for (RoleEntity role : roleList) {
                System.out.println("   " + role.getRlName());
                List<UserEntity> userList = role.getUserList();
                if (userList != null) {
                    for (UserEntity user : userList) {
                        System.out.println("        " + user.getUrName());
                    }
                }
            }
        }
    }
}
