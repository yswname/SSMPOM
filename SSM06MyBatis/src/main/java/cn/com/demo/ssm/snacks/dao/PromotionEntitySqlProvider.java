package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.PromotionEntity;

public class PromotionEntitySqlProvider {

    public String insertSelective(PromotionEntity record) {
        BEGIN();
        INSERT_INTO("snacks_promotion");
        
        if (record.getPrmId() != null) {
            VALUES("prm_id", "#{prmId,jdbcType=INTEGER}");
        }
        
        if (record.getPrmName() != null) {
            VALUES("prm_name", "#{prmName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrmStartTime() != null) {
            VALUES("prm_start_time", "#{prmStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrmEndTime() != null) {
            VALUES("prm_end_time", "#{prmEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrmDiscount() != null) {
            VALUES("prm_discount", "#{prmDiscount,jdbcType=DOUBLE}");
        }
        
        if (record.getPrmDetail() != null) {
            VALUES("prm_detail", "#{prmDetail,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PromotionEntity record) {
        BEGIN();
        UPDATE("snacks_promotion");
        
        if (record.getPrmName() != null) {
            SET("prm_name = #{prmName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrmStartTime() != null) {
            SET("prm_start_time = #{prmStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrmEndTime() != null) {
            SET("prm_end_time = #{prmEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrmDiscount() != null) {
            SET("prm_discount = #{prmDiscount,jdbcType=DOUBLE}");
        }
        
        if (record.getPrmDetail() != null) {
            SET("prm_detail = #{prmDetail,jdbcType=VARCHAR}");
        }
        
        WHERE("prm_id = #{prmId,jdbcType=INTEGER}");
        
        return SQL();
    }
}