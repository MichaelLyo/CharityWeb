# CharityWeb
一个面向社会，偏向同济大学的慈善网站
## 开发环境
### 框架
springBoot + hibernate
### 数据库
- MySQL数据库
- 地址 10.60.42.201:3306
- 用户名 root
- 密码 咨询牛牛

### 包管理
- Maven
- 只要安装了maven，就可以利用maven把项目中所需的框架的jar包自动引入进来，不需要额外搭环境
- 请将下面的代码替换到maven的settings.xml里，注释部分可以删掉
```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    
    <pluginGroups>
        <!-- pluginGroup
         | Specifies a further group identifier to use for plugin lookup.
        <pluginGroup>com.your.plugins</pluginGroup>
        -->
    </pluginGroups>

    <!-- proxies
     | This is a list of proxies which can be used on this machine to connect to the network.
     | Unless otherwise specified (by system property or command-line switch), the first proxy
     | specification in this list marked as active will be used.
     |-->
    <proxies>
        <!-- proxy
         | Specification for one proxy, to be used in connecting to the network.
         |
        <proxy>
          <id>optional</id>
          <active>true</active>
          <protocol>http</protocol>
          <username>proxyuser</username>
          <password>proxypass</password>
          <host>proxy.host.net</host>
          <port>80</port>
          <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
        </proxy>
        -->
    </proxies>

    <!-- servers
     | This is a list of authentication profiles, keyed by the server-id used within the system.
     | Authentication profiles can be used whenever maven must make a connection to a remote server.
     |-->
    <servers>
        <!-- server
         | Specifies the authentication information to use when connecting to a particular server, identified by
         | a unique repositoryName within the system (referred to by the 'id' attribute below).
         |
         | NOTE: You should either specify username/password OR privateKey/passphrase, since these pairings are
         |       used together.
         |
        <server>
          <id>deploymentRepo</id>
          <username>repouser</username>
          <password>repopwd</password>
        </server>
        -->

        <!-- Another sample, using keys to authenticate.
        <server>
          <id>siteServer</id>
          <privateKey>/path/to/private/key</privateKey>
          <passphrase>optional; leave empty if not used.</passphrase>
        </server>
        -->
    </servers>

    
    <mirrors>

        <mirror>
            <id>alimaven</id>
            <name>aliyun maven</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
            <mirrorOf>central</mirrorOf>
        </mirror>

        <mirror>
            <id>uk</id>
            <mirrorOf>central</mirrorOf>
            <name>Human Readable Name for this Mirror.</name>
            <url>http://uk.maven.org/maven2/</url>
        </mirror>

        <mirror>
            <id>CN</id>
            <name>OSChina Central</name>
            <url>http://maven.oschina.net/content/groups/public/</url>
            <mirrorOf>central</mirrorOf>
        </mirror>

        <mirror>
            <id>nexus</id>
            <name>internal nexus repository</name>
            <!-- <url>http://192.168.1.100:8081/nexus/content/groups/public/</url>-->
            <url>http://repo.maven.apache.org/maven2</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    </mirrors>



    
    <profiles>
        

        <profile>
            <id>jdk-1.8</id>
            <activation>
                <activeByDefault>true</activeByDefault>
                <jdk>1.8</jdk>
            </activation>
            <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
                <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
            </properties>
        </profile>


    </profiles>

    <!-- activeProfiles
     | List of profiles that are active for all builds.
     |
    <activeProfiles>
      <activeProfile>alwaysActiveProfile</activeProfile>
      <activeProfile>anotherAlwaysActiveProfile</activeProfile>
    </activeProfiles>
    -->
</settings>

```





# Java EE 学习笔记
## Spring MVC
### Genaral

- [Spring boot / hibernate tutorial](https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/)
- [annotations](http://blog.csdn.net/weixin_35852328/article/details/73649232)
*************
以下内容为spring MVC部分，已摒弃
*************
- [Spring MVC官方文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
- [中文翻译版](https://linesh.gitbooks.io/spring-mvc-documentation-linesh-translation/content/)
- [中文翻译版PDF下载](https://www.gitbook.com/book/linesh/spring-mvc-documentation-linesh-translation/details)

- [利用Maven管理工具创建Spring MVC示例](http://blog.csdn.net/ronmy/article/details/55532254)

- [极客学院，仅供参考](http://wiki.jikexueyuan.com/project/spring/web-mvc-framework.html)
### Some tips and little problems  by LSL
- [EL介绍](https://stackoverflow.com/tags/el/info)
- [EL未开启解决](http://blog.csdn.net/supersunshine/article/details/33740791)

## Intelij Idea使用技巧
- [常用细节设置](http://wiki.jikexueyuan.com/project/intellij-idea-tutorial/settings-introduce-1.html)
- [高效率配置及常用快捷键](https://itjh.net/2016/08/18/idea-good-conf/)

# Git

## issue相关
- [github中使用issue](http://www.jianshu.com/p/5ba1e7f5ad70)
- [关于issue的理解](http://note.openmindclub.com/power/github-issue.html)