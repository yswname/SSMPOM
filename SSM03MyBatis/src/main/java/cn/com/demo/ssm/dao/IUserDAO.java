package cn.com.demo.ssm.dao;

import cn.com.demo.ssm.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface IUserDAO {
    public void save(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void delete(int urId);

    public UserEntity findById(int urId);

    public UserEntity findByUserName(String urUserName);

    public List<UserEntity> findAll();

    public List<UserEntity> findUsersByRlId(int rlId);

    public List<UserEntity> findByUserNameOrId(String userName, int urId);

    public List<UserEntity> findByUserNameOrId2(Map<String, Object> userNameAndId);

    public List<UserEntity> findByUrIds(List<Integer> ids);

    public List<UserEntity> findByUrIds2(int[] ids);
}
