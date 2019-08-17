package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.ShopCarEntity;

public class ShopCarEntitySqlProvider {

    public String insertSelective(ShopCarEntity record) {
        BEGIN();
        INSERT_INTO("snacks_shop_car");
        
        if (record.getShcId() != null) {
            VALUES("shc_id", "#{shcId,jdbcType=INTEGER}");
        }
        
        if (record.getShcUrId() != null) {
            VALUES("shc_ur_id", "#{shcUrId,jdbcType=INTEGER}");
        }
        
        if (record.getShcFdId() != null) {
            VALUES("shc_fd_id", "#{shcFdId,jdbcType=INTEGER}");
        }
        
        if (record.getShcCount() != null) {
            VALUES("shc_count", "#{shcCount,jdbcType=INTEGER}");
        }
        
        if (record.getShcAddTime() != null) {
            VALUES("shc_add_time", "#{shcAddTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ShopCarEntity record) {
        BEGIN();
        UPDATE("snacks_shop_car");
        
        if (record.getShcUrId() != null) {
            SET("shc_ur_id = #{shcUrId,jdbcType=INTEGER}");
        }
        
        if (record.getShcFdId() != null) {
            SET("shc_fd_id = #{shcFdId,jdbcType=INTEGER}");
        }
        
        if (record.getShcCount() != null) {
            SET("shc_count = #{shcCount,jdbcType=INTEGER}");
        }
        
        if (record.getShcAddTime() != null) {
            SET("shc_add_time = #{shcAddTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("shc_id = #{shcId,jdbcType=INTEGER}");
        
        return SQL();
    }
}