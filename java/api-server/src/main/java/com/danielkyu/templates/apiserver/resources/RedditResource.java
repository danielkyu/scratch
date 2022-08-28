package com.danielkyu.templates.apiserver.resources;

import com.danielkyu.templates.apiserver.models.reddit.json.UserJson;
import com.danielkyu.templates.apiserver.models.reddit.xml.SubredditXml;
import com.danielkyu.templates.apiserver.models.reddit.xml.UserXml;
import com.danielkyu.templates.apiserver.services.api.reddit.JsonRedditService;
import com.danielkyu.templates.apiserver.services.api.reddit.XmlRedditService;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reddit")
@Produces(MediaType.APPLICATION_JSON)
public class RedditResource {
  private final JsonRedditService jsonRedditService;
  private final XmlRedditService xmlRedditService;

  @Inject
  public RedditResource(JsonRedditService jsonRedditService, XmlRedditService xmlRedditService) {
    this.jsonRedditService = jsonRedditService;
    this.xmlRedditService = xmlRedditService;
  }

  @GET
  @Path("/subreddit/{subreddit}.xml")
  public SubredditXml getSubredditAsXml(@PathParam("subreddit") Optional<String> subreddit) throws Exception {
    return this.xmlRedditService.getSubreddit(subreddit.orElse("")).execute().body();
  }

  @GET
  @Path("/users/{user}.json")
  public UserJson getUserAsJson(@PathParam("user") Optional<String> user) throws Exception {
    return this.jsonRedditService.getUser(user.orElse("")).execute().body();
  }

  @GET
  @Path("/users/{user}.xml")
  public UserXml getUserAsXml(@PathParam("user") Optional<String> user) throws Exception {
    return this.xmlRedditService.getUser(user.orElse("")).execute().body();
  }
}
