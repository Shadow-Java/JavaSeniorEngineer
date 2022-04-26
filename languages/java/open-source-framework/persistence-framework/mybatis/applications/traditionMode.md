> 工具是建立在应用场景之上的，那么是什么原因让你使用了mybatis？

# 1.传统的JDBC的优缺点

## 1.2 传统的JDBC的使用

```java
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;//返回结果集
        User user = new User();
        try{
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test? characterEncoding=utf-8", "root", "root");
                            // 定义sql语句？表示占位符
            String sql = "select * from user where username = ?";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，第⼀个参数为sql语句中参数的序号(从1开始)，第⼆个参数为设置的参数值
            preparedStatement.setString(1, "tom");
            // 向数据库发出sql执⾏查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历查询结果集
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                //封装user
                user.setId(id);
                user.setUsername(username);
            }
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        if(preparedStatement != null){
            try{
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    
```

---

存在的问题：

* 数据库配置信息存在硬编码（硬编码一级关联,软编码多级关联）

+ 需要频繁创建与释放连接（oracle都是tcp,tcp三次握手）

解决方法：

# 2.使用mybatis带来了哪些好处
