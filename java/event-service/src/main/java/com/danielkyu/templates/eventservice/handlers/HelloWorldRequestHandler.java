package com.danielkyu.templates.eventservice.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.danielkyu.templates.eventservice.EventServiceException;
import com.danielkyu.templates.eventservice.Injector;
import com.danielkyu.templates.eventservice.models.reqres.ReqresInUser;
import com.danielkyu.templates.eventservice.services.apis.RedditService;
import com.danielkyu.templates.eventservice.services.apis.ReqresInService;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;

public class HelloWorldRequestHandler implements RequestHandler<Map<String, Object>, ReqresInUser> {
  private LambdaLogger logger;
  private RedditService redditService;
  private ReqresInService reqresInService;

  @Inject
  void onInit(LambdaLogger logger, RedditService redditService, ReqresInService reqresInService) {
    this.logger = logger;
    this.redditService = redditService;
    this.reqresInService = reqresInService;
  }

  @Override
  public ReqresInUser handleRequest(Map<String, Object> input, Context context) {
    Injector.getInjector(context).inject(this);

    try {
      this.logger.log("INPUT: " + input);
      // this.logger.log("USER: " + this.reqresInService.getUser(1).execute().body());
      this.logger.log("###########################");
      // this.logger.log("REDDIT: " + this.redditService.getPageXml().execute().body());
      this.logger.log("***************************");

      this.logger.log("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
      return this.reqresInService.getUser(1).execute().body();
    } catch (IOException e) {
      throw new EventServiceException("XXXXXXXXXXXXXXXXXXXXXXXX", e);
    }
  }
}
