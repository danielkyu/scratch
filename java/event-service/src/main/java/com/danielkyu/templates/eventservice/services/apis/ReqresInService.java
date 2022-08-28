package com.danielkyu.templates.eventservice.services.apis;

import com.danielkyu.templates.eventservice.models.reqres.ReqresInUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReqresInService {
  @GET("/api/users/{id}")
  Call<ReqresInUser> getUser(@Path("id") int id);
}
