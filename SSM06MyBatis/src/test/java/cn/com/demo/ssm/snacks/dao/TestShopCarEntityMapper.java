package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.ShopCarEntity;
import cn.com.demo.ssm.snacks.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestShopCarEntityMapper {
    private ShopCarEntityMapper shopCarMapper;

    @Before
    public void before() {
        this.shopCarMapper = MyBatisUtils.getSqlSession().getMapper(ShopCarEntityMapper.class);
    }

    @Test
    public void testDeleteByUrId() {
        this.shopCarMapper.deleteByUrId(1);
        MyBatisUtils.getSqlSession().commit();
    }

    @Test
    public void testSearchByUrId() {
        List<ShopCarEntity> shopCarList = this.shopCarMapper.searchByUrId(1);
        for (ShopCarEntity s : shopCarList) {
            System.out.println(s.getShcFdId());
        }
    }

    @Test
    public void testSearchFdNumberByUrId() {
        int number = this.shopCarMapper.searchFdNumberByUrId(1);
        System.out.println(number);
    }
}
