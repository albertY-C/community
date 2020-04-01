## CHAOMI论坛

## 部署
- Git
- JDK
- Maven
- MySQL

## 步骤
- yum update  
- yum git  
- mkdir App  
- java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar
- ps -aux | grep java

## 资料
[spring Web 文档](https://spring.io/guides/gs/serving-web-content/)  
[ES 社区](https://elasticsearch.cn/)   
[Bootstraps 文档](https://v3.bootcss.com/getting-started/)  
[GitHub 授权文档](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)   
[Spring](http://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[页面布局参考](https://v3.bootcss.com/css/#grid)  
[Themeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)  
[页面模板](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#template-layout)  
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-view)  
[Markdown插件](http://editor.md.ipandao.com/)  

## 工具
[Git下载](https://git-scm.com/download)  
[GitHub托管](https://github.com/albertY-C?tab=repositories)  
[H2数据库](http://www.h2database.com/html/main.html)  
[Flyway](http://flyway.org/getstarted/firststeps/maven)  
[Postman](http://chrome.google.com/wbstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)  

## 脚本
```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate  
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate  
ps -aux | grep java
```

