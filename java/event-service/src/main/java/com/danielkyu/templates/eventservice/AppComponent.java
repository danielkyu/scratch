package com.danielkyu.templates.eventservice;

import com.danielkyu.templates.eventservice.handlers.HelloWorldRequestHandler;
import com.danielkyu.templates.eventservice.modules.AppModule;
import com.danielkyu.templates.eventservice.modules.NetworkModule;
import com.danielkyu.templates.eventservice.modules.ServiceModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, ServiceModule.class})
public interface AppComponent {
  void inject(HelloWorldRequestHandler requestHandler);
}
