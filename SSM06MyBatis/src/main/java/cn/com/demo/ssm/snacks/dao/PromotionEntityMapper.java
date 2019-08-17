package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.PromotionEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

public interface PromotionEntityMapper {
    /**
     * 正在进行中得活动
     */
    @Select("select pm.* from snacks_fd_prm mp left outer join snacks_promotion pm on pm.prm_id=mp.prm_id where mp.fd_id=#{fdId}")
    public List<PromotionEntity> findPromotionsByFdId(int fdId);

    /**
     * 查询除同begin-end重叠得所有活动
     */
    @Select("select pm.* from snacks_fd_prm mp left outer join snacks_promotion pm on pm.prm_id=mp.prm_id where mp.fd_id=#{param1} and prm_start_time<=#{param3} and prm_end_time >=#{param2}")
    public List<PromotionEntity> findPromotions(int fdId, Timestamp begin, Timestamp end);


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

    @InsertProvider(type = PromotionEntitySqlProvider.class, method = "insertSelective")
    int insertSelective(PromotionEntity record);

    @Select({
            "select",
            "prm_id, prm_name, prm_start_time, prm_end_time, prm_discount, prm_detail",
            "from snacks_promotion",
            "where prm_id = #{prmId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "prm_id", property = "prmId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "prm_name", property = "prmName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "prm_start_time", property = "prmStartTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "prm_end_time", property = "prmEndTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "prm_discount", property = "prmDiscount", jdbcType = JdbcType.DOUBLE),
            @Result(column = "prm_detail", property = "prmDetail", jdbcType = JdbcType.VARCHAR)
    })
    PromotionEntity selectByPrimaryKey(Integer prmId);

    @UpdateProvider(type = PromotionEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
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