package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;
import cn.com.demo.ssm.snacks.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

public class TestFoodsEntityMapper {
    FoodsEntityMapper foodMapper = null;

    @Before
    public void before() {
        this.foodMapper = MyBatisUtils.getSqlSession().getMapper(FoodsEntityMapper.class);
    }

    @Test
    public void testSelectByPrimaryKey() {
        FoodsEntity foods = this.foodMapper.selectByPrimaryKey(3);
        System.out.println(foods.getFdDetail());
    }
}
