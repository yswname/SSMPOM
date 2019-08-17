package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class FoodsEntitySqlProvider {
    public String searchCurrPageFoods(int currPageNo, int number, String keyword) {
        BEGIN();
        SELECT("*");
        FROM("snacks_foods");
        if (keyword != null && !keyword.equals("")) {
            WHERE("fd_name like #{param3} or fd_taste like #{param3} or fd_detail like #{param3}");
        }
        String sql = "limit #{param1}, #{param2}";

        return SQL() + " " + sql;
    }

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
            VALUES("fd_price", "#{fdPrice,jdbcType=DOUBLE}");
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
            SET("fd_price = #{fdPrice,jdbcType=DOUBLE}");
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