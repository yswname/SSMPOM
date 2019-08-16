package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IOrderDAO;
import cn.com.demo.ssm.entity.OrderEntity;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderDAOMapper extends IOrderDAO {
    @Override
    @Select("select * from dm_order where od_id=#{odId}")
    OrderEntity findById(int odId);

    @Override
    @Select("select * from dm_order where od_ur_id=#{urId}")
    @Results(
            @Result(column = "od_ur_id",
                    property = "user",
                    one = @One(select = "cn.com.demo.ssm.dao.mybatis.impl.UserDAOMapper.findById", fetchType = FetchType.LAZY))
    )
    List<OrderEntity> findOrdersByUrId(int urId);

    @Override
    @Select("select * from dm_order")
    List<OrderEntity> findAll();
}
