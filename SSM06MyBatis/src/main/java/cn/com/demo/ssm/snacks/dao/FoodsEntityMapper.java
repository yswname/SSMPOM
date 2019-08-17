package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface FoodsEntityMapper {
    /**
     * @param currPageNo int 当前页码
     * @param number     int 每页显示的食品数量
     * @param keyword    String 查询条件（食品名称 参数 模糊查询）
     */
    @SelectProvider(type = FoodsEntitySqlProvider.class, method = "searchCurrPageFoods")
    public List<FoodsEntity> searchCurrPageFoods(int start, int number, String keyword);

    /**
     * 统计指定零食得销售量
     */
    @Select("select sum(od_it_count) from snacks_order_item where od_it_fd_id=#{fdId}")
    public int findFoodSaleCount(int fdId);


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

    @InsertProvider(type = FoodsEntitySqlProvider.class, method = "insertSelective")
    int insertSelective(FoodsEntity record);

    @Select({
            "select",
            "fd_id, fd_name, fd_price, fd_taste, fd_package, fd_inventory, fd_detail",
            "from snacks_foods",
            "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "fd_id", property = "fdId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "fd_name", property = "fdName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fd_price", property = "fdPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "fd_taste", property = "fdTaste", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fd_package", property = "fdPackage", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fd_inventory", property = "fdInventory", jdbcType = JdbcType.INTEGER),
            @Result(column = "fd_detail", property = "fdDetail", jdbcType = JdbcType.LONGVARCHAR)
    })
    FoodsEntity selectByPrimaryKey(Integer fdId);

    @UpdateProvider(type = FoodsEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
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