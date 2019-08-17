package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.OrderItemEntity;

public class OrderItemEntitySqlProvider {

    public String insertSelective(OrderItemEntity record) {
        BEGIN();
        INSERT_INTO("snacks_order_item");
        
        if (record.getOdItId() != null) {
            VALUES("od_it_id", "#{odItId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItFdId() != null) {
            VALUES("od_it_fd_id", "#{odItFdId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItCount() != null) {
            VALUES("od_it_count", "#{odItCount,jdbcType=INTEGER}");
        }
        
        if (record.getOdItPrice() != null) {
            VALUES("od_it_price", "#{odItPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getOdId() != null) {
            VALUES("od_id", "#{odId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderItemEntity record) {
        BEGIN();
        UPDATE("snacks_order_item");
        
        if (record.getOdItFdId() != null) {
            SET("od_it_fd_id = #{odItFdId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItCount() != null) {
            SET("od_it_count = #{odItCount,jdbcType=INTEGER}");
        }
        
        if (record.getOdItPrice() != null) {
            SET("od_it_price = #{odItPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getOdId() != null) {
            SET("od_id = #{odId,jdbcType=INTEGER}");
        }
        
        WHERE("od_it_id = #{odItId,jdbcType=INTEGER}");
        
        return SQL();
    }
}