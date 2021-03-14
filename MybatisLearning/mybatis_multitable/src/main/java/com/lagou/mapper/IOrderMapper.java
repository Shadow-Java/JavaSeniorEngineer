package com.lagou.mapper;

import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace//开启二级缓存
public interface IOrderMapper {


    /**
     * 使用注解开发
     * @Results注解对应于 xml文件中的resultMap，每个实体如果是一对一关系，使用@One注解
     * 如果是一对多的关系（即集合），则是使用@many
     * @return
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "orderTime",column = "order_time"),
            @Result(property = "total",column = "total"),
            @Result(property = "user",column = "uid",javaType = User.class,
                    one = @One(select = "com.lagou.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    List<Order> findAllOrderAndUser();
}
