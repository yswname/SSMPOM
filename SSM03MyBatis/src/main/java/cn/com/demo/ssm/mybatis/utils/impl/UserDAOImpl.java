package cn.com.demo.ssm.mybatis.utils.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDAOImpl implements IUserDAO {
    @Override
    public List<UserEntity> findByUrIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<UserEntity> findByUrIds2(int[] ids) {
        return null;
    }

    @Override
    public List<UserEntity> findByUserNameOrId2(Map<String, Object> userNameAndId) {
        return null;
    }

    @Override
    public List<UserEntity> findByUserNameOrId(String userName, int urId) {
        return null;
    }

    @Override
    public List<UserEntity> findUsersByRlId(int rlId) {
        return null;
    }

    @Override
    public void save(UserEntity userEntity) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            session.insert("cn.com.demo.ssm.dao.IUserDAO.save", userEntity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public void update(UserEntity userEntity) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            session.update("cn.com.demo.ssm.dao.IUserDAO.update", userEntity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public void delete(int urId) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            session.delete("cn.com.demo.ssm.dao.IUserDAO.delete", urId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public UserEntity findById(int urId) {
        UserEntity userEntity = null;
        try {
            SqlSession session = MyBatisUtils.getSqlSession();
            userEntity = session.selectOne("cn.com.demo.ssm.dao.IUserDAO.findById", urId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.close();
        }
        return userEntity;
    }

    @Override
    public UserEntity findByUserName(String urUserName) {
        UserEntity userEntity = null;
        try {
            SqlSession session = MyBatisUtils.getSqlSession();
            userEntity = session.selectOne("cn.com.demo.ssm.dao.IUserDAO.findByUserName", urUserName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.close();
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userList = null;
        try {
            SqlSession session = MyBatisUtils.getSqlSession();
            userList = session.selectList("cn.com.demo.ssm.dao.IUserDAO.findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.close();
        }
        return userList;
    }
}
