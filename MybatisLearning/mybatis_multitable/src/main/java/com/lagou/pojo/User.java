package com.lagou.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 开启二级缓存后，缓存的pojo需要实现反序列化，因为数据存储不一定在内存中，可能还在硬盘中，所以取数据的话就需要反序列化了
 * mybatis中的pojo都需要实现反序列化接口
 */
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer id;
    @Column(name = "username")
    private String userName;

    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
