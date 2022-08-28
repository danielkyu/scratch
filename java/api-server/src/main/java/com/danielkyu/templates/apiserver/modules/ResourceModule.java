package com.danielkyu.templates.apiserver.modules;

import com.danielkyu.templates.apiserver.Config;
import com.danielkyu.templates.apiserver.resources.RootResource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ResourceModule {
  private final Config config;

  public ResourceModule(Config config) {
    this.config = config;
  }

  @Provides
  @Singleton
  RootResource provideRootResource() {
    return new RootResource(this.config);
  }
}
