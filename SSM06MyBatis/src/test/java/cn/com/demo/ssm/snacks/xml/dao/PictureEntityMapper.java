package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.PictureEntity;
import org.apache.ibatis.annotations.Param;

public interface PictureEntityMapper {
    int deleteByPrimaryKey(@Param("picId") Integer picId, @Param("picUrl") String picUrl);

    int insert(PictureEntity record);

    int insertSelective(PictureEntity record);

    PictureEntity selectByPrimaryKey(@Param("picId") Integer picId, @Param("picUrl") String picUrl);

    int updateByPrimaryKeySelective(PictureEntity record);

    int updateByPrimaryKey(PictureEntity record);
}