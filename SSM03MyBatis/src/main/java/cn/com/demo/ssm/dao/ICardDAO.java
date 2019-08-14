package cn.com.demo.ssm.dao;

import cn.com.demo.ssm.entity.ICardEntity;

import java.util.List;

public interface ICardDAO {
    public void save(ICardEntity cardEntity);

    public void update(ICardEntity cardEntity);

    public void delete(ICardEntity cardEntity);

    public ICardEntity findById(int icId);

    public List<ICardEntity> findAll();
}
