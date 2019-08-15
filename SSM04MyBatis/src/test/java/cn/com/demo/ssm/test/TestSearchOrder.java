package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IOrderDAO;
import cn.com.demo.ssm.entity.OrderEntity;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

import java.util.List;

public class TestSearchOrder {
    public static void main(String[] args) {
        IOrderDAO orderDAO = MyBatisUtils.getSqlSession().getMapper(IOrderDAO.class);
        List<OrderEntity> orderList = orderDAO.findAll();
        if (orderList != null) {
            for (OrderEntity order : orderList) {
                System.out.println(order.getOdId() + "," + order.getOdName());
                // 获取订单中关联得用户
                UserEntity userEntity = order.getUser();
                if (userEntity != null) {
                    System.out.println("     " + userEntity.getUrName());
                    // 检查关联出来得用户里面，是否有关联对应得订单
                    List<OrderEntity> orderListSub = userEntity.getOrderList();
                    for (OrderEntity order2 : orderListSub) {
                        System.out.println("             " + order2.getOdId() + "," + order2.getOdName());
                    }
                }
            }
        }
    }
}
