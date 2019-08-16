package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IRoleDAO;
import cn.com.demo.ssm.entity.RoleEntity;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDAOMapper extends IRoleDAO {
    @Override
    @Select("select * from dm_role where rl_id=#{rlId}")
    RoleEntity findById(int rlId);

    @Override
    @Select("select * from dm_role")
    List<RoleEntity> findAll();

    @Override
    @Select("select rl.* from dm_role rl right outer join dm_rl_ur_map mp on mp.mp_rl_id=rl.rl_id where mp.mp_ur_id=#{urId}")
    @Results(
            {
                    @Result(column = "rl_id",
                            property = "userList",
                            many = @Many(select = "cn.com.demo.ssm.dao.mybatis.impl.UserDAOMapper.findUsersByRlId", fetchType = FetchType.LAZY))
            }
    )
    List<RoleEntity> findRolesByUrId(int urId);
}
