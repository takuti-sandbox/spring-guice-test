Example: [spring-guice](https://github.com/spring-projects/spring-guice)
===

Guice and Spring are major Dependency Injection (DI) frameworks. In this example, we inject Spring-based dependency to Guice-based base class by leveraging [spring-guice](https://github.com/spring-projects/spring-guice).

- Target: `Person`, depending on Guice's `@Inject`
- Dependencies
	- `Address` - Naturally bound by a Guice module
	- `Phone` - Implementation is found by a Spring configuration class 

```java
import org.example.spring.config.AppSpringConfig;
import org.example.guice.module.GuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.guice.module.SpringModule;

AnnotationConfigApplicationContext context = 
		new AnnotationConfigApplicationContext(AppSpringConfig.class);

Injector injector = Guice.createInjector(new GuiceModule(), new SpringModule(context));

Person person = injector.getInstance(Person.class);
```

References:

- [Guice vs Spring – Dependency Injection](https://www.baeldung.com/guice-spring-dependency-injection)
- [eugenp/tutorials](https://github.com/eugenp/tutorials)
