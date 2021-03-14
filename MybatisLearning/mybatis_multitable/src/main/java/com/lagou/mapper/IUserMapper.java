package com.lagou.mapper;

import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;

/**
 * 使用mybatis-redis作为二级缓存，这样可以实现分布式缓存（多台服务器同时请求）
 * mybatis不能实现分布式缓存，其次底层是hashmap
 */
@CacheNamespace(implementation = RedisCache.class)
public interface IUserMapper {
    //查询订单的同时还查询订单所属的用户
    List<Order> findOrderAndUser();


    //查询用户信息，同时查询每个用户关联订单信息
    List<User> findAll();

    /**
     * 使用注解开发
     */
    //添加用户
    @Insert("insert into user values(#{id},#{userName})")
    public void addUser(User user);
    @Update("update user set username = #{userName} where id = #{id}")
    public void updateUser(User user);

    @Select("select * from user")
    public List<User> selectAllUser();

    @Delete("delete from user where id = #{id}")
    public int delectUser(User user);


    /**
     * 禁用二级缓存，每次都从数据库中取
     * @param id
     * @return
     */
    @Options(useCache = false)
    @Select("select * from user where id = #{id}")
    public User findUserById(Integer id);

}
