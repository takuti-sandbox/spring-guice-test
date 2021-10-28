package org.example.guice;

import org.example.spring.MobilePhone;
import org.example.spring.config.AppSpringConfig;
import org.junit.Test;

import org.example.guice.module.GuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.guice.module.SpringModule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GuiceUnitTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppSpringConfig.class);

        Injector injector = Guice.createInjector(new GuiceModule(), new SpringModule(context));

        Person person = injector.getInstance(Person.class);

        assertNotNull(person.getAddress());
        assertEquals(person.getAddress().getClass(), EmailAddress.class);

        assertNotNull(person.getPhone());
        assertEquals(person.getPhone().getClass(), MobilePhone.class);
    }

}
