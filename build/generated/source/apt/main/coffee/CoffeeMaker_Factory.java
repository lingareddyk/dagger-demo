package coffee;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CoffeeMaker_Factory implements Factory<CoffeeMaker> {
  private final Provider<Heater> heaterProvider;

  private final Provider<Pump> pumpProvider;

  public CoffeeMaker_Factory(Provider<Heater> heaterProvider, Provider<Pump> pumpProvider) {
    this.heaterProvider = heaterProvider;
    this.pumpProvider = pumpProvider;
  }

  @Override
  public CoffeeMaker get() {
    return new CoffeeMaker(DoubleCheck.lazy(heaterProvider), pumpProvider.get());
  }

  public static CoffeeMaker_Factory create(
      Provider<Heater> heaterProvider, Provider<Pump> pumpProvider) {
    return new CoffeeMaker_Factory(heaterProvider, pumpProvider);
  }

  public static CoffeeMaker newCoffeeMaker(Lazy<Heater> heater, Object pump) {
    return new CoffeeMaker(heater, (Pump) pump);
  }
}
