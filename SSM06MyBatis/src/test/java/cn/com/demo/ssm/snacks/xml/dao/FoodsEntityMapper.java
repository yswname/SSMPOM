package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.FoodsEntity;

public interface FoodsEntityMapper {
    int deleteByPrimaryKey(Integer fdId);

    int insert(FoodsEntity record);

    int insertSelective(FoodsEntity record);

    FoodsEntity selectByPrimaryKey(Integer fdId);

    int updateByPrimaryKeySelective(FoodsEntity record);

    int updateByPrimaryKeyWithBLOBs(FoodsEntity record);

    int updateByPrimaryKey(FoodsEntity record);
}