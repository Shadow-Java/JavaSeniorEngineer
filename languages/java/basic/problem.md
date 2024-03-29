Class 'GroudwaterServiceImpl' must either be declared abstract or implement abstract method 'save(Entity)' in 'IBaseService'

前提：

```java
public interface IBaseService{//该函数是引入的另一个jar中的方法
   Result<Integer> save(Entity var1);
}
```

```java
public class GroudwaterServiceImpl implements IBaseService{

}
```

我定义了这个类，然后ide告诉我要么定义为abstract类，要么必须实现IBaseService中的接口方法?

问题一：Result<Integer> save(Entity var1);的访问权限为什么是public abstract
问题二：为什么必须实现该方法，为什么改成抽象类就可以解决？

接口方法默认是public，
在之前接口可以包含的内容：1.常量  2.抽象方法
在java8之后接口包含的内容：1.常量  2.抽象方法 3.默认方法 4.静态方法

java9之后接口包含的内容：1.常量  2.抽象方法 3.默认方法 4.静态方法 5，私有方法

只要是抽象类，那么就可以不用重写（实现）接口中的抽象方法

```java
public interface MyInterfaceAbstract {

    // 这是一个抽象方法
    public abstract void methodAbs1();

    // 这也是抽象方法
    abstract void methodAbs2();

    // 这也是抽象方法
    public void methodAbs3();

    // 这也是抽象方法
    void methodAbs4();
}
```

https://blog.csdn.net/qq_44750696/article/details/123703495

多态是怎么做的？

Java 反射
1.为什么要用反射
因为反射能够强制将class对象加载进内存，返回class对象；但一般是我们api用到这个对象才会实例化，需要提前使用对象的话就得反射拿到class对象，可以将bean
注入spring中帮忙管理
Java反射的使用
https://blog.csdn.net/m0_69992031/article/details/125269217


[深入理解 Java 反射和动态代理 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/60805342)

[反射的概念和用法_程序员习溶的博客-CSDN博客](https://blog.csdn.net/m0_69992031/article/details/125269217)
