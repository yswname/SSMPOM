package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.ICardDAO;
import cn.com.demo.ssm.entity.ICardEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CardDAOMapper extends ICardDAO {
    @Override
    @Insert("insert into dm_icard (ic_code, ic_address) values(#{icCode}, #{icAddress})")
    void save(ICardEntity cardEntity);

    @Override
    @Update("update dm_icard set ic_code=#{icCode}, ic_address=#{icAddress} where ic_id=#{icId}")
    void update(ICardEntity cardEntity);

    @Override
    @Delete("delete from dm_icard where ic_id=#{icId}")
    void delete(ICardEntity cardEntity);

    @Override
    @Select("select * from dm_icard where ic_id=#{icId}")
    @Results(
            {
                    @Result(column = "ic_id",
                            property = "user",
                            one = @One(select = "cn.com.demo.ssm.dao.mybatis.impl.UserDAOMapper.findById", fetchType = FetchType.LAZY))
            }
    )
    ICardEntity findById(int icId);

    @Override
    @Select("select * from dm_icard")
    List<ICardEntity> findAll();
}
