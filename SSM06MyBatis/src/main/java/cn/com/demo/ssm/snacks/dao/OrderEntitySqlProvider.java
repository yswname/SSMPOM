package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.OrderEntity;

public class OrderEntitySqlProvider {

    public String insertSelective(OrderEntity record) {
        BEGIN();
        INSERT_INTO("snacks_order");
        
        if (record.getOdId() != null) {
            VALUES("od_id", "#{odId,jdbcType=INTEGER}");
        }
        
        if (record.getOdCode() != null) {
            VALUES("od_code", "#{odCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOdTime() != null) {
            VALUES("od_time", "#{odTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOdUrId() != null) {
            VALUES("od_ur_id", "#{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdReceiverName() != null) {
            VALUES("od_receiver_name", "#{odReceiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getOdReceiverPhone() != null) {
            VALUES("od_receiver_phone", "#{odReceiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getOdReceiverAddress() != null) {
            VALUES("od_receiver_address", "#{odReceiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getOdStatus() != null) {
            VALUES("od_status", "#{odStatus,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderEntity record) {
        BEGIN();
        UPDATE("snacks_order");
        
        if (record.getOdTime() != null) {
            SET("od_time = #{odTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOdUrId() != null) {
            SET("od_ur_id = #{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdReceiverName() != null) {
            SET("od_receiver_name = #{odReceiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getOdReceiverPhone() != null) {
            SET("od_receiver_phone = #{odReceiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getOdReceiverAddress() != null) {
            SET("od_receiver_address = #{odReceiverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getOdStatus() != null) {
            SET("od_status = #{odStatus,jdbcType=INTEGER}");
        }
        
        WHERE("od_id = #{odId,jdbcType=INTEGER}");
        WHERE("od_code = #{odCode,jdbcType=VARCHAR}");
        
        return SQL();
    }
}