package com.danielkyu.templates.eventservice.models.reqres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqresInUser {
  @lombok.Data
  @Builder
  @Jacksonized
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Data {
    @JsonProperty private Integer id;

    @JsonProperty private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty private String avatar;
  }

  @JsonProperty private Data data;
}
