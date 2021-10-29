package org.example.ml.app.guice.module;

import org.example.ml.framework.Model;
import org.example.ml.app.guice.LogisticRegression;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Model.class).to(LogisticRegression.class);
    }

}
