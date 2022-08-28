package com.danielkyu.templates.apiserver.models.reddit.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {
  @lombok.Data
  @Builder
  @Jacksonized
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Data {
    @lombok.Data
    @Builder
    @Jacksonized
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Child {
      @lombok.Data
      @Builder
      @Jacksonized
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class Child_Data {
        @JsonProperty
        private String title;
  
        @JsonProperty("author")
        private String author;
  
        @JsonProperty("created_utc")
        private Long createdAt;
      }
  
      @JsonProperty
      private Child_Data data;
    }
  
    @JsonProperty
    List<Child> children;
  }
  
  @JsonProperty
  private Data data;
}
