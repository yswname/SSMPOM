package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.PictureEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PictureEntityMapper {
    @Select("select * from snacks_picture where pic_fd_id=#{param1} and pic_type=#{param2}")
    public List<PictureEntity> findPictures(int fdId, int picType);


    @Delete({
            "delete from snacks_picture",
            "where pic_id = #{picId,jdbcType=INTEGER}",
            "and pic_url = #{picUrl,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("picId") Integer picId, @Param("picUrl") String picUrl);


    @Insert({
            "insert into snacks_picture (pic_id, pic_url, ",
            "pic_type, pic_desc, ",
            "pic_fd_id)",
            "values (#{picId,jdbcType=INTEGER}, #{picUrl,jdbcType=VARCHAR}, ",
            "#{picType,jdbcType=INTEGER}, #{picDesc,jdbcType=VARCHAR}, ",
            "#{picFdId,jdbcType=INTEGER})"
    })
    int insert(PictureEntity record);

    @InsertProvider(type = PictureEntitySqlProvider.class, method = "insertSelective")
    int insertSelective(PictureEntity record);

    @Select({
            "select",
            "pic_id, pic_url, pic_type, pic_desc, pic_fd_id",
            "from snacks_picture",
            "where pic_id = #{picId,jdbcType=INTEGER}",
            "and pic_url = #{picUrl,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "pic_id", property = "picId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "pic_type", property = "picType", jdbcType = JdbcType.INTEGER),
            @Result(column = "pic_desc", property = "picDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pic_fd_id", property = "picFdId", jdbcType = JdbcType.INTEGER)
    })
    PictureEntity selectByPrimaryKey(@Param("picId") Integer picId, @Param("picUrl") String picUrl);

    @UpdateProvider(type = PictureEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PictureEntity record);

    @Update({
            "update snacks_picture",
            "set pic_type = #{picType,jdbcType=INTEGER},",
            "pic_desc = #{picDesc,jdbcType=VARCHAR},",
            "pic_fd_id = #{picFdId,jdbcType=INTEGER}",
            "where pic_id = #{picId,jdbcType=INTEGER}",
            "and pic_url = #{picUrl,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PictureEntity record);
}