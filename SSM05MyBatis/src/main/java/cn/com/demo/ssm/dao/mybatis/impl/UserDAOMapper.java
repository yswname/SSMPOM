package cn.com.demo.ssm.dao.mybatis.impl;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;

/**
 * 零配置
 */
public interface UserDAOMapper extends IUserDAO {
    @Override
    @Update("update dm_user set ur_name=#{urName}, ur_age=#{urAge} where ur_id=#{urId}")
    void update(UserEntity userEntity);

    @Insert("insert into dm_user (ur_user_name,ur_name,ur_age) values(#{urUserName}, #{urName}, #{urAge})")
    @Options(useGeneratedKeys = true, keyColumn = "ur_id", keyProperty = "urId")
    void save(UserEntity userEntity);

    @Override
    @Delete("delete from dm_user where ur_id=#{urId}")
    void delete(int urId);

    @Override
    @Select("select * from dm_user where ur_id=#{urId}")
    @Results({
            @Result(column = "ur_id", property = "urId", id = true),
            @Result(column = "ur_id",
                    property = "card",
                    one = @One(select = "cn.com.demo.ssm.dao.mybatis.impl.CardDAOMapper.findById", fetchType = FetchType.LAZY)),
            @Result(column = "ur_id",
                    property = "orderList",
                    many = @Many(select = "cn.com.demo.ssm.dao.mybatis.impl.OrderDAOMapper.findOrdersByUrId", fetchType = FetchType.LAZY)),
            @Result(column = "ur_id",
                    property = "roleList",
                    many = @Many(select = "cn.com.demo.ssm.dao.mybatis.impl.RoleDAOMapper.findRolesByUrId", fetchType = FetchType.LAZY))
    })
    UserEntity findById(int urId);

    @Override
    @Select("select * from dm_user where ur_user_name=#{urUserName}")
    UserEntity findByUserName(String urUserName);

    @Override
    @Select("select * from dm_user")
    List<UserEntity> findAll();

    @Override
    @Select("select ur.* from dm_rl_ur_map mp left outer join dm_user ur on mp.mp_ur_id=ur.ur_id where mp.mp_rl_id=#{rlId}")
    List<UserEntity> findUsersByRlId(int rlId);

    @Override
    @SelectProvider(type = MySQLProvider.class, method = "findByUserNameOrId")
    List<UserEntity> findByUserNameOrId(String userName, int urId);

    @Override
    List<UserEntity> findByUserNameOrId2(Map<String, Object> userNameAndId);

    @Override
    List<UserEntity> findByUserNameOrId3(Map<String, Object> userNameAndId);

    @Override
    @SelectProvider(type = MySQLProvider.class, method = "findByUrIds")
    List<UserEntity> findByUrIds(List<Integer> ids);

    @Override
    List<UserEntity> findByUrIds2(int[] ids);

    public static class MySQLProvider {
        public String findByUrIds(Map map) {
            String sql = null;
            sql = new SQL() {{
                BEGIN();
                SELECT("*");
                FROM("dm_user");
                List<Integer> ids = (List<Integer>) map.get("list");
                //WHERE("ur_id in (2,3,4,5)");
                if (ids != null && ids.size() > 0) {
                    String condition = "ur_id in (";
                    for (int id : ids) {
                        condition += id + ",";
                    }
                    condition += ids.get(ids.size() - 1);
                    condition += ")";

                    WHERE(condition);
                } else {
                    WHERE("1<>1");
                }
            }}.toString();
            return sql;
        }

        public String findByUserNameOrId(String userName, int urId) {
            String sql = null;

            sql = new SQL() {
                {
                    BEGIN();//  清空
                    SELECT("*");
                    FROM("dm_user");
                    if (userName != null || urId > 0) {
                        //WHERE("ur_user_name=#{param1} or ur_id=#{param2}");
                        String condition = "";
                        if (userName != null) {
                            condition += "ur_user_name=#{param1} ";
                        }
                        if (urId > 0) {
                            condition += " or ur_id=#{param2}";
                        }
                        condition = condition.trim();
                        if (condition.startsWith("or")) {
                            condition = condition.substring(2);
                        }
                        WHERE(condition);
                    } else {
                        WHERE("1<>1");
                    }
                }
            }.toString();

            return sql;
        }
    }
}
