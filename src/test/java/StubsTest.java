import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.google.inject.Inject;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.ServicesApiStubs;
import services.Specifications;

public class StubsTest extends BaseApiTest {

  @Inject
  ServicesApiStubs servicesApi;

  @Inject
  Specifications specifications;

  @Test
  public void getUserAll() {
    Response response = servicesApi.orderGet("/user/get/all");

    response
      .then()
      .spec(specifications.specResponse200())
      .body(matchesJsonSchemaInClasspath("jsonSchema/getUserAllSchema.json"))
      .log().all();
  }

  @Test
  public void getUserId() {
    Response response = servicesApi.orderGet("/user/get/1");

    response
      .then()
      .spec(specifications.specResponse200())
      .body(matchesJsonSchemaInClasspath("jsonSchema/getUserIdSchema.json"))
      .log().all();
  }

  @Test
  public void getCoursesAll() {
    Response response = servicesApi.orderGet("/course/get/all");

    response
      .then()
      .spec(specifications.specResponse200())
      .body(matchesJsonSchemaInClasspath("jsonSchema/getCoursesAllSchema.json"))
      .log().all();
  }

}
