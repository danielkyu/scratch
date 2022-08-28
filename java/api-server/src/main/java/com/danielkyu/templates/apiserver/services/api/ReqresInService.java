package com.danielkyu.templates.apiserver.services.api;

import com.danielkyu.templates.apiserver.models.reqresin.User;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReqresInService {
  @GET("/api/users/{id}")
  Call<User> getUserAsObject(@Path("id") int id);

  @GET("/api/users/{id}")
  Call<Map<String, Object>> getUserAsMap(@Path("id") int id);
}
