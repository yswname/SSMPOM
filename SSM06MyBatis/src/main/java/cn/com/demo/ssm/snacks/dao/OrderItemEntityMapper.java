package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderItemEntityMapper {
    @Delete({
        "delete from snacks_order_item",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer odItId);

    @Insert({
        "insert into snacks_order_item (od_it_id, od_it_fd_id, ",
        "od_it_count, od_it_price, ",
        "od_id)",
        "values (#{odItId,jdbcType=INTEGER}, #{odItFdId,jdbcType=INTEGER}, ",
        "#{odItCount,jdbcType=INTEGER}, #{odItPrice,jdbcType=DOUBLE}, ",
        "#{odId,jdbcType=INTEGER})"
    })
    int insert(OrderItemEntity record);

    @InsertProvider(type=OrderItemEntitySqlProvider.class, method="insertSelective")
    int insertSelective(OrderItemEntity record);

    @Select({
        "select",
        "od_it_id, od_it_fd_id, od_it_count, od_it_price, od_id",
        "from snacks_order_item",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="od_it_id", property="odItId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="od_it_fd_id", property="odItFdId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_it_count", property="odItCount", jdbcType=JdbcType.INTEGER),
        @Result(column="od_it_price", property="odItPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="od_id", property="odId", jdbcType=JdbcType.INTEGER)
    })
    OrderItemEntity selectByPrimaryKey(Integer odItId);

    @UpdateProvider(type=OrderItemEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderItemEntity record);

    @Update({
        "update snacks_order_item",
        "set od_it_fd_id = #{odItFdId,jdbcType=INTEGER},",
          "od_it_count = #{odItCount,jdbcType=INTEGER},",
          "od_it_price = #{odItPrice,jdbcType=DOUBLE},",
          "od_id = #{odId,jdbcType=INTEGER}",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderItemEntity record);
}