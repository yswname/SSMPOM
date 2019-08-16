package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 零配置
 */
public interface UserDAOMapper extends IUserDAO {
    @Override
    @Update("update dm_user set ur_name=#{urName}, ur_age=#{urAge} where ur_id=#{urId}")
    void update(UserEntity userEntity);

    @Insert("insert into dm_user (ur_user_name,ur_name,ur_age) values(#{urUserName}, #{urName}, #{urAge})")
    @Options(useGeneratedKeys = true, keyColumn = "ur_id", keyProperty = "urId")
    void save(UserEntity userEntity);

    @Override
    @Delete("delete from dm_user where ur_id=#{urId}")
    void delete(int urId);

    @Override
    @Select("select * from dm_user where ur_id=#{urId}")
    @Results({
            @Result(column = "ur_id", property = "urId", id = true),
            @Result(column = "ur_id",
                    property = "card",
                    one = @One(select = "cn.com.demo.ssm.dao.mybatis.impl.CardDAOMapper.findById", fetchType = FetchType.LAZY)),
            @Result(column = "ur_id",
                    property = "orderList",
                    many = @Many(select = "cn.com.demo.ssm.dao.mybatis.impl.OrderDAOMapper.findOrdersByUrId", fetchType = FetchType.LAZY)),
            @Result(column = "ur_id",
                    property = "roleList",
                    many = @Many(select = "cn.com.demo.ssm.dao.mybatis.impl.RoleDAOMapper.findRolesByUrId", fetchType = FetchType.LAZY))
    })
    UserEntity findById(int urId);

    @Override
    @Select("select * from dm_user where ur_user_name=#{urUserName}")
    UserEntity findByUserName(String urUserName);

    @Override
    @Select("select * from dm_user")
    List<UserEntity> findAll();

    @Override
    @Select("select ur.* from dm_rl_ur_map mp left outer join dm_user ur on mp.mp_ur_id=ur.ur_id where mp.mp_rl_id=#{rlId}")
    List<UserEntity> findUsersByRlId(int rlId);
}
