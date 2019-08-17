package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FoodsEntityMapper {
    @Delete({
        "delete from snacks_foods",
        "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fdId);

    @Insert({
        "insert into snacks_foods (fd_id, fd_name, ",
        "fd_price, fd_taste, ",
        "fd_package, fd_inventory, ",
        "fd_detail)",
        "values (#{fdId,jdbcType=INTEGER}, #{fdName,jdbcType=VARCHAR}, ",
        "#{fdPrice,jdbcType=DECIMAL}, #{fdTaste,jdbcType=VARCHAR}, ",
        "#{fdPackage,jdbcType=VARCHAR}, #{fdInventory,jdbcType=INTEGER}, ",
        "#{fdDetail,jdbcType=LONGVARCHAR})"
    })
    int insert(FoodsEntity record);

    @InsertProvider(type=FoodsEntitySqlProvider.class, method="insertSelective")
    int insertSelective(FoodsEntity record);

    @Select({
        "select",
        "fd_id, fd_name, fd_price, fd_taste, fd_package, fd_inventory, fd_detail",
        "from snacks_foods",
        "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="fd_id", property="fdId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="fd_name", property="fdName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fd_price", property="fdPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="fd_taste", property="fdTaste", jdbcType=JdbcType.VARCHAR),
        @Result(column="fd_package", property="fdPackage", jdbcType=JdbcType.VARCHAR),
        @Result(column="fd_inventory", property="fdInventory", jdbcType=JdbcType.INTEGER),
        @Result(column="fd_detail", property="fdDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    FoodsEntity selectByPrimaryKey(Integer fdId);

    @UpdateProvider(type=FoodsEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FoodsEntity record);

    @Update({
        "update snacks_foods",
        "set fd_name = #{fdName,jdbcType=VARCHAR},",
          "fd_price = #{fdPrice,jdbcType=DECIMAL},",
          "fd_taste = #{fdTaste,jdbcType=VARCHAR},",
          "fd_package = #{fdPackage,jdbcType=VARCHAR},",
          "fd_inventory = #{fdInventory,jdbcType=INTEGER},",
          "fd_detail = #{fdDetail,jdbcType=LONGVARCHAR}",
        "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(FoodsEntity record);

    @Update({
        "update snacks_foods",
        "set fd_name = #{fdName,jdbcType=VARCHAR},",
          "fd_price = #{fdPrice,jdbcType=DECIMAL},",
          "fd_taste = #{fdTaste,jdbcType=VARCHAR},",
          "fd_package = #{fdPackage,jdbcType=VARCHAR},",
          "fd_inventory = #{fdInventory,jdbcType=INTEGER}",
        "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FoodsEntity record);
}