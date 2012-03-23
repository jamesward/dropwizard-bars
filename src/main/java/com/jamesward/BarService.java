package com.jamesward;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class BarService extends Service<Configuration> {

    public static void main(String[] args) throws Exception {
        new BarService().run(args);
    }

    private BarService() {
        super("bars");
        addBundle(new AssetsBundle("/assets/", 0, "/"));
    }

    @Override
    protected void initialize(Configuration configuration, Environment environment) {
        environment.addResource(new BarResource());
    }

}
