package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer urId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}