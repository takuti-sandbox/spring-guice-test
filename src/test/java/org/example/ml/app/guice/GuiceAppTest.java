package org.example.ml.app.guice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.example.ml.app.guice.module.MetricModule;
import org.example.ml.app.guice.module.ModelModule;
import org.example.ml.app.spring.RandomForest;
import org.example.ml.app.spring.config.SpringAppConfig;
import org.junit.Test;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.guice.module.SpringModule;

public class GuiceAppTest {

    @Test
    public void testGuice() {
        Injector injector = Guice.createInjector(new ModelModule(), new MetricModule());

        BinaryClassification app = injector.getInstance(BinaryClassification.class);

        assertNotNull(app.getModel());
        assertEquals(app.getModel().getClass(), LogisticRegression.class);

        assertNotNull(app.getMetric());
        assertEquals(app.getMetric().getClass(), Recall.class);
    }

    @Test
    public void testSpringGuice() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Injector injector = Guice.createInjector(new SpringModule(context), new MetricModule());

        BinaryClassification app = injector.getInstance(BinaryClassification.class);

        assertNotNull(app.getModel());
        assertEquals(app.getModel().getClass(), RandomForest.class);

        assertNotNull(app.getMetric());
        assertEquals(app.getMetric().getClass(), Recall.class);
    }

}
