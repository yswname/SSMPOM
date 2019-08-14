package cn.com.demo.ssm.test;

import cn.com.demo.ssm.dao.IUserDAO;
import cn.com.demo.ssm.entity.UserEntity;
import cn.com.demo.ssm.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestDynBind {
    public static void main(String[] args) {
        // 接口和映射文件，需要按规范（要求）进行定义和编写
        // 1 映射文件中的命名空间，一定要是被绑定的接口名称（包含完整的包）
        // 2 被绑定的接口的方法，需要同mapper里面的sql id一一对应
        SqlSession session = MyBatisUtils.getSqlSession();
        // 实现动态绑定（内存中创建了一个类，实现了接口的方法同sql的id绑定）
        IUserDAO userDAO = session.getMapper(IUserDAO.class);
        // save 用户
        UserEntity userEntity = new UserEntity();
        userEntity.setUrUserName("zhaoliu");
        userEntity.setUrName("赵六");
        userEntity.setUrAge(18);
//        userDAO.save(userEntity);
//        session.commit();

        userEntity = userDAO.findByUserName("zhangsan");
        System.out.println(userEntity.getUrName());
    }
}
