package com.jamesward;

import com.google.common.cache.CacheBuilderSpec;
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

        CacheBuilderSpec cacheBuilderSpec = (System.getenv("FILE_CACHE_ENABLED") == null) ? CacheBuilderSpec.parse("maximumSize=0") : AssetsBundle.DEFAULT_CACHE_SPEC;

        addBundle(new AssetsBundle("/content/", cacheBuilderSpec, "/"));
        addBundle(new AssetsBundle("/public/", cacheBuilderSpec, "/public"));
    }

    @Override
    protected void initialize(Configuration configuration, Environment environment) {
        environment.addResource(new BarResource());
    }

}
