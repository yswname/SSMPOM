package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.ShopCarEntity;

public interface ShopCarEntityMapper {
    int deleteByPrimaryKey(Integer shcId);

    int insert(ShopCarEntity record);

    int insertSelective(ShopCarEntity record);

    ShopCarEntity selectByPrimaryKey(Integer shcId);

    int updateByPrimaryKeySelective(ShopCarEntity record);

    int updateByPrimaryKey(ShopCarEntity record);
}