package com.danielkyu.templates.eventservice.services.apis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RedditService {
  @GET("/")
  Call<String> getPageXml();
}
