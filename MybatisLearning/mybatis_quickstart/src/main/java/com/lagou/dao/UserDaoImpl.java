package com.lagou.dao;

import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 抽象的abstract class继承接口是不用实现方法
 */
public class UserDaoImpl implements IUserDao {
    /**
     * 传统的dao层开发方式
     * @return
     * @throws IOException
     */
    public List<User> findAll() throws IOException {
        //Resource工具类，配置文件的加载，把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是事务不会提交
        //所以在进行增删改  要手动提交事务
        //sqlSessionFactory.openSession(true)表名会自动提交事务
        List<User> users = sqlSession.selectList("user.findAll");
        sqlSession.close();
        return users;
    }

    public List<User> findByCondition(User user) {
        return null;
    }

    public List<User> findByIds(int[] ids) {
        return null;
    }

}
