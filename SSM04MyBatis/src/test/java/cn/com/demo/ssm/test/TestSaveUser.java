package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.ICardEntity;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

public class TestSaveUser {
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(18);
        userEntity.setUrName("李康1");
        userEntity.setUrUserName("likang1");

        ICardEntity cardEntity = new ICardEntity();
        cardEntity.setIcAddress("长沙");
        cardEntity.setIcCode("0007");

        userEntity.setCard(cardEntity);
        cardEntity.setUser(userEntity);

        IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);
        userDAO.save(userEntity);
        cardEntity.setIcId(userEntity.getUrId());
        //cardDAO.save(cardEntity);
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
