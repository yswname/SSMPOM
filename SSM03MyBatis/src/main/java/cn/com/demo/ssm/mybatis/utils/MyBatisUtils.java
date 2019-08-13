package cn.com.demo.ssm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * 1 获取SqlSession
 * 2 关闭SqlSession
 * <p>
 * 内部实现
 * 1 初始化一次，把SqlSessionFactoyr作为全局对象保存下来，重复使用
 * 2 实现SqlSession的多线程安全
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        init();
    }

    private static void init() {
        try {
            // 1 加载配置文件
            Reader resource = Resources.getResourceAsReader("mybatis.xml");
            // new Builder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // builder
            factory = builder.build(resource);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 1 从local中获取同步对象
     * 2 判断是否为null
     * 2.1 如果为null
     * 1）从factory中open一个新sqlSession
     * 1.1）判断factory是否为null，如果是，init
     * 1.2）open新session
     * 2）讲sqlSession对象设置local中实现同步
     * 3）返回sqlSession
     * 2.2 如果不是null
     * 直接返回
     */
    public static SqlSession getSqlSession() {
        SqlSession session = null;
//        if (factory == null) {
//            init();
//        }
//        session = factory.openSession();
//             * 1 从local中获取同步对象
        session = threadLocal.get();
//                * 2 判断是否为null
//                *   2.1 如果为null
        if (session == null) {
//                *     1）从factory中open一个新sqlSession
//                *       1.1）判断factory是否为null，如果是，init
            if (factory == null) {
                init();
            }
//                *       1.2）open新session
            session = factory.openSession();
//                *     2）讲sqlSession对象设置local中实现同步
            threadLocal.set(session);
        }
        return session;
    }

    public static void close() {
        SqlSession session = threadLocal.get();
        if (session != null) {
            threadLocal.set(null);
            session.close();
        }
    }


}
