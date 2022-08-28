package com.danielkyu.templates.eventservice;

public class EventServiceException extends RuntimeException {
  public EventServiceException(String msg, Throwable t) {
    super(msg, t);
  }
}
