package com.lagou.test;

import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    private IUserMapper userMapper;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void beforePro() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
    }

    /**
     * mybatis默认开启一级缓存，底层结构为hashmap。key为statementId+params+boundSql
     * 如果做增删改操作，并进行事务的提交，就会刷新一级缓存
     */
    @Test
    public void test(){
        User user = userMapper.findUserById(2);
        User user1 = new User();
        user1.setId(11);
        user1.setUserName("asad");
        userMapper.addUser(user1);//中间修改会刷新缓存
        //sqlSession.clearCache();//手动清除缓存

        User user2 = userMapper.findUserById(2);

        System.out.println(user == user2);//开启了一级缓存，其实就是同一个对象
    }


    /**
     * 二级缓存test
     * 二级缓存是基于namespace，就是同时操作usermapper下的不同的sql，且二级缓存是对同namespace下是共享的
     * 测试方法：根据不同的sqlsession来测试
     * 配置参数：@CacheNamespace 或者xml方式：<setting name="cacheEnabled" value="true"/>
     * Cache Hit Ratio:0.5,请求两次，命中一次，即0.5
     *
     * Cause: redis.clients.jedis.exceptions.JedisConnectionException: Could not get a resource from the pool
     */
    @Test
    public void test2(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        IUserMapper userMapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper userMapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper userMapper3 = sqlSession3.getMapper(IUserMapper.class);

        User user1 = userMapper1.findUserById(2);
        sqlSession1.close();//清空一级缓存

        User user = new User();
        user.setId(2);
        user.setUserName("jjdjdj");
        userMapper2.updateUser(user);//对sqlsession2做了增删改查操作，那么二级缓存会清空刷新
        sqlSession2.commit();//需要提交事物

        User user3 = userMapper3.findUserById(2);
        System.out.println(user1 == user3);//fasle 原因是二级缓存不是缓存的对象，是保存数据，然后封装的对象，所以地址不一样
        sqlSession3.close();
    }

}
