package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.PromotionEntity;
import cn.com.demo.ssm.snacks.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestPromotionEntityMapper {
    private PromotionEntityMapper promMapper;

    @Before
    public void before() {
        this.promMapper = MyBatisUtils.getSqlSession().getMapper(PromotionEntityMapper.class);
    }

    @Test
    public void testFindPromotionsByFdId() {
        List<PromotionEntity> promList = this.promMapper.findPromotionsByFdId(1);
        for (PromotionEntity prom : promList) {
            System.out.println(prom.getPrmName());
        }
    }

    @Test
    public void testFindPromotions() {
        Timestamp begin = new Timestamp(new Date(2019 - 1900, 6, 26).getTime());
        Timestamp end = new Timestamp(new Date(2019 - 1900, 6, 27).getTime());
        List<PromotionEntity> promList = this.promMapper.findPromotions(1, begin, end);
        for (PromotionEntity prom : promList) {
            System.out.println(prom.getPrmName());
        }
    }
}
