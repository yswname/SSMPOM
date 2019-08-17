package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.PromotionEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PromotionEntityMapper {
    @Delete({
        "delete from snacks_promotion",
        "where prm_id = #{prmId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prmId);

    @Insert({
        "insert into snacks_promotion (prm_id, prm_name, ",
        "prm_start_time, prm_end_time, ",
        "prm_discount, prm_detail)",
        "values (#{prmId,jdbcType=INTEGER}, #{prmName,jdbcType=VARCHAR}, ",
        "#{prmStartTime,jdbcType=TIMESTAMP}, #{prmEndTime,jdbcType=TIMESTAMP}, ",
        "#{prmDiscount,jdbcType=DOUBLE}, #{prmDetail,jdbcType=VARCHAR})"
    })
    int insert(PromotionEntity record);

    @InsertProvider(type=PromotionEntitySqlProvider.class, method="insertSelective")
    int insertSelective(PromotionEntity record);

    @Select({
        "select",
        "prm_id, prm_name, prm_start_time, prm_end_time, prm_discount, prm_detail",
        "from snacks_promotion",
        "where prm_id = #{prmId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="prm_id", property="prmId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="prm_name", property="prmName", jdbcType=JdbcType.VARCHAR),
        @Result(column="prm_start_time", property="prmStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="prm_end_time", property="prmEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="prm_discount", property="prmDiscount", jdbcType=JdbcType.DOUBLE),
        @Result(column="prm_detail", property="prmDetail", jdbcType=JdbcType.VARCHAR)
    })
    PromotionEntity selectByPrimaryKey(Integer prmId);

    @UpdateProvider(type=PromotionEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PromotionEntity record);

    @Update({
        "update snacks_promotion",
        "set prm_name = #{prmName,jdbcType=VARCHAR},",
          "prm_start_time = #{prmStartTime,jdbcType=TIMESTAMP},",
          "prm_end_time = #{prmEndTime,jdbcType=TIMESTAMP},",
          "prm_discount = #{prmDiscount,jdbcType=DOUBLE},",
          "prm_detail = #{prmDetail,jdbcType=VARCHAR}",
        "where prm_id = #{prmId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PromotionEntity record);
}