package com.danielkyu.templates.eventservice.modules;

import com.danielkyu.templates.eventservice.services.apis.RedditService;
import com.danielkyu.templates.eventservice.services.apis.ReqresInService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class ServiceModule {
  @Provides
  @Singleton
  public RedditService provideRedditService(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl("https://reddit.com/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(RedditService.class);
  }

  @Provides
  @Singleton
  public ReqresInService provideReqresInService(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(JacksonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ReqresInService.class);
  }
}
