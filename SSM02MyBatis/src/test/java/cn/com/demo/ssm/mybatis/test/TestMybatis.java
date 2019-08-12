package cn.com.demo.ssm.mybatis.test;

import cn.com.demo.ssm.mybatis.entity.SnFoods;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws Exception {
        InputStream input = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(input);
        SqlSession session = factory.openSession();
        SnFoods foods = session.selectOne("cn.com.demo.ssm.mybatis.dao.ISnFoodsDAO.findById", 1);
        System.out.println(foods);
    }
}
