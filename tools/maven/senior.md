https://blog.csdn.net/wuzhongqiang/article/details/103227170
git fork的使用  Syncing a fork

是怎么将两个不同的remote进行同步的


setting.xml：settings.xml 是 Maven 的全局配置文件，位于 Maven 安装目录下的 conf 文件夹中，或者用户的 Maven 配置目录下。它包含了全局的配置信息，如镜像仓库、代理设置、身份验证信息等。settings.xml 的配置适用于整个 Maven 系统，对所有项目都起作用。
pom.xml：pom.xml 是 Maven 项目的核心配置文件，位于每个 Maven 项目的根目录下。它定义了项目的结构、依赖项、插件、构建配置等。pom.xml 文件是针对每个具体项目的，每个项目都有自己的独立配置。
在maven的依赖声明中 ，"org.springframework.boot:spring-boot-starter-jetty:jar:1.5.9.RELEASE:compile" 这个字符串包含了几个不同的值，用于指定依赖项的信息。下面是这个字符串中各个部分的含义：

groupId: 这是指定依赖项所属的组织或者团队的唯一标识符。在这个例子中，org.springframework.boot 是 Spring Boot 项目的组织标识。
artifactId: 这是指定依赖项的唯一标识符，用于在其所属组织或者团队内部区分不同的项目。在这个例子中，spring-boot-starter-jetty 是 Spring Boot Jetty Starter 的项目标识。
jar: 这是指定依赖项的类型，表示这个依赖项是一个 JAR 文件。其他常见的类型还包括 war、pom 等。
1.5.9.RELEASE: 这是指定依赖项的版本号。在这个例子中，依赖项的版本号是 1.5.9.RELEASE。
compile: 这是指定依赖项的作用范围（Scope）。作用范围决定了依赖项在不同阶段的使用方式。compile 表示该依赖项在编译阶段和运行时都需要被包含。


modelVersion 是 Maven POM（Project Object Model，项目对象模型）的元素之一，它指定了当前 POM 的模型版本。POM 是 Maven 项目的核心配置文件，用于定义项目的结构、依赖项、插件、构建配置等。

modelVersion 元素指定了当前 POM 所使用的 POM 模型的版本号。它是 POM 文件的第一个元素，通常设置为固定值 "4.0.0"，表示使用 Maven 4 版本的 POM 模型。这个值告诉 Maven 构建系统如何解析和处理 POM 文件中的其他元素和配置