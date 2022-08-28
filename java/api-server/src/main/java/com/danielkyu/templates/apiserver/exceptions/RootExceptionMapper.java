package com.danielkyu.templates.apiserver.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;

public class RootExceptionMapper implements ExceptionMapper<Throwable> {
  private static final Logger logger = LogManager.getLogger(RootExceptionMapper.class);

  @Override
  public Response toResponse(Throwable throwable) {
    return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500)
        .entity("{}")
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
