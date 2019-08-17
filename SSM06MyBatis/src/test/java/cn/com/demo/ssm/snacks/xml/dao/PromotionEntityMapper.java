package cn.com.demo.ssm.snacks.xml.dao;

import cn.com.demo.ssm.snacks.xml.entity.PromotionEntity;

public interface PromotionEntityMapper {
    int deleteByPrimaryKey(Integer prmId);

    int insert(PromotionEntity record);

    int insertSelective(PromotionEntity record);

    PromotionEntity selectByPrimaryKey(Integer prmId);

    int updateByPrimaryKeySelective(PromotionEntity record);

    int updateByPrimaryKey(PromotionEntity record);
}