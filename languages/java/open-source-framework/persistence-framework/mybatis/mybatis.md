## 为什么使用数据库连接池技术？
在数据库连接的创建：建立网络连接、分配内存和CPU进行创建的资源准备
数据库连接销毁过程：会释放连接占用的内存、关闭网络连接、释放文件描述符、回收连接池资源和提交未完成的事务、清理临时表或数据等
所以性能有损耗，故使用连接池技术，利用连接池重用技术和管理一组连接的生命周期等

## 什么叫反射和内省
反射（Reflection）和内省（Introspection）是计算机科学中两个相关的概念，用于描述在运行时获取和操作程序的结构和信息的能力。
反射（Reflection）：反射是指在**程序运行时**，通过检查、分析和修改程序结构、状态和行为的能力。它允许程序在运行时动态地获取和操作类、对象、方法、属性等元素的信息。通过反射，程序可以在运行时获取类的成员、调用方法、访问和修改属性，而不需要在编译时提前知道这些信息。反射通常提供了一组API，用于获取和操作程序结构的元数据，如Java中的java.lang.reflect包。
内省（Introspection）：内省是指在**程序运行时**，通过检查对象的属性和方法来获取其结构和信息的能力。它允许程序在运行时分析对象的类型，获取对象的属性和方法列表，并对其进行操作。与反射不同，内省主要关注对象的内部结构和特性，而不是对类和方法进行操作。内省通常提供了一组API，用于获取和操作对象的属性和方法信息，如Java中的java.beans.Introspector类。
反射和内省在许多编程语言中都有广泛的应用。它们提供了一种动态地获取和操作程序结构的能力，使开发人员能够编写更加灵活和通用的代码。然而，反射和内省的使用也需要小心，因为它们可能会带来一些性能开销和复杂性，并且使代码更加难以理解和维护。因此，在使用反射和内省时需要权衡利弊，遵循适当的设计原则和最佳实践。

在Java中，反射和内省有广泛的应用场景，以下是一些常见的应用场景：

动态加载类和实例化对象：通过反射，可以在运行时动态加载类，并使用类的构造函数实例化对象。这在需要根据配置或用户输入来决定类和对象的情况下非常有用，例如插件系统、依赖注入框架等。
获取和操作对象的属性和方法：通过反射和内省，可以在运行时获取对象的属性和方法信息，并对其进行操作。这对于实现通用的数据绑定、对象序列化、属性拷贝、动态代理等功能非常有用。
调用和扩展框架的功能：通过反射，可以使用框架提供的API动态地调用和扩展框架的功能。例如，JUnit测试框架使用反射来查找和执行测试方法，Spring框架使用反射来进行依赖注入和AOP代理等。
序列化和反序列化：反射在序列化和反序列化过程中起着重要的作用。通过反射，可以动态地访问和操作对象的属性，将对象转换为字节流或其他格式进行存储或传输，然后再恢复为对象。
动态代理：反射可以用于实现动态代理模式，通过创建代理类来代理原始对象，并在方法调用前后进行额外的操作。例如，Java中的java.lang.reflect.Proxy类提供了创建动态代理对象的功能。
注解处理：反射可以用于处理注解，通过反射获取类、方法、字段上的注解信息，并根据注解信息执行相应的逻辑。这在实现自定义注解处理器、AOP框架等方面非常有用。

Java Agent是一种Java技术，用于在程序运行时通过Java Virtual Machine (JVM) 的Instrumentation API对字节码进行转换和操作。
Java Agent通常以代理方式注入到Java应用程序中，可以在应用程序启动时或在运行过程中对字节码进行修改、增强和监视。通过Java Agent，可以实现一些高级的功能，如性能监控、代码增强、AOP（面向切面编程）等。
Java Agent操作的是字节码层面，能够在应用程序加载类之前或之后对类进行修改，而不仅仅是访问和操作类的结构和状态

## mybatis的mapper.xml将查询的结果反射到对应的对象实体里
即定义一个参数对象，然后取到对象的当前属性值插入到对应的sql中

总结mybatis创建的流程