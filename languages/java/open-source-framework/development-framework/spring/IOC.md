## 什么是IOC容器
IOC全称是Inversion of Control(控制反转/反转控制)，它是一个技术思想，不是技术实现。在**传统开发方式**下，比如类A依赖于类B，往往会在类A中new 一个B的对象；那么在IOC的思想开发模式下，开发者不用在自己去new对象了，而是由IOC容器（Spring框架）去**帮助我们实例化并且管理**他，需要什么对象，直接从IOC中去。
控制：指的是对象的创建（实例化、管理）的权利
反转：控制权交给外部环境了（Spring框架、IOC框架）

1.没有IOC容器下,传统方式下：
```java
A a = new A();

class B {
    private B b = new B();
}
```
2.当存在IOC容器时：
```java
B b = new B(); //交给IOC
```
3.解决了什么问题
IOC解决了对象的耦合问题，当在service定义一个接口时，需要指定一个对象实现
```
     Service层                 Dao层
接口：UserService             接口：UserDao
实现类：UserServiceImpl       实现类：UserDaoImpl
UserDao userDao = new UserDaoImpl();//需要指定特定的实现类
如果存在IOC容器，那么：
@Resource
private UserDao userDao;
```
## 什么是依赖注入DI（Dependancy Injection）

依赖注入和IOC其实是描述的是同一件事，只是角度不同。依赖注入是spring允许在运行时注入对象的一些属性，容器会把对象依赖的其他对象注入，比如A对象实例化过程中因为声明了一个B类型的属性，那么就需要容器把B注入A。


## 什么是AOP
面向对象OOP的三大特征：封装、继承、多态；oop是一种垂直众向的继承体系，可以解决大多数代码重复，但是如果在顶级父类的方法中eat()、run()都出现了性能监控代码，那么子类解决不了这种问题；
这种场景就需要横切逻辑代码，使用场景很有限，一般是事务控制、权限校验、日志；

横切逻辑存在什么问题：
* 横切代码重复问题
* 横切逻辑代码和业务代码混杂在一起，代码臃肿，维护不方便
那么AOP提出了横向抽取机制，将横切逻辑代码和业务逻辑代码拆分；

AOP解决了什么问题？
不改变原有业务代码情况下，将业务代码和横切逻辑代码进行解耦，避免横切逻辑代码重复

为什么叫横切逻辑代码？
[横]：指的是横切逻辑，原有业务逻辑代码不懂，只能操作横切逻辑代码，所以面向横切逻辑
[切]：横切逻辑代码往往影响的是很多个方法，每个方法如同一个点，多个点构成面，有一个面的概念在里面