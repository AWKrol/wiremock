package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import services.*;
import stubs.Stubs;

public class GuiceModule extends AbstractModule {

  @Provides
  public Specifications getSpecifications() {
    return new Specifications();
  }

  @Provides
  public Stubs getStubs() {
    return new Stubs();
  }

  @Provides
  public ServicesApiStubs getServicesApi() {
    return new ServicesApiStubs();
  }

}
