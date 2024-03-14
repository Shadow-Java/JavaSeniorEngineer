1.springboot项目
会引用spring-boot-starter-parent表明当前是个spring-boot项目
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

并且里面配置了多个默认的starter，需要在自己项目开启才可以使用。
2."starter" 是一种特殊类型的依赖项，用于快速引入一组相关的依赖项和配置，以简化项目的构建和配置过程。与普通项目相比，starter 依赖项提供了一种更方便的方式来集成和配置特定功能或框架。就相当于封装了一些配置和插件，可以直接使用的。
下面是一些分类的stater：
spring-boot-starter-web：用于构建基于 Web 的应用程序，包括 Spring MVC、Tomcat 服务器和其他相关依赖项。
spring-boot-starter-data-jpa：用于与数据库进行交互和持久化的应用程序，包括 Spring Data JPA、Hibernate 和其他相关依赖项。
spring-boot-starter-security：用于添加安全认证和授权功能的应用程序，包括 Spring Security 和其他相关依赖项。
spring-boot-starter-test：用于编写单元测试和集成测试的应用程序，包括 JUnit、Mockito 和其他相关依赖项。
spring-boot-starter-actuator：用于监控和管理 Spring Boot 应用程序的依赖项，包括健康检查、指标收集等功能。

3.下面是 starter 和普通项目的区别：
**依赖项简化**：Starter 依赖项封装了一组相关的依赖项，使得引入所需的依赖项变得更加简单。它们提供了一种按需加载的方式，只需引入一个 starter 依赖项，即可自动引入所需的依赖项，无需手动逐个添加。
**配置自动化**：Starter 依赖项通常提供了一些默认的配置，使得项目的配置变得更加自动化。这些配置可以减少开发人员的工作量，同时也确保了配置的一致性和最佳实践。
**版本管理**：Starter 依赖项还包含了版本管理信息，以确保所引入的依赖项与 starter 依赖项兼容。这样可以避免因为版本冲突而导致的构建错误或不稳定的行为。

Spring框架提供了多个用于组件扫描和注解的注解。以下是一些常见的Spring组件注解以及它们的作用：
@Component：将一个类标记为组件，表示它将由Spring进行管理。它是一个通用的注解，用于任何类。
@Service：用于标记服务层组件，表示它是一个业务逻辑的实现类，也是基于Component注解。
@Repository：用于标记数据访问层组件，表示它是一个数据访问对象（DAO）。
@Controller：用于标记控制器层组件，表示它是一个处理HTTP请求的类，也是基于Component注解。
@RestController：组合了@Controller和@ResponseBody注解，用于标记控制器层组件，并将返回的数据直接作为响应体发送给客户端。
@Configuration：用于标记配置类，表示它是一个包含Bean定义和配置信息的类。
@Bean：用于在@Configuration类中定义一个Bean，Spring将使用该方法返回的对象作为Bean。
@Autowired：用于自动装配依赖项，通过类型匹配进行自动装配。
@Qualifier：与@Autowired一起使用，用于指定具体的依赖项，解决多个匹配类型的依赖项的歧义性。
@Value：用于将值注入到Bean的属性中，可以注入基本类型、字符串、表达式等。
@PostConstruct：用于在Bean初始化之后执行一些初始化操作的方法上进行标记。
@PreDestroy：用于在Bean销毁之前执行一些清理操作的方法上进行标记。


4.注解：
Java注解怎么实现的继承关系
在Java中，注解是不能直接继承的。注解以及其成员变量和方法都没有继承的概念。每个注解都是独立的，无法从其他注解中继承属性或方法。
然而，你可以通过组合多个注解来实现类似继承的效果。这种方式被称为注解的元注解（meta-annotation）。
元注解是用于注解其他注解的注解。通过在自定义注解上使用元注解，可以为自定义注解添加一些额外的行为和属性。例如，你可以使用元注解@Repeatable来指示一个注解是否可重复使用，或使用元注解@Retention指示注解的保留策略。

以下是一个示例，展示了如何使用元注解来实现注解的继承关系
```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ParentAnnotation {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ParentAnnotation("parent")
public @interface ChildAnnotation {
    String additionalValue();
}
```


