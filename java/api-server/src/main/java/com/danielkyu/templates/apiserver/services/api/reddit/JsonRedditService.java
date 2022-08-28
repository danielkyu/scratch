package com.danielkyu.templates.apiserver.services.api.reddit;

import com.danielkyu.templates.apiserver.models.reddit.json.UserJson;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonRedditService {
  @GET("/user/{user}.json")
  Call<UserJson> getUser(@Path("user") String user);
}
