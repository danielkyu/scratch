package com.danielkyu.templates.apiserver;

import com.danielkyu.templates.apiserver.modules.NetworkModule;
import com.danielkyu.templates.apiserver.modules.ResourceModule;
import com.danielkyu.templates.apiserver.modules.ServiceModule;
import com.danielkyu.templates.apiserver.resources.RedditResource;
import com.danielkyu.templates.apiserver.resources.RootResource;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {NetworkModule.class, ResourceModule.class, ServiceModule.class})
public interface AppComponent {
  RedditResource getRedditResource();
  RootResource getRootResource();
}
