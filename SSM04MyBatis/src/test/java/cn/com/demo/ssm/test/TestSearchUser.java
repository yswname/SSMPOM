package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.OrderEntity;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

import java.util.List;

public class TestSearchUser {
    public static void main(String[] args) {
        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        UserEntity userEntity = userDAO.findById(17);
        System.out.println(userEntity.getUrName());
        System.out.println(userEntity.getCard().getIcAddress());
        List<OrderEntity> orderList = userEntity.getOrderList();
        if (orderList != null) {
            for (OrderEntity order : orderList) {
                System.out.println(order.getOdName() + "," + order.getOdId());
            }
        }

//        userEntity = userDAO.findByUserName("likang2");
//        System.out.println(userEntity.getUrName());
//        System.out.println(userEntity.getCard().getIcAddress());
    }
}
