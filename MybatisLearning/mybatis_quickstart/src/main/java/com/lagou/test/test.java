package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.dao.UserDaoImpl;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void test1() throws IOException {
        //Resource工具类，配置文件的加载，把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是事务不会提交
        //所以在进行增删改  要手动提交事务
        //sqlSessionFactory.openSession(true)表名会自动提交事务
        List<User> users = sqlSession.selectList("user.findAll");
        for (User user : users){
            System.out.println(user.getId());
        }
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //Resource工具类，配置文件的加载，把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//默认开启一个事务，但是事务不会提交
        //所以在进行增删改  要手动提交事务
        //sqlSessionFactory.openSession(true)表名会自动提交事务
        User user = new User();
        user.setId(3);
        user.setUserName("hahha");
        sqlSession.insert("user.saveUser",user);

        sqlSession.close();
    }

    /**
     * 传统的dao层开发方式，麻烦，需要实现文件流转换与SQL编写
     * @throws IOException
     */
    @Test
    public void test3() throws IOException{
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user.getId());
        }
    }


    /**
     * 使用动态代理方式，创建一个userDao的代理对象，通过该对象执行文件流的存入与解析
     */
    @Test
    public void test4() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//默认开启一个事务，但是事务不会提交
        IUserDao dao = sqlSession.getMapper(IUserDao.class);//获取一个动态代理对象
        List<User> all = dao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }


    @Test
    public void test5() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//默认开启一个事务，但是事务不会提交
        IUserDao dao = sqlSession.getMapper(IUserDao.class);//获取一个动态代理对象
        User user = new User();
        user.setId(3);
        List<User> all = dao.findByCondition(user);
        System.out.println(all);

    }


    @Test
    public void test6() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析了配置文件，并创建了SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//默认开启一个事务，但是事务不会提交
        IUserDao dao = sqlSession.getMapper(IUserDao.class);//获取一个动态代理对象
        int[] arr = {1,2,3};
        List<User> all = dao.findByIds(arr);
        System.out.println(all);

    }

}
