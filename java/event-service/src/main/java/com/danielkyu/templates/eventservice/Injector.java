package com.danielkyu.templates.eventservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.danielkyu.templates.eventservice.modules.AppModule;

public final class Injector {
  public static AppComponent getInjector(Context context) {
    return DaggerAppComponent.builder().appModule(new AppModule(context)).build();
  }
}
