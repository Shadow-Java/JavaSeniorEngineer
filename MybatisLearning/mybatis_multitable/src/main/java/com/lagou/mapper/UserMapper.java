package com.lagou.mapper;

import com.lagou.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * 通用mapper接口,继承mapper则可以增删改查
 */
public interface UserMapper extends Mapper<User> {
}
