package services;

import static io.restassured.RestAssured.given;

import com.google.inject.Inject;
import io.restassured.response.Response;

public class ServicesApiStubs extends Specifications {

  @Inject
  public ServicesApiStubs() {
  }

  public Response orderGet(String path) {
    return
      given(specRequest())
        .when()
        .get(path);
  }

}
