package com.danielkyu.templates.apiserver.modules;

import com.danielkyu.templates.apiserver.services.api.ReqresInService;
import com.danielkyu.templates.apiserver.services.api.reddit.JsonRedditService;
import com.danielkyu.templates.apiserver.services.api.reddit.XmlRedditService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;

@Module
public class ServiceModule {
  @Provides
  @Singleton
  public JsonRedditService provideJsonRedditService(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl("https://www.reddit.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(JsonRedditService.class);
  }

  @Provides
  @Singleton
  public XmlRedditService provideXmlRedditService(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl("https://www.reddit.com/")
        .addConverterFactory(JaxbConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(XmlRedditService.class);
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
