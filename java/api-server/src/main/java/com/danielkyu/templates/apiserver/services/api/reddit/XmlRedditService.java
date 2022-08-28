package com.danielkyu.templates.apiserver.services.api.reddit;

import com.danielkyu.templates.apiserver.models.reddit.xml.SubredditXml;
import com.danielkyu.templates.apiserver.models.reddit.xml.UserXml;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface XmlRedditService {
  @GET("/r/{subreddit}.xml")
  Call<SubredditXml> getSubreddit(@Path("subreddit") String subreddit);

  @GET("/user/{user}.xml")
  Call<UserXml> getUser(@Path("user") String user);
}
