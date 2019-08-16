package cn.com.demo.ssm.dao.mybatis.impl2;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;

import java.util.List;
import java.util.Map;

public class UserDAOImpl implements IUserDAO {
    private IUserDAO userDAO = MyBatisUtils.getSqlSession().getMapper(IUserDAO.class);

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
        try {
            this.userDAO.save(userEntity);
        } catch (Exception e) {
            MyBatisUtils.rollback();
            throw new RuntimeException();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public void update(UserEntity userEntity) {
        try {
            this.userDAO.update(userEntity);
        } catch (Exception e) {
            MyBatisUtils.rollback();
            throw new RuntimeException();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public void delete(int urId) {
        try {
            this.userDAO.delete(urId);
        } catch (Exception e) {
            MyBatisUtils.rollback();
            throw new RuntimeException();
        } finally {
            MyBatisUtils.close();
        }
    }

    @Override
    public UserEntity findById(int urId) {
        return this.userDAO.findById(urId);
    }

    @Override
    public UserEntity findByUserName(String urUserName) {
        return this.userDAO.findByUserName(urUserName);
    }

    @Override
    public List<UserEntity> findAll() {
        return this.userDAO.findAll();
    }
}
