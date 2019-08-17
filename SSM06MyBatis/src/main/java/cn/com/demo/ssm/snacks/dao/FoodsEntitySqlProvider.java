package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;

public class FoodsEntitySqlProvider {

    public String insertSelective(FoodsEntity record) {
        BEGIN();
        INSERT_INTO("snacks_foods");
        
        if (record.getFdId() != null) {
            VALUES("fd_id", "#{fdId,jdbcType=INTEGER}");
        }
        
        if (record.getFdName() != null) {
            VALUES("fd_name", "#{fdName,jdbcType=VARCHAR}");
        }
        
        if (record.getFdPrice() != null) {
            VALUES("fd_price", "#{fdPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getFdTaste() != null) {
            VALUES("fd_taste", "#{fdTaste,jdbcType=VARCHAR}");
        }
        
        if (record.getFdPackage() != null) {
            VALUES("fd_package", "#{fdPackage,jdbcType=VARCHAR}");
        }
        
        if (record.getFdInventory() != null) {
            VALUES("fd_inventory", "#{fdInventory,jdbcType=INTEGER}");
        }
        
        if (record.getFdDetail() != null) {
            VALUES("fd_detail", "#{fdDetail,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(FoodsEntity record) {
        BEGIN();
        UPDATE("snacks_foods");
        
        if (record.getFdName() != null) {
            SET("fd_name = #{fdName,jdbcType=VARCHAR}");
        }
        
        if (record.getFdPrice() != null) {
            SET("fd_price = #{fdPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getFdTaste() != null) {
            SET("fd_taste = #{fdTaste,jdbcType=VARCHAR}");
        }
        
        if (record.getFdPackage() != null) {
            SET("fd_package = #{fdPackage,jdbcType=VARCHAR}");
        }
        
        if (record.getFdInventory() != null) {
            SET("fd_inventory = #{fdInventory,jdbcType=INTEGER}");
        }
        
        if (record.getFdDetail() != null) {
            SET("fd_detail = #{fdDetail,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("fd_id = #{fdId,jdbcType=INTEGER}");
        
        return SQL();
    }
}