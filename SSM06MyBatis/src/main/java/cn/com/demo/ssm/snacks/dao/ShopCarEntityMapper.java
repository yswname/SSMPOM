package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.ShopCarEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ShopCarEntityMapper {
    // 添加
    // 删除
    // 更新数量
    // clear？--》根据用户id删除
    @Delete("delete from snacks_shop_car where shc_ur_id=#{urId}")
    public void deleteByUrId(int urId);

    // getItems？--》或用户Id的ShopItem对象
    @Select("select * from snacks_shop_car where shc_ur_id=#{urId}")
    public List<ShopCarEntity> searchByUrId(int urId);

    // 商品数量--》某个用户的每种商品数量的和
    @Select("select sum(shc_count) from snacks_shop_car where shc_ur_id=#{urId}")
    public int searchFdNumberByUrId(int urId);

    @Delete({
            "delete from snacks_shop_car",
            "where shc_id = #{shcId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shcId);

    @Insert({
            "insert into snacks_shop_car (shc_id, shc_ur_id, ",
            "shc_fd_id, shc_count, ",
            "shc_add_time)",
            "values (#{shcId,jdbcType=INTEGER}, #{shcUrId,jdbcType=INTEGER}, ",
            "#{shcFdId,jdbcType=INTEGER}, #{shcCount,jdbcType=INTEGER}, ",
            "#{shcAddTime,jdbcType=TIMESTAMP})"
    })
    int insert(ShopCarEntity record);

    @InsertProvider(type = ShopCarEntitySqlProvider.class, method = "insertSelective")
    int insertSelective(ShopCarEntity record);

    @Select({
            "select",
            "shc_id, shc_ur_id, shc_fd_id, shc_count, shc_add_time",
            "from snacks_shop_car",
            "where shc_id = #{shcId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "shc_id", property = "shcId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "shc_ur_id", property = "shcUrId", jdbcType = JdbcType.INTEGER),
            @Result(column = "shc_fd_id", property = "shcFdId", jdbcType = JdbcType.INTEGER),
            @Result(column = "shc_count", property = "shcCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "shc_add_time", property = "shcAddTime", jdbcType = JdbcType.TIMESTAMP)
    })
    ShopCarEntity selectByPrimaryKey(Integer shcId);

    @UpdateProvider(type = ShopCarEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopCarEntity record);

    @Update({
            "update snacks_shop_car",
            "set shc_ur_id = #{shcUrId,jdbcType=INTEGER},",
            "shc_fd_id = #{shcFdId,jdbcType=INTEGER},",
            "shc_count = #{shcCount,jdbcType=INTEGER},",
            "shc_add_time = #{shcAddTime,jdbcType=TIMESTAMP}",
            "where shc_id = #{shcId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopCarEntity record);
}