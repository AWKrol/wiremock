package stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.inject.Inject;
import utils.JsonUtil;

public class Stubs {
  private JsonUtil jsonUtil;
  public WireMockServer wireMockServer;

  @Inject
  public Stubs() {
  }

  public Stubs setUp() {
    wireMockServer = new WireMockServer(3467);
    wireMockServer.start();
    jsonUtil = new JsonUtil();
    return this;
  }

  public Stubs resetServer() {
    wireMockServer.resetAll();
    return this;
  }

  public Stubs stubForGetUserAll(String responseFileName) {
    wireMockServer.stubFor(get("/user/get/all")
        .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBodyFile("json/" + responseFileName)));
    return this;
  }

  public Stubs stubForGetCourseAll(String responseFileName) {
    wireMockServer.stubFor(get("/course/get/all")
        .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBodyFile("json/" + responseFileName)));
    return this;
  }

  public Stubs stubForGetUserById(String responseFileName, int id) {
    wireMockServer.stubFor(get(String.format("/user/get/%d", id))
        .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBodyFile("json/" + responseFileName)));
    return this;
  }

  public Stubs status() {
    System.out.println("Stubs Started!");
    return this;
  }

  public void stopServer() {
    wireMockServer.stop();
    System.out.println("Stubs Stop!");
  }

}
