Example: [spring-guice](https://github.com/spring-projects/spring-guice)
===

Guice and Spring are major Dependency Injection (DI) frameworks. In this example, we inject Spring-based dependency to Guice-based base class by leveraging [spring-guice](https://github.com/spring-projects/spring-guice).

Assume there is a machine learning framework that provides `Model` and `Metric` interface. You have built a Guice-based `BinaryClassification` application on top of the framework, which binds:

```java
public class ModelModule extends AbstractModule {
    
    @Override 
    protected void configure() {
        bind(BaseModel.class).to(LogisticRegression.class);
    }
    
}
```

```java
public class MetricModule extends AbstractModule {
    
    @Override 
    protected void configure() {
        bind(BaseMetric.class).to(Recall.class);
    }
    
}
```

Here, you found novel `RandomForest` implementation for the framework on GitHub, and it seems to be promising as an alternative to `LogisticRegression`. However, unlike your own app, the third-party code depends on Spring to achieve DI and serves the custom application in the form of `@Configuration`-annotated `SpringAppConfig` module.

In this situation, `spring-guice` enables you to easily apply the Spring-based injector to your Guice-based module as follows:

```java
AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(SpringAppConfig.class);

Injector injector = Guice.createInjector(new SpringModule(context), new MetricModule());

BinaryClassification app = injector.getInstance(BinaryClassification.class);
```

References:

- [Guice vs Spring – Dependency Injection](https://www.baeldung.com/guice-spring-dependency-injection)
- [eugenp/tutorials](https://github.com/eugenp/tutorials)
