package org.example.ml.app.guice;

import org.example.ml.framework.BaseMetric;
import org.example.ml.framework.BaseModel;
import com.google.inject.Inject;

public class BinaryClassification {

    @Inject
    private BaseModel model;

    @Inject
    private BaseMetric metric;

    public BaseModel getModel() {
        return model;
    }

    public BaseMetric getMetric() {
        return metric;
    }

}
