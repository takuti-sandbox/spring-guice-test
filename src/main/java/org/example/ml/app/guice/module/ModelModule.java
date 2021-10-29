package org.example.ml.app.guice.module;

import org.example.ml.framework.BaseModel;
import org.example.ml.app.guice.LogisticRegression;
import com.google.inject.AbstractModule;

public class ModelModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BaseModel.class).to(LogisticRegression.class);
    }

}
