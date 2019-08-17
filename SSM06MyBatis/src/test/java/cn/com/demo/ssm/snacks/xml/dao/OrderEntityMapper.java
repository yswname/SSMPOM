package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

public interface OrderEntityMapper {
    int deleteByPrimaryKey(@Param("odId") Integer odId, @Param("odCode") String odCode);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(@Param("odId") Integer odId, @Param("odCode") String odCode);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}