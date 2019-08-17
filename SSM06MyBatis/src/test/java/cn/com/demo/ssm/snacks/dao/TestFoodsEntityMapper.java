package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.FoodsEntity;
import cn.com.demo.ssm.snacks.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestFoodsEntityMapper {
    FoodsEntityMapper foodMapper = null;

    @Before
    public void before() {
        this.foodMapper = MyBatisUtils.getSqlSession().getMapper(FoodsEntityMapper.class);
    }

    @Test
    public void testSearchCurrPageFoods() {
        int currPage = 3;
        List<FoodsEntity> foodsList = this.foodMapper.searchCurrPageFoods((currPage - 1) * 3, 3, null);
        for (FoodsEntity food : foodsList) {
            System.out.println(food.getFdId());
        }
    }

    @Test
    public void testSelectByPrimaryKey() {
        FoodsEntity foods = this.foodMapper.selectByPrimaryKey(3);
        System.out.println(foods.getFdDetail());
    }
}
