package cn.com.demo.ssm.mybatis.dao;

import cn.com.demo.ssm.mybatis.entity.SnFoods;

public interface ISnFoodsDAO {
    public SnFoods findById(int fdId);

    public void save(SnFoods fd);

    public void update(SnFoods fd);

    public void delete(int fdId);
}
