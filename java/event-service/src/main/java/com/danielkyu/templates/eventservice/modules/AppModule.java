package com.danielkyu.templates.eventservice.modules;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.danielkyu.templates.eventservice.AppConfig;
import com.danielkyu.templates.eventservice.EventServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Singleton;

@Module
public class AppModule {
  private final Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  public AppConfig provideAppConfig() {
    String configFile = "/config.yaml";
    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    try (InputStream in = AppModule.class.getResourceAsStream(configFile)) {
      return objectMapper.readValue(in, AppConfig.class);
    } catch (IOException e) {
      throw new EventServiceException("Failed to load configuration from resources: " + configFile, e);
    }
  }
  
  @Provides
  @Singleton
  public LambdaLogger providLambdaLogger() {
    return this.context.getLogger();
  }
}
