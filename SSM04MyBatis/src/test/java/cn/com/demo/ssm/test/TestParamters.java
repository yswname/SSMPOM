package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestParamters {
    public static void main(String[] args) {
        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        //List<UserEntity> userList = userDAO.findByUserNameOrId("zhangsan", 8);
//
        Map<String, Object> map = new HashMap<String, Object>();
        UserEntity user1 = new UserEntity();
        user1.setUrId(8);
        map.put("user1", user1);
        UserEntity user2 = new UserEntity();
        //user2.setUrUserName("zhangsan");
        map.put("user2", user2);
        List<UserEntity> userList = userDAO.findByUserNameOrId3(map);
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(3);
//        list.add(4);
//        list.add(8);
//        list.add(10);
//        List<UserEntity> userList = userDAO.findByUrIds(list);
        for (UserEntity user : userList) {
            System.out.println(user.getUrName());
        }

    }
}
