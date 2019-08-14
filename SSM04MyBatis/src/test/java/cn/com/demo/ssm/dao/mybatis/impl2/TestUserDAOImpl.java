package cn.com.demo.ssm.dao.mybatis.impl2;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUserDAOImpl {
    private IUserDAO userDAO;

    @Before
    public void before() {
        this.userDAO = new UserDAOImpl();
    }

    @Test
    public void testUpdate() {
        try {
            // 更新用户名为zhangsan的年龄，（20）
            // 更新某个对象的属性（年龄）
            // 1 获取要更新的对象
            UserEntity userEntity = this.userDAO.findByUserName("zhangsan");
            // 2 修改该对象需要更新的属性值
            userEntity.setUrAge(20);
            // 3 持久化对象
            this.userDAO.update(userEntity);
            // 4 断言更新成功
            userEntity = this.userDAO.findByUserName("zhangsan");
            Assert.assertEquals(20, userEntity.getUrAge());

            // 统一rollback commit close
        } catch (Exception e) {
            MyBatisUtils.getSqlSession().rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.getSqlSession().commit();
            MyBatisUtils.getSqlSession().close();
        }
    }
}
