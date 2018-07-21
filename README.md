

Spring boot 1 and spring boot 2 compatible utils.


Search the latest version in the cnetral repository : [Search](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22io.github.hengyunabc%22%20AND%20a%3A%22spring-boot-utils%22)

```xml
<dependency>
    <groupId>io.github.hengyunabc</groupId>
    <artifactId>spring-boot-utils</artifactId>
    <version>$version</version>
</dependency>
```

## Conditional Annotation

* @ConditionalOnSpringBoot1
* @ConditionalOnSpringBoot2

## BinderUtils

`org.springframework.boot.bind.RelaxedDataBinder` only exists in spring boot 1.

`org.springframework.boot.context.properties.bind.Binder` on exists in spring boot 2.

`BinderUtils` support both spring boot 1 and spring boot 2.

```java
TestConfig testConfig = BinderUtils.bind(environment, "ttt", TestConfig.class);
```

