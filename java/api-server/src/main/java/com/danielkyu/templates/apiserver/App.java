package com.danielkyu.templates.apiserver;

import com.danielkyu.templates.apiserver.modules.ResourceModule;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Config> {
  public static final void main(String[] argv) throws Exception {
    new App().run(argv);
  }

  @Override
  public void initialize(Bootstrap<Config> bootstrap) {
    bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
  }

  @Override
  public void run(Config config, Environment environment) throws Exception {
    AppComponent appComponent =
        DaggerAppComponent.builder().resourceModule(new ResourceModule(config)).build();

    environment.jersey().register(appComponent.getRedditResource());
    environment.jersey().register(appComponent.getRootResource());
  }
}