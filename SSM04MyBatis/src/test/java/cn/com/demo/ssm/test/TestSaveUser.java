package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.ICardDAO;
import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.ICardEntity;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

public class TestSaveUser {
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(18);
        userEntity.setUrName("李康2");
        userEntity.setUrUserName("likang2");

        ICardEntity cardEntity = new ICardEntity();
        cardEntity.setIcAddress("长沙");
        cardEntity.setIcCode("0007");

        userEntity.setCard(cardEntity);
        cardEntity.setUser(userEntity);
        // 获取用户DAO
        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        // 获取Card DAO
        ICardDAO cardDAO = MyBatisUtils.getSqlSession().getMapper(ICardDAO.class);
        // 持久化用户
        userDAO.save(userEntity);
        // 获取用户id，设置给Card对象（从对象）
        cardEntity.setIcId(userEntity.getUrId());
        // 持久化从对象
        cardDAO.save(cardEntity);

        MyBatisUtils.getSqlSession().commit();
        System.out.println(userEntity.getUrId());
        // Hibernate session.save(userEntity)
        // save(user)
        // save(card)

//        Connection conn = null;
//        PreparedStatement pstmt = conn.prepareStatement("sql",[2,3])
//        ResultSet rs = pstmt.getGeneratedKeys();

    }
}
