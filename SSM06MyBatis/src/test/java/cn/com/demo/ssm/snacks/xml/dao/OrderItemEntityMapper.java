package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.OrderItemEntity;

public interface OrderItemEntityMapper {
    int deleteByPrimaryKey(Integer odItId);

    int insert(OrderItemEntity record);

    int insertSelective(OrderItemEntity record);

    OrderItemEntity selectByPrimaryKey(Integer odItId);

    int updateByPrimaryKeySelective(OrderItemEntity record);

    int updateByPrimaryKey(OrderItemEntity record);
}