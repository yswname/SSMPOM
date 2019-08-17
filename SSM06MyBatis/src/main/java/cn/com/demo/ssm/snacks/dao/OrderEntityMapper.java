package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.OrderEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderEntityMapper {
    @Delete({
        "delete from snacks_order",
        "where od_id = #{odId,jdbcType=INTEGER}",
          "and od_code = #{odCode,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("odId") Integer odId, @Param("odCode") String odCode);

    @Insert({
        "insert into snacks_order (od_id, od_code, ",
        "od_time, od_ur_id, ",
        "od_receiver_name, od_receiver_phone, ",
        "od_receiver_address, od_status)",
        "values (#{odId,jdbcType=INTEGER}, #{odCode,jdbcType=VARCHAR}, ",
        "#{odTime,jdbcType=TIMESTAMP}, #{odUrId,jdbcType=INTEGER}, ",
        "#{odReceiverName,jdbcType=VARCHAR}, #{odReceiverPhone,jdbcType=VARCHAR}, ",
        "#{odReceiverAddress,jdbcType=VARCHAR}, #{odStatus,jdbcType=INTEGER})"
    })
    int insert(OrderEntity record);

    @InsertProvider(type=OrderEntitySqlProvider.class, method="insertSelective")
    int insertSelective(OrderEntity record);

    @Select({
        "select",
        "od_id, od_code, od_time, od_ur_id, od_receiver_name, od_receiver_phone, od_receiver_address, ",
        "od_status",
        "from snacks_order",
        "where od_id = #{odId,jdbcType=INTEGER}",
          "and od_code = #{odCode,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="od_id", property="odId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="od_code", property="odCode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="od_time", property="odTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="od_ur_id", property="odUrId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_receiver_name", property="odReceiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="od_receiver_phone", property="odReceiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="od_receiver_address", property="odReceiverAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="od_status", property="odStatus", jdbcType=JdbcType.INTEGER)
    })
    OrderEntity selectByPrimaryKey(@Param("odId") Integer odId, @Param("odCode") String odCode);

    @UpdateProvider(type=OrderEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderEntity record);

    @Update({
        "update snacks_order",
        "set od_time = #{odTime,jdbcType=TIMESTAMP},",
          "od_ur_id = #{odUrId,jdbcType=INTEGER},",
          "od_receiver_name = #{odReceiverName,jdbcType=VARCHAR},",
          "od_receiver_phone = #{odReceiverPhone,jdbcType=VARCHAR},",
          "od_receiver_address = #{odReceiverAddress,jdbcType=VARCHAR},",
          "od_status = #{odStatus,jdbcType=INTEGER}",
        "where od_id = #{odId,jdbcType=INTEGER}",
          "and od_code = #{odCode,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderEntity record);
}