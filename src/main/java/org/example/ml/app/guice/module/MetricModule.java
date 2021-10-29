package org.example.ml.app.guice.module;

import org.example.ml.app.guice.Recall;
import org.example.ml.framework.Metric;
import com.google.inject.AbstractModule;

public class MetricModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Metric.class).to(Recall.class);
    }

}
