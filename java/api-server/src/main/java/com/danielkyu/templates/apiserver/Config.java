package com.danielkyu.templates.apiserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Data;

@Data
public class Config extends Configuration {
  @JsonProperty private String env;
}
