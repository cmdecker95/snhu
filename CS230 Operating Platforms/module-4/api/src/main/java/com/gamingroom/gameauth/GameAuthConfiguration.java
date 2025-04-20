package com.gamingroom.gameauth;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.core.Configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class GameAuthConfiguration extends Configuration {

  /* Fields */

  @Valid
  @NotNull
  private HttpClientConfiguration httpClient = new HttpClientConfiguration();

  /* Getters */

  @JsonProperty("httpClient")
  public HttpClientConfiguration getHttpClientConfiguration() {
    return httpClient;
  }

  /* Setters */

  @JsonProperty("httpClient")
  public void setHttpClient(HttpClientConfiguration httpClient) {
    this.httpClient = httpClient;
  }
}
