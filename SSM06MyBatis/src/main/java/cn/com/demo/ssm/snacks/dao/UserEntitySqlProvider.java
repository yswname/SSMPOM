package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.UserEntity;

public class UserEntitySqlProvider {

    public String insertSelective(UserEntity record) {
        BEGIN();
        INSERT_INTO("snacks_user");
        
        if (record.getUrId() != null) {
            VALUES("ur_id", "#{urId,jdbcType=INTEGER}");
        }
        
        if (record.getUrUserName() != null) {
            VALUES("ur_user_name", "#{urUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrName() != null) {
            VALUES("ur_name", "#{urName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrPassword() != null) {
            VALUES("ur_password", "#{urPassword,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserEntity record) {
        BEGIN();
        UPDATE("snacks_user");
        
        if (record.getUrUserName() != null) {
            SET("ur_user_name = #{urUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrName() != null) {
            SET("ur_name = #{urName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrPassword() != null) {
            SET("ur_password = #{urPassword,jdbcType=VARCHAR}");
        }
        
        WHERE("ur_id = #{urId,jdbcType=INTEGER}");
        
        return SQL();
    }
}