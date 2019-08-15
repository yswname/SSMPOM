package cn.com.demo.ssm.dao;

import cn.com.demo.ssm.entity.OrderEntity;

import java.util.List;

public interface IOrderDAO {
    public OrderEntity findById(int odId);

    public List<OrderEntity> findOrdersByUrId(int urId);

    public List<OrderEntity> findAll();
}
