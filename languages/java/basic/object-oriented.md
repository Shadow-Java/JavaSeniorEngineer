Java中把一切都看做对象，所以是"面向对象设计"，面向对象有三种基本特性`继承、封装和多态`

# 1 继承

* 继承其实就是把代码分层、提炼，继承能够使子类拥有父类的实例域与方法；
* 子类会继承父类除private的属性和方法，且可以对父类拓展；子类可以继承default方法，但必须在同一包下面
* Java只支持单一继承（防止不同的方法名混乱重复），但可以多重继承
* 子类不继承父类的构造器

# 2 重写(Override)与重载(Overload)

## 2.1 重写（Override）

子类对父类或接口允许访问（public、protected和default）的方法进行重写，但是有规则进行重写

1. 重写的方法名、形参和返回值都不变
2. 返回类型与重写的方法可以不同，但必须是父类返回值的派生
3. final和static不能被重写
4. 访问修饰符一定要大于父类的访问修饰符，如父类protected -> 子类public
5. 重写方法不能抛出新的异常或者比被重写方法声明的检查异常更广的检查异常。但是可以抛出更少，更有限或者不抛出异常。

## 2.2 重载（Overload）

1. 指在一个类里面，方法名字相同，但参数类型不同，返回类型也是可以相同也可不同
2. 重载的方法的参数列表必须不同，不然就是重写了
3. 可以修改访问修饰符，如private或public等
4. 子类继承父类的方法后，子类定义相同方法名和不同参数类型的方法，这也是重载
5. 一般用在构造函数上，重载不同的构造函数

2.3 区别


| 区别     | 重载     | 重写                                           |
| ---------- | ---------- | ------------------------------------------------ |
| 参数列表 | 必须修改 | 一定不能修改，参数变量名可修改                 |
| 返回类型 | 可修改   | 一定不能修改                                   |
| 异常     | 可修改   | 可以减少或删除，一定不能抛出新的或者更广的异常 |
| 访问权限 | 可修改   | 降低限制                                       |

# 3 多态

java中多态就是一个事物有多种形态，类似于一个抽象类，多个不同的具体对象。所以从本质来讲，没有继承就没有多态，多态可以消除类型之间的耦合；

程序中定义的引用变量具体指向那个实例对象或者调用的那个方法，都是在运行时才会确定，这样在不修改程序就能让变量绑定不同的类实现上，这就是多态性。

1. 多态存在有三个必要条件：

* 继承
* 重写
* 父类引用指向子类对象

父类指向子类，可以让父类使用子类拓展的功能，但是会丢失子类的独有的属性和方法

2. 多态实现方式

   * 重写

对父类的重写，多个子类可以对父类的同一方法表现出不同的行为

* 接口

3. 编译时多态（overload）

   + 一是指方法的重载，因为在编译时能够通过方法的`参数类型、个数和次序` 来确定执行重载方法中的哪一个
   + 二是当一个对象的引用指向的是当前对象所属类的对象时，为编译时多态 如`Sun sun = new Sun(); sun.say();`
4. 运行时多态（override）
   指的是父类引用指向子类，需要在运行时向上查找对象，确定到底是执行子类的重写方法，还是继承的方法


# 4 封装

就是包装的意思，将代码私有化，减少耦合;提供getter和setter方法，隐藏信息，实现细节

```java
public class Shadow{
  private int age;
  private string name;
  public void setAge(int age){
    this.age = age;
  }
  public string getAge(){
    return this.age;
  }
}
```

## 4.1 接口的方法必须要实现吗

不是必须的，static不需要实现;default默认的方法，子类可以实现也可不实现;普通方法和abstract方法必须实现

# 5 内部类

内部类看起来是外部类的一个成员，所以内部类拥有private、public等访问权限，也可以用static修饰，成员内部类可以分为：
* 静态成员内部类

静态类只有内部类才可以，静态类的创建不需要依赖外部类，所以它不能访问外部类的非静态属性和方法

```java
public class Test{

    static class InnerClass {
        static String test = "test";
        int a = 1;
        static void fun1() {}
        void fun2() {}
    }

}
```



* 非静态成员内部类

成员内部类中不能存在任何static的变量和方法，因为内部类需要依赖外部类，而外部类不能static，所以需要等外部类初始化才可以

```java
public class Test{
    private int i = 1;

     class InnerClass {
         String test = "test";
        int a = 1;
         void fun1() {
             System.out.println(i);//外部类的成员变量
         }
        void fun2() {}
    }

}
```

* 使用场景

  + 静态内部类实现单例

外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。


  ```java

public class SingleTon{
  private SingleTon(){}

  private static class SingleTonHoler{
     private static SingleTon INSTANCE = new SingleTon();
 }

  public static SingleTon getInstance(){
    return SingleTonHoler.INSTANCE;
  }
 }
  ```

  + 匿名内部类

  >匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。

  ```java
  public class Demo {
      private Runnable runnable = new Runnable() {
          @override
          public void run() {}
      }
  }
  ```


https://blog.csdn.net/liuxiao723846/article/details/108006609

**Open Closed Principle** 开放关闭准则



# 6 反射

类这个模板定义了这个类的所有元信息，通过这些信息我们就可以实例化出对象，而Class信息在类加载过程中，会被存储到内存模型中的方法区中，也是我们使用反射时获取的数据来源。


# 6 泛型

# 7 对象拷贝

# 8 流文件

