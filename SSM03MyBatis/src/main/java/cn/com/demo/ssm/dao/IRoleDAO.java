package cn.com.demo.ssm.dao;

import cn.com.demo.ssm.entity.RoleEntity;

import java.util.List;

public interface IRoleDAO {
    public RoleEntity findById(int rlId);

    public List<RoleEntity> findAll();

    public List<RoleEntity> findRolesByUrId(int urId);
}
