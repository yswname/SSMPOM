package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserEntityMapper {
    @Delete({
        "delete from snacks_user",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer urId);

    @Insert({
        "insert into snacks_user (ur_id, ur_user_name, ",
        "ur_name, ur_password)",
        "values (#{urId,jdbcType=INTEGER}, #{urUserName,jdbcType=VARCHAR}, ",
        "#{urName,jdbcType=VARCHAR}, #{urPassword,jdbcType=VARCHAR})"
    })
    int insert(UserEntity record);

    @InsertProvider(type=UserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(UserEntity record);

    @Select({
        "select",
        "ur_id, ur_user_name, ur_name, ur_password",
        "from snacks_user",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ur_id", property="urId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ur_user_name", property="urUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ur_name", property="urName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ur_password", property="urPassword", jdbcType=JdbcType.VARCHAR)
    })
    UserEntity selectByPrimaryKey(Integer urId);

    @UpdateProvider(type=UserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
        "update snacks_user",
        "set ur_user_name = #{urUserName,jdbcType=VARCHAR},",
          "ur_name = #{urName,jdbcType=VARCHAR},",
          "ur_password = #{urPassword,jdbcType=VARCHAR}",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}