# Spring Framework

Spring 通常指的是 Spring Framework 。通常 Java 开发就是面向对象开发、面向抽象接口开发。而软件项目大多都是“堆积木”，随着版本迭代会越来越大，这造成了个很大的问题就是对象的管理。刚好
Spring 的控制反转，依赖注入，切面编程的特性对这些类生命周期的管理，组件模块化，基础层和业务分离解耦提供了很大的便利。就像粘合剂一样把各种功能的库“粘”到一起，让它们协同工作。

# Spring Boot

Spring Framework 经过数年的迭代已经丧失了轻量级的标签。在享受 Spring Framework 带来的便利的同时，我们又进入了另一个噩梦：大量的
XML 配置。 Spring 使用者不单单要写业务代码，还要通过编写对应的 XML配置，引入其它组件或者功能类库也要进行繁琐的适配，这偏离了
Spring Framework最初设计的初衷。所以 Spring Boot 被设计出来。

Spring Boot 将 Spring Framework 的功能进行了扩展，将繁琐的配置功能进行了内部整合，通过一些自动化的配置和类似 SPI
的发现机制来自动感知功能组件，大大降低了使用成本，而且保证了和Spring Framework 的一致性。

## 1. 简便
   Spring Boot可以快速通过引导式的步骤搭建一个生产级企业应用开发平台，而无需繁琐的配置。而且提供了默认配置，甚至你可以达到零配置接入。

## 2. 灵活
   Spring Boot同时对常用的功能进行了组件化的抽象，可以按需引用。另外也指定了一揽子的组件规范让开发者可以自行实现符合 Spring Boot 风格的组件（Starter），让你实现插件化开发。

## 3. 集中
   每一个版本的依赖都经过测试和挑选，对各个组件进行了集中管理，构成一个 parent 集合，减少了依赖冲突的可能性。

## 4. 敏捷
   Spring Boot通过一些注解简化了之前的开发和配置，减少了模板代码的编写，加快了开发速度。内置Web 容器甚至可以以 Jar 的方式快速部署运行。

## Spring框架分为几个方面：
1.核心容器（Core Container）：这是Spring框架的核心部分，提供了IoC（Inversion of Control，控制反转）和DI（Dependency Injection，依赖注入）功能。它包括BeanFactory和ApplicationContext等容器，用于管理和装配应用程序中的对象（Bean）。

2.AOP（Aspect-Oriented Programming）：Spring框架通过AOP模块支持面向切面编程，允许开发者将横切关注点（如事务管理、日志记录等）与主要业务逻辑分离。通过AOP，可以实现横切逻辑的重用和集中管理。

3.数据访问（Data Access）：Spring框架提供了一套强大的数据访问和集成的解决方案，包括对各种数据访问技术（如JDBC、ORM框架、事务管理等）的支持。它简化了数据库操作和数据访问层的开发。

4.Web开发（Web Development）：Spring框架通过Spring MVC模块支持Web应用程序开发。它提供了一种基于模型-视图-控制器（MVC）的架构，用于构建灵活和可扩展的Web应用程序。Spring框架还提供了对RESTful服务和WebSocket等的支持。

5.集成（Integration）：Spring框架通过集成模块支持与其他技术和框架的集成，例如JMS（Java Message Service）、JTA（Java Transaction API）、JPA（Java Persistence API）等。这使得Spring应用程序能够与各种外部系统进行无缝集成。

6.测试（Testing）：Spring框架提供了一套丰富的测试支持，包括单元测试和集成测试。它提供了模拟对象、测试容器和基于注解的测试等功能，使得开发人员可以方便地编写和执行测试。

7.安全（Security）：Spring框架提供了一组强大的安全性解决方案，用于保护应用程序的安全性和数据的机密性。它支持基于角色的访问控制、加密和认证等安全功能。

## 使用Spring框架的好处是什么？
1.轻量：spring是轻量的，基本的版本大约2MB
2.控制反转：Spring通过控制反转实现了松散耦合，对象们给出他们的依赖，而不是创建或查找依赖的对象们
3.面向切面的编程(AOP):Spring支持面向切面的编程，并且把应用业务逻辑和系统服务分开
4.容器：Spring包含并管理应用中对象的生命周期和配置
5.MVC框架：Spring的WEB框架是一个精心设计的框架，是WEB框架的一个很好的替代品
6.事务管理：Spring提供一个持续的事务管理接口，可以拓展到上至本地事务下至全局事务（JTA）
7.异常处理：Spring提供方便的API把具体技术相关的异常（比如由JDBC、Hibernate or JDO抛出的）转化为一致的unchecked异常
## Spring由哪些模块组成
Spring框架基本模块：
* Core module
* Bean module
* Context module
* Expression Language module
* JDBC module
* ORM module
* OXM module
* Java Messaging Service(JMS) module
* Transaction module
* Web module
* Web-Servlet module
* Web-Struts module
* Web-Portlet module
## 核心容器（应用上下文）模块
这是基本的 Spring 模块，提供 spring 框架的基础功能，BeanFactory是任何以 spring 为基础的应用的核 心。Spring 框架建立在此模块之上，它使 Spring 成为 一个容器
## BeanFactory – BeanFactory 实现举例
Bean 工厂是工厂模式的一个实现，提供了控制反转功 能，用来把应用的配置和依赖从正真的应用代码中分 离。 最常用的 BeanFactory 实现是 XmlBeanFactory 类。
## XMLBeanFactory
最常用的就是 org.springframework.beans.factory.xml.XmlBeanFactory ，它根据 XML 文件中的定义加载 beans。该容器 从 XML 文件读取配置元数据并用它去创建一个完全配置 的系统或应用
## 解释 AOP 模块
AOP 模块用于发给我们的 Spring 应用做面向切面的开发，很多支持由 AOP 联盟提供，这样就确保了Spring和其他 AOP 框架的共通性。这个模块将元数据编程引入 Spring。
## 解释 JDBC 抽象和 DAO 模块
通过使用 JDBC 抽象和 DAO 模块，保证数据库代码的简洁，并能避免数据库资源错误关闭导致的问题，它在各种不同的数据库的错误信息之上，提供了一个统一的异常访问层。它还利用Spring的 AOP 模块给 Spring 应用中的对象提供事务管理服务。
## 解释对象/关系映射集成模块
Spring 通过提供 ORM 模块（Object-Relational Mapping），支持我们在直接 JDBC 之上使用一个对象/关系映射映射(ORM)工具，Spring 支持集成主流的 ORM 框架，如 Hiberate,JDO和iBATIS SQL Maps。Spring 的事务管理同样支持以上所有 ORM 框架及 JDBC。
## 解释 WEB 模块。
Spring 的 WEB 模块是构建在 application context 模块基础之上，提供一个适合 web 应用的上下文。这个模 块也包括支持多种面向 web 的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。它也有对 Jakarta Struts 的支持。
## Spring 配置文件
Spring 配置文件是个 XML 文件，这个文件包含了类信息，描述了如何配置它们，以及如何相互调用。
## 什么是 Spring IOC 容器？
Spring IOC 负责创建对象，管理对象（通过依赖注入（DI），装配对象，配置对象，并且管理这些对象的整 个生命周期。
## IOC 的优点是什么？
IOC 或 依赖注入把应用的代码量降到最低。它使应用容易测试，单元测试不再需要单例和 JNDI 查找机制。最小的代价和最小的侵入性使松散耦合得以实现。IOC容器支持加载服务时的饿汉式初始化和懒加载。
## ApplicationContext 通常的实现是什么?
* FileSystemXmlApplicationContext ：
此容器从一个XML 文件中加载 beans 的定义，XML Bean 配置文件的全路径名必须提供给它的构造函数。
* ClassPathXmlApplicationContext：
此容器也从一个XML 文件中加载 beans 的定义，这里你需要正确设置classpath 因为这个容器将在classpath里找bean配置。
* WebXmlApplicationContext：
此容器加载一个XML文件，此文件定义了一个WEB应用的所有 bean
## Bean 工厂和 Application contexts 有什么区别？
Application contexts 提供一种方法处理文本消息，一个通常的做法是加载文件资源（比如镜像），它们可以 向注册为监听器的 bean 发布事件。另外，在容器或容器内的对象上执行的那些不得不由 bean 工厂以程序化方式处理的操作，可以在 Application contexts 中以声明的方式处理。Application contexts 实现了
MessageSource接口，该接口的实现以可插拔的方式提供获取本地化消息的方法。
## 什么是 Spring 的依赖注入？
依赖注入，是 IOC 的一个方面，是个通常的概念，它有多种解释。这概念是说你不用创建对象，而只需要描述它如何被创建。你不在代码里直接组装你的组件和服务，但是要在配置文件里描述哪些组件需要哪些服务，之后一个容器（IOC 容器）负责把他们组装起来。
## 有哪些不同类型的 IOC（依赖注入）方式？
* 构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。
* Setter方法注入：Setter 方法注入是容器通过调用无参构造器或无参 static 工厂方法实例化 bean 之后，调用该bean的 setter 方法，即实现了基于 setter 的依赖注入
## 哪种依赖注入方式你建议使用，构造器注入，还是Setter 方法注入？
你两种依赖方式都可以使用，构造器注入和 Setter 方法 注入。最好的解决方案是用构造器参数实现强制依赖， setter 方法实现可选依赖。
    
# Spring Beans
## 什么是 Spring beans?
Spring beans 是那些形成 Spring 应用的主干的 java 对 象。它们被Spring IOC容器初始化、装配和管理。这些beans通过容器中配置的元数据创建。比如，以 XML文件中<bean/> 的形式定义。
Spring 框架定义的 beans 都是单件 beans。在bean tag 中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个prototype bean。默认是 TRUE，所以所有在 Spring框架中的 beans 缺省都是单件。
## 一个 Spring Bean 定义 包含什么？
一个 Spring Bean 的定义包含容器必知的所有配置元数 据，包括如何创建一个 bean，它的生命周期详情及它的依赖。
## 如何给 Spring 容器提供配置元数据?
这里有三种重要的方法给 Spring 容器提供配置元数据。 XML 配置文件。 基于注解的配置。 基于 java 的配置。
## 你怎样定义类的作用域?
当定义一个<bean> 在 Spring 里，我们还能给这个bean 声明一个作用域。它可以通过 bean 定义中的scope属性来定义。如，当 Spring 要在需要的时候每次生产一个新的bean实例，bean的scope属性被指定为prototype。另一方面，一个 bean 每次使用的时候必须
返回同一个实例，这个bean的scope属性必须设为singleton。
## 解释 Spring 支持的几种 bean 的作用域。
Spring 框架支持以下五种 bean 的作用域：
* singleton:bean在每个 Spring ioc 容器中只有一个实例
* prototype：一个bean 的定义可以有多个实例
* request每次http请求都会创建一个 bean，该作用域仅在基于web的 Spring ApplicationContext 情形下有效
* session：在一个HTTP Session 中，一个 bean 定义对应一个实例。该作用域仅在基于 web 的Spring ApplicationContext 情形下有效
* global-session：在一个全局的 HTTP Session 中，一个 bean 定义对应一个实例。该作用域仅在基于 web 的Spring ApplicationContext 情形下有效。缺省的 Spring bean 的作用域是 Singleton.
## Spring 框架中的单例 bean 是线程安全的吗?
不，Spring 框架中的单例 bean 不是线程安全的。
 在Spring框架中，默认情况下，单例（Singleton）作用域的Bean是共享的，即在整个应用程序中只有一个实例。然而，这并不意味着Spring的单例bean自动成为线程安全的。
 Spring的单例bean在多线程环境下可能会导致线程安全问题的主要原因是其状态（state）。如果单例bean维护了可变的状态，并且多个线程同时修改这个状态，就会产生竞态条件（race condition）和数据不一致的问题。
以下是一些可能导致单例bean线程不安全的情况：
* 共享可变状态：如果单例bean中包含可变的实例变量，并且多个线程同时修改这些变量，就可能导致数据不一致和竞态条件。例如，在单例bean中使用实例变量来存储某个计数器，并且多个线程同时调用增加计数的方法。

* 外部资源访问：如果单例bean依赖于外部资源（如数据库连接、文件系统等），并且多个线程同时访问和修改这些资源，就可能导致竞争和冲突。例如，在单例bean中使用数据库连接池来处理数据库操作，在高并发环境下可能会导致资源争用和数据一致性问题。

为了解决单例bean的线程安全问题，可以采取以下措施：
避免共享可变状态：尽量避免在单例bean中维护可变的实例变量。如果需要在单例中存储状态，确保采取适当的同步措施（如加锁）或使用线程安全的数据结构。
使用局部变量：在方法内部使用局部变量而不是实例变量，可以避免多线程同时访问和修改共享状态的问题。
使用线程安全的组件和技术：选择线程安全的组件和技术，如使用线程安全的集合类、同步工具类（如锁、信号量等）或使用并发编程库（如Java的java.util.concurrent包）来处理并发访问。
使用作用域控制：如果单例bean的状态需要被多个线程独立访问和修改，考虑使用原型（Prototype）作用域来创建多个实例，以避免共享状态问题。
## 解释 Spring 框架中 bean 的生命周期。
* Spring 容器从XML文件中读取bean的定义，并实例化bean
* Spring根据bean的定义填充所有的属性
* 如果bean实现了 BeanNameAware 接口，Spring 传递 bean 的 ID 到 setBeanName 方法。
* 如果Bean 实现了 BeanFactoryAware 接口， Spring传递 beanfactory 给 setBeanFactory 方法。
* 如果有任何与 bean 相关联的 BeanPostProcessors，Spring 会在 postProcesserBeforeInitialization()方法内调用它们。
* 如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。
* 如果有BeanPostProcessors和bean关联，这些bean的 postProcessAfterInitialization() 方法将被调用。
* 如果bean实现了DisposableBean，它将调用destroy()方法。
## 哪些是重要的 bean 生命周期方法？ 你能重载它们吗？
有两个重要的 bean 生命周期方法，第一个是setup，它是在容器加载 bean 的时候被调用。第二个方法是teardown 它是在容器卸载类的时候被调用。
The bean 标签有两个重要的属性（init-method 和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct 和@PreDestroy）。
## 什么是 Spring 的内部 bean？
当一个 bean 仅被用作另一个 bean 的属性时，它能被声明为一个内部 bean，为了定义 inner bean，在Spring的基于XML的配置元数据中，可以在<property/>或<constructor-arg/> 元素内使用<bean/> 元素，内部 bean 通常是匿名的，它们的 Scope 一般是prototype。
30. 在 Spring 中如何注入一个 java 集合？
    Spring 提供以下几种集合的配置元素：
     <list>类型用于注入一列值，允许有相同的值。
     <set> 类型用于注入一组值，不允许有相同的值。
     <map> 类型用于注入一组键值对，键和值都可以为任
    意类型。
     <props>类型用于注入一组键值对，键和值都只能为
    String 类型。
31. 什么是 bean 装配?
    装配，或 bean 装配是指在 Spring 容器中把 bean 组装
    到一起，前提是容器需要知道 bean 的依赖关系，如何
    通过依赖注入来把它们装配到一起。
32. 什么是 bean 的自动装配？
    Spring 容器能够自动装配相互合作的 bean，这意味着
    容器不需要<constructor-arg>和<property>配置，能
    通过 Bean 工厂自动处理 bean 之间的协作。
33. 解释不同方式的自动装配 。
    有五种自动装配的方式，可以用来指导 Spring 容器用自
    动装配方式来进行依赖注入。
     no：默认的方式是不进行自动装配，通过显式设置 ref
    属性来进行装配。
     byName：通过参数名 自动装配，Spring 容器在配置
    文件中发现 bean 的 autowire 属性被设置成 byname，
    之后容器试图匹配、装配和该 bean 的属性具有相同名
    字的 bean。
     byType:：通过参数类型自动装配，Spring 容器在配置
    文件中发现 bean 的 autowire 属性被设置成 byType，
    之后容器试图匹配、装配和该 bean 的属性具有相同类
    型的 bean。如果有多个 bean 符合条件，则抛出错误。
     constructor：这个方式类似于 byType， 但是要提供
    给构造器参数，如果没有确定的带参数的构造器参数类
    型，将会抛出异常。
     autodetect：首先尝试使用 constructor 来自动装配，
    如果无法工作，则使用 byType 方式。
    34.自动装配有哪些局限性 ?
    自动装配的局限性是：
     重写： 你仍需用 <constructor-arg>和 <property>
    配置来定义依赖，意味着总要重写自动装配。
     基本数据类型：你不能自动装配简单的属性，如基本数
    据类型，String 字符串，和类。
     模糊特性：自动装配不如显式装配精确，如果有可能，
    建议使用显式装配。
35. 你可以在 Spring 中注入一个 null 和一个空字符串
    吗？
    可以。
    Spring 注解
36. 什么是基于 Java 的 Spring 注解配置? 给一些注解
    的例子.
    基于 Java 的配置，允许你在少量的 Java 注解的帮助
    下，进行你的大部分 Spring 配置而非通过 XML 文件。
    以@Configuration 注解为例，它用来标记类可以当做
    一个 bean 的定义，被 Spring IOC 容器使用。另一个例
    子是@Bean 注解，它表示此方法将要返回一个对象，作
    为一个 bean 注册进 Spring 应用上下文。
37. 什么是基于注解的容器配置?
    相对于 XML 文件，注解型的配置依赖于通过字节码元数
    据装配组件，而非尖括号的声明。
    开发者通过在相应的类，方法或属性上使用注解的方
    式，直接组件类中进行配置，而不是使用 xml 表述
    bean 的装配关系。
38. 怎样开启注解装配？
    注解装配在默认情况下是不开启的，为了使用注解装
    配，我们必须在 Spring 配置文件中配置
    <context:annotation-config/>元素。
39. @Required 注解
    这个注解表明 bean 的属性必须在配置的时候设置，通
    过一个 bean 定义的显式的属性值或通过自动装配，若
    @Required 注解的 bean 属性未被设置，容器将抛出
    BeanInitializationException。
40. @Autowired 注解
    @Autowired 注解提供了更细粒度的控制，包括在何处
    以及如何完成自动装配。它的用法和@Required 一样，
    修饰 setter 方法、构造器、属性或者具有任意名称和/或
    多个参数的 PN 方法。
41. @Qualifier 注解
    当有多个相同类型的 bean 却只有一个需要自动装配
    时，将@Qualifier 注解和@Autowire 注解结合使用以
    消除这种混淆，指定需要装配的确切的 bean。
    Spring 数据访问
    42.在 Spring 框架中如何更有效地使用 JDBC?
    使用 SpringJDBC 框架，资源管理和错误处理的代价都
    会被减轻。所以开发者只需写 statements 和 queries
    从数据存取数据，JDBC 也可以在 Spring 框架提供的模
    板类的帮助下更有效地被使用，这个模板叫
    JdbcTemplate （例子见这里 here）
43. JdbcTemplate
    JdbcTemplate 类提供了很多便利的方法解决诸如把数
    据库数据转变成基本数据类型或对象，执行写好的或可
    调用的数据库操作语句，提供自定义的数据错误处理。
44. Spring 对 DAO 的支持
    Spring 对数据访问对象（DAO）的支持旨在简化它和数
    据访问技术如 JDBC，Hibernate or JDO 结合使用。这
    使我们可以方便切换持久层。编码时也不用担心会捕获
    每种技术特有的异常。
45. 使用 Spring 通过什么方式访问 Hibernate?
    在 Spring 中有两种方式访问 Hibernate：
     控制反转 Hibernate Template 和 Callback。
     继承 HibernateDAOSupport 提供一个 AOP 拦截器。
46. Spring 支持的 ORM
    Spring 支持以下 ORM：
     Hibernate
     iBatis
     JPA (Java Persistence API)
     TopLink
     JDO (Java Data Objects)
     OJB
    47.如何通过 HibernateDaoSupport 将 Spring 和
    Hibernate 结合起来？
    用 Spring 的 SessionFactory 调用
    LocalSessionFactory。集成过程分三步：
     配置 the Hibernate SessionFactory。
     继承 HibernateDaoSupport 实现一个 DAO。
     在 AOP 支持的事务中装配。
48. Spring 支持的事务管理类型
    Spring 支持两种类型的事务管理：
     编程式事务管理：这意味你通过编程的方式管理事务，
    给你带来极大的灵活性，但是难维护。
     声明式事务管理：这意味着你可以将业务代码和事务管
    理分离，你只需用注解和 XML 配置来管理事务。
49. Spring 框架的事务管理有哪些优点？
     它为不同的事务 API 如 JTA，JDBC，Hibernate，JPA
    和 JDO，提供一个不变的编程模式。
     它为编程式事务管理提供了一套简单的 API 而不是一些
    复杂的事务 API 如
     它支持声明式事务管理。
     它和 Spring 各种数据访问抽象层很好得集成。
50. 你更倾向用那种事务管理类型？
    大多数 Spring 框架的用户选择声明式事务管理，因为它
    对应用代码的影响最小，因此更符合一个无侵入的轻量
    级容器的思想。声明式事务管理要优于编程式事务管
    理，虽然比编程式事务管理（这种方式允许你通过代码
    控制事务）少了一点灵活性。
    Spring 面向切面编程（AOP）
51. 解释 AOP
    面向切面的编程，或 AOP， 是一种编程技术，允许程序
    模块化横向切割关注点，或横切典型的责任划分，如日
    志和事务管理。
52. Aspect 切面
    AOP 核心就是切面，它将多个类的通用行为封装成可重
    用的模块，该模块含有一组 API 提供横切功能。比如，
    一个日志模块可以被称作日志的 AOP 切面。根据需求的
    不同，一个应用程序可以有若干切面。在 Spring AOP
    中，切面通过带有@Aspect 注解的类实现。
52. 在 Spring AOP 中，关注点和横切关注的区别是什
    么？
    关注点是应用中一个模块的行为，一个关注点可能会被
    定义成一个我们想实现的一个功能。
    横切关注点是一个关注点，此关注点是整个应用都会使
    用的功能，并影响整个应用，比如日志，安全和数据传
    输，几乎应用的每个模块都需要的功能。因此这些都属
    于横切关注点。
54. 连接点
    连接点代表一个应用程序的某个位置，在这个位置我们
    可以插入一个 AOP 切面，它实际上是个应用程序执行
    Spring AOP 的位置。
55. 通知
    通知是个在方法执行前或执行后要做的动作，实际上是
    程序执行时要通过 SpringAOP 框架触发的代码段。
    Spring 切面可以应用五种类型的通知：
     before：前置通知，在一个方法执行前被调用。
     after: 在方法执行之后调用的通知，无论方法执行是否
    成功。
     after-returning: 仅当方法成功完成后执行的通知。
     after-throwing: 在方法抛出异常退出时执行的通知。
     around: 在方法执行之前和之后调用的通知。
56. 切点
    切入点是一个或一组连接点，通知将在这些位置执行。
    可以通过表达式或匹配的方式指明切入点。
57. 什么是引入?
    引入允许我们在已存在的类中增加新的方法和属性。
58. 什么是目标对象?
    被一个或者多个切面所通知的对象。它通常是一个代理
    对象。也指被通知（advised）对象。
59. 什么是代理?
    代理是通知目标对象后创建的对象。从客户端的角度
    看，代理对象和目标对象是一样的。
60. 有几种不同类型的自动代理？
    BeanNameAutoProxyCreator
    DefaultAdvisorAutoProxyCreator
    Metadata autoproxying
61. 什么是织入。什么是织入应用的不同点？
    织入是将切面和到其他应用类型或对象连接或创建一个
    被通知对象的过程。
    织入可以在编译时，加载时，或运行时完成。
62. 解释基于 XML Schema 方式的切面实现。
    在这种情况下，切面由常规类以及基于 XML 的配置实
    现。
63. 解释基于注解的切面实现
    在这种情况下(基于@AspectJ 的实现)，涉及到的切面声
    明的风格与带有 java5 标注的普通 java 类一致。
    Spring 的 MVC
64. 什么是 Spring 的 MVC 框架？
    Spring 配备构建 Web 应用的全功能 MVC 框架。
    Spring 可以很便捷地和其他 MVC 框架集成，如
    Struts，Spring 的 MVC 框架用控制反转把业务对象和
    控制逻辑清晰地隔离。它也允许以声明的方式把请求参
    数和业务对象绑定。
65. DispatcherServlet
    Spring 的 MVC 框架是围绕 DispatcherServlet 来设计
    的，它用来处理所有的 HTTP 请求和响应。
66. WebApplicationContext
    WebApplicationContext 继承了 ApplicationContext
    并增加了一些 WEB 应用必备的特有功能，它不同于一
    般的 ApplicationContext ，因为它能处理主题，并找
    到被关联的 servlet。
67. 什么是 Spring MVC 框架的控制器？
    控制器提供一个访问应用程序的行为，此行为通常通过
    服务接口实现。控制器解析用户输入并将其转换为一个
    由视图呈现给用户的模型。Spring 用一个非常抽象的方
    式实现了一个控制层，允许用户创建多种用途的控制
    器。
68. @Controller 注解
    该注解表明该类扮演控制器的角色，Spring 不需要你继
    承任何其他控制器基类或引用 Servlet API。
69. @RequestMapping 注解
    该注解是用来映射一个 URL 到一个类或一个特定的方处
    理法上。

## Spring框架在其设计和实现中广泛运用了多种设计模式：

控制反转（IoC）/ 依赖注入（DI）模式：Spring框架的核心思想就是IoC和DI，它们通过将对象的创建和依赖的管理交给框架来实现松耦合和可维护性。例如，使用注解或XML配置文件定义Bean，并通过注入（DI）将这些Bean注入到其他组件中。

工厂模式：Spring框架使用工厂模式来创建和管理Bean对象。例如，通过BeanFactory或ApplicationContext作为工厂，根据配置信息或注解来创建和管理Bean实例。

单例模式：Spring框架默认情况下使用单例模式管理Bean，确保在应用程序中只有一个实例可供使用。通过IoC容器的单例管理，可以提高性能和资源利用效率。

适配器模式：Spring框架中的适配器模式用于将不同类型的组件适配为统一的接口。例如，Spring MVC框架使用适配器模式将不同类型的控制器适配为处理请求的统一控制器接口。

观察者模式：Spring框架的事件机制是基于观察者模式的。事件发布者和事件监听者之间的解耦通过观察者模式实现。例如，使用ApplicationEventPublisher发布事件，并使用@EventListener注解或实现ApplicationListener接口的监听者来接收和处理事件。

模板方法模式：Spring框架中的JdbcTemplate和HibernateTemplate等模板类使用了模板方法模式。这些模板类定义了通用的操作流程和算法，具体的实现可以在子类中进行扩展和定制。

代理模式：在Spring AOP中，使用代理模式来实现切面编程。通过代理对象包装目标对象，实现在目标对象调用前后添加额外的逻辑。例如，使用JDK动态代理或CGLIB代理来生成代理对象，对目标对象的方法进行增强。

## 切面只有spring才有吗 如果没有spring 怎么写切面
虽然切面编程在Spring框架中得到了广泛应用和支持，但切面编程的概念和实现并不仅限于Spring框架。在没有Spring框架的情况下，你仍然可以使用其他技术或框架来实现切面编程。
以下是一些常见的用于实现切面编程的技术和框架：

**AspectJ**：AspectJ是一个功能强大的面向切面编程框架，它提供了广泛的切面支持和丰富的语法。你可以使用AspectJ来定义切面、切点和通知，并将它们编织到目标代码中。AspectJ可以与Java应用程序一起使用，而不依赖于Spring框架。

**Java动态代理**：Java动态代理是Java核心库提供的一种机制，允许在运行时创建代理对象来拦截对目标对象的方法调用。你可以使用Java动态代理来实现切面编程的某些方面，例如方法拦截、日志记录等。这需要你手动编写代理类和拦截器。

**自定义代码插桩**：在没有框架支持的情况下，你可以通过修改目标代码或字节码来实现切面的功能。这种方式需要你对目标代码的结构和执行过程有一定的了解，并使用工具或库来进行代码插桩。例如，使用字节码操作库如ASM或Byte Buddy来修改字节码，或使用Java Agent来在运行时修改类的行为。

**其他框架或工具**：除了上述提到的方案，还有其他一些框架或工具可以用于实现切面编程，如Javassist、CGLIB等。这些框架提供了不同的技术和机制，可以用于在非Spring环境中实现切面编程的某些方面。


