Example: [spring-guice](https://github.com/spring-projects/spring-guice)
===

Guice and Spring are major Dependency Injection (DI) frameworks in Java. This example demonstrates how to apply Spring-based injection logic to Guice-based applications by leveraging [**spring-guice**](https://github.com/spring-projects/spring-guice).

In short, **spring-guice** enables you to build an injector that mixes Spring and Guice module as follows:

```java
AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(SpringAppConfig.class);

Injector injector = Guice.createInjector(new SpringModule(context), new GuiceModule());

GuiceApp app = injector.getInstance(GuiceApp.class);
```

Read "[**Cross-Framework Dependency Injection with spring-guice**](https://takuti.me/note/spring-guice/)" for the details.

References:

- [Guice vs Spring – Dependency Injection](https://www.baeldung.com/guice-spring-dependency-injection)
- [eugenp/tutorials](https://github.com/eugenp/tutorials)
