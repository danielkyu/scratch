package com.danielkyu.templates.eventservice.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {
  @Provides
  @Singleton
  public OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder().build();
  }
}
