package cn.com.demo.ssm.dao;

import cn.com.demo.ssm.entity.UserEntity;

import java.util.List;

public interface IUserDAO {
    public void save(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void delete(int urId);

    public UserEntity findById(int urId);

    public UserEntity findByUserName(String urUserName);

    public List<UserEntity> findAll();

    public List<UserEntity> findUsersByRlId(int rlId);
}
