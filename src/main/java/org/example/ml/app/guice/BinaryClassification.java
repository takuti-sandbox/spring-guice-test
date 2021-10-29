package org.example.ml.app.guice;

import org.example.ml.framework.Metric;
import org.example.ml.framework.Model;
import com.google.inject.Inject;

public class BinaryClassification {

    @Inject
    private Model model;

    @Inject
    private Metric metric;

    public Model getModel() {
        return model;
    }

    public Metric getMetric() {
        return metric;
    }

}
