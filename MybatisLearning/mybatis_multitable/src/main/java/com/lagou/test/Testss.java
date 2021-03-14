package com.lagou.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Testss {

    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        List<Order> orders = userMapper.findOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderMapper orderMapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orders = orderMapper.findAllOrderAndUser();
        System.out.println("查询订单！");
        for (Order order : orders) {
            System.out.println(order);
        }
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        List<User> users = userMapper.findAll();
        System.out.println("查询用户！");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private IUserMapper userMapper;
    private IOrderMapper orderMapper;

    @Before
    public void beforePro() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
    }


    @Test
    public void test3(){
        User user = new User();
        user.setId(10);
        user.setUserName("mmm");
        //userMapper.addUser(user);
        user.setUserName("adasa");
        userMapper.updateUser(user);
    }

    @Test
    public void test4(){
        List<Order> orders = orderMapper.findAllOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    /**
     * pageHelper插件使用
     */
    @Test
    public void test5(){
        PageHelper.startPage(1,1);
        List<Order> orders = orderMapper.findAllOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
    }

    @Test
    public void test6() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        User user1 = userMapper.selectOne(user);
        System.out.println(user1);


        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",1).andEqualTo("username","ljkd");
        List<User> users = userMapper.selectByExample(example);
    }

}
