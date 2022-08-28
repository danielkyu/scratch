package com.danielkyu.templates.apiserver.resources;

import com.danielkyu.templates.apiserver.Config;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {
  private final Config config;

  @Inject
  public RootResource(Config config) {
    this.config = config;
  }

  @GET
  @Path("/echo")
  public String echo(@QueryParam("message") Optional<String> message) {
    return message.orElse("");
  }

  @GET
  @Path("/env")
  public String env() {
    return this.config.getEnv();
  }
}
