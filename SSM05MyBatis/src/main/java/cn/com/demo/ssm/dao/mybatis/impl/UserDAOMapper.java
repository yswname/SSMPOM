package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDAOMapper extends IUserDAO {
    @Override
    @Update("update dm_user set ur_name=#{urName}, ur_age=#{urAge} where ur_id=#{urId}")
    void update(UserEntity userEntity);

    @Insert("insert into dm_user (ur_user_name,ur_name,ur_age) values(#{urUserName}, #{urName}, #{urAge})")
    void save(UserEntity userEntity);

    @Override
    @Delete("delete from dm_user where ur_id=#{urId}")
    void delete(int urId);

    @Override
    @Select("select * from dm_user where ur_id=#{urId}")
    UserEntity findById(int urId);

    @Override
    @Select("select * from dm_user where ur_user_name=#{urUserName}")
    UserEntity findByUserName(String urUserName);

    @Override
    @Select("select * from dm_user")
    List<UserEntity> findAll();
}
