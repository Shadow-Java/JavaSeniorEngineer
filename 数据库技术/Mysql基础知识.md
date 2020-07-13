# 本章节数据库技术按照导图展开，如下：

<img src="https://picturestr.oss-cn-shanghai.aliyuncs.com/img/20200712233449.png" align="center" alt="数据库学习导图">

# 数据库基础原理

数据库主要分为：关系型数据库和非关系型数据库。
关系型数据库的代表有：`MySQL`，非关系型数据库代表有：`MongonDB`

## cmd命令行登录和退出MySQL服务器

```jshelllanguage
# 登录MySQL
$ mysql -u root -p12345612

# 退出MySQL数据库服务器
exit;
# 输入回车即可
```

## 基本语法

```mysql
-- 显示所有数据库
show databases;

-- 创建数据库
CREATE DATABASE test;

-- 删除数据库
drop database test;

-- 切换数据库
use test;

-- 显示数据库中的所有表
show tables;

-- 创建数据表
CREATE TABLE pet (
    name VARCHAR(20),
    owner VARCHAR(20),
    species VARCHAR(20),
    sex CHAR(1),
    birth DATE,
    death DATE
);

-- 查看数据表结构
-- describe pet;
desc pet;

-- 查询表
SELECT * from pet;

-- 插入数据方式一
INSERT INTO pet VALUES ('puffball', 'Diane', 'hamster', 'f', '1990-03-30', NULL);

-- 插入数据方式二
INSERT INTO pet(name,owner) VALUES ("nkhkah","jgajjhj");

-- 修改数据
UPDATE pet SET name = 'squirrel' where owner = 'Diane';

-- 删除数据
DELETE FROM pet where name = 'squirrel';

-- 删除表
DROP TABLE myorder;
```
## 建表约束

### 主键约束（PRIMARY KEY）

```mysql
-- 主键约束(PRIMARY KEY)
-- 约束意义：能够唯一确定一张表的一条记录，通过对某个字段添加约束，可以使该字段不重复不为空。类似于人的身份证号，能够唯一确定。
CREATE TABLE user (
    id INT PRIMARY KEY,
    name VARCHAR(20)
);

-- 联合主键(PRIMARY KEY)
-- 联合主键中的每个主键都不能为空，规定只需要联合字段加起来不重复即可。比如user1（1,"shadow","12345"）和user2(1,"liyuanbo","12345")不重复，即不会报错。
CREATE TABLE user (
    id INT,
    name VARCHAR(20),
    password VARCHAR(20),
    PRIMARY KEY(id, name)
);

-- 添加主键约束
-- 如果忘记设置主键，还可以通过SQL语句设置（两种方式）：
ALTER TABLE user ADD PRIMARY KEY(id);
ALTER TABLE user MODIFY id INT PRIMARY KEY;

-- 删除主键
ALTER TABLE user drop PRIMARY KEY;

```

### 自增约束（AUTO_INCREMENT）

```mysql
-- 自增约束(AUTO_INCREMENT)
-- 约束意义：自增约束的主键由系统自动递增分配。比如给id自增，插入时不需要给id赋值，会自增。
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);
```

### 唯一约束（UNIQUE）

```mysql
-- 建表时创建唯一约束
-- 约束意义：约束修饰字段的值不可以重复，可以为空，即唯一 独一无二。
CREATE TABLE user (
    id INT,
    name VARCHAR(20),
    UNIQUE(name)
);

-- 添加唯一主键
-- 如果建表时没有设置唯一建，还可以通过SQL语句设置（两种方式）：
ALTER TABLE user ADD UNIQUE(name);
ALTER TABLE user MODIFY name VARCHAR(20) UNIQUE;

-- 删除唯一主键
ALTER TABLE user DROP INDEX name;
```

### 非空约束（NOT NULL）

```mysql
-- 建表时添加非空约束
-- 约束意义：约束某个字段不能为空
CREATE TABLE user (
    id INT,
    name VARCHAR(20) NOT NULL
);

-- 移除非空约束
ALTER TABLE user MODIFY name VARCHAR(20);
```

### 默认约束（DEFAULT）

```mysql
-- 建表时添加默认约束
-- 约束意义：约束某个字段的默认值。当你不给该字段赋值时，会默认赋予默认值。
CREATE TABLE user2 (
    id INT,
    name VARCHAR(20),
    age INT DEFAULT 10
);

-- 移除非空约束
ALTER TABLE user MODIFY age INT;
```

### 外键约束（FOREIGN KEY）

```mysql
-- 主要关联多个表，比如父表和子表或主表和副表。如下的班级表和学生表，学生表的class_id必须来自班级表的id。
-- 约束意义：关联其他外表

-- 班级
CREATE TABLE classes (
    id INT PRIMARY KEY,
    name VARCHAR(20)
);

-- 学生表
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(20),
    -- 这里的 class_id 要和 classes 中的 id 字段相关联
    class_id INT,
    -- 表示 class_id 的值必须来自于 classes 中的 id 字段值
    FOREIGN KEY(class_id) REFERENCES classes(id)
);

-- 1. 主表（父表）classes 中没有的数据值，在副表（子表）students 中，是不可以使用的；
-- 2. 主表中的记录被副表引用时，主表不可以被删除。
```

## 数据库的三大设计范式

### 第一范式（1NF）

数据库的 Java went from starting to giving up！Insist on playing.