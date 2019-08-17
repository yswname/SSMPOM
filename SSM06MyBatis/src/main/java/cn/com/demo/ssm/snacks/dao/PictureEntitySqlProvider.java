package cn.com.demo.ssm.snacks.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.snacks.entity.PictureEntity;

public class PictureEntitySqlProvider {

    public String insertSelective(PictureEntity record) {
        BEGIN();
        INSERT_INTO("snacks_picture");
        
        if (record.getPicId() != null) {
            VALUES("pic_id", "#{picId,jdbcType=INTEGER}");
        }
        
        if (record.getPicUrl() != null) {
            VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getPicType() != null) {
            VALUES("pic_type", "#{picType,jdbcType=INTEGER}");
        }
        
        if (record.getPicDesc() != null) {
            VALUES("pic_desc", "#{picDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPicFdId() != null) {
            VALUES("pic_fd_id", "#{picFdId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PictureEntity record) {
        BEGIN();
        UPDATE("snacks_picture");
        
        if (record.getPicType() != null) {
            SET("pic_type = #{picType,jdbcType=INTEGER}");
        }
        
        if (record.getPicDesc() != null) {
            SET("pic_desc = #{picDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPicFdId() != null) {
            SET("pic_fd_id = #{picFdId,jdbcType=INTEGER}");
        }
        
        WHERE("pic_id = #{picId,jdbcType=INTEGER}");
        WHERE("pic_url = #{picUrl,jdbcType=VARCHAR}");
        
        return SQL();
    }
}