import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.restassured.response.Response;
import modules.GuiceModule;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import stubs.Stubs;

public class BaseApiTest {

  protected ObjectMapper objectMapper = new ObjectMapper();

  private Stubs stubs = new Stubs();

  private Injector injector;

  @BeforeTest
  public void beforeTest() {
    stubs.setUp()
        .stubForGetUserById("userGetIdResponse.json", 1)
        .stubForGetUserAll("userGetAllResponse.json")
        .stubForGetCourseAll("courseGetAllResponse.json")
        .status();
  }

  @BeforeMethod
  public void init() {
    injector = Guice.createInjector(new GuiceModule());
    injector.injectMembers(this);
  }

  @AfterTest
  public void afterTest() {
    stubs.stopServer();
  }

}
