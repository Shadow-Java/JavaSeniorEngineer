package com.lagou.dao;

import com.lagou.pojo.User;


import java.io.IOException;
import java.util.List;

public interface IUserDao {
    public List<User> findAll() throws IOException;

    public List<User> findByCondition(User user);


    public List<User> findByIds(int[] ids);
}
