package cn.com.demo.ssm.snacks.dao;

import cn.com.demo.ssm.snacks.entity.PictureEntity;
import cn.com.demo.ssm.snacks.utils.MyBatisUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestPictureEntityMapper {
    PictureEntityMapper picMapper = null;

    @Before
    public void before() {
        picMapper = MyBatisUtils.getSqlSession().getMapper(PictureEntityMapper.class);
    }

    @Test
    public void testFindPictures() {
        List<PictureEntity> picList = this.picMapper.findPictures(3, 1);
        for (PictureEntity pic : picList) {
            System.out.println(pic.getPicUrl());
        }
    }
}
