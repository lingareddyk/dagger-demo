package coffee;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCoffeeApp_Coffee implements CoffeeApp.Coffee {
  private PumpModule pumpModule;

  private Provider<Heater> provideHeaterProvider;

  private DaggerCoffeeApp_Coffee(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CoffeeApp.Coffee create() {
    return new Builder().build();
  }

  private Thermosiphon getThermosiphon() {
    return new Thermosiphon(provideHeaterProvider.get());
  }

  private Pump getPump() {
    return PumpModule_ProvidePumpFactory.proxyProvidePump(pumpModule, getThermosiphon());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideHeaterProvider =
        DoubleCheck.provider(
            DripCoffeeModule_ProvideHeaterFactory.create(builder.dripCoffeeModule));
    this.pumpModule = builder.pumpModule;
  }

  @Override
  public CoffeeMaker maker() {
    return new CoffeeMaker(DoubleCheck.lazy(provideHeaterProvider), getPump());
  }

  public static final class Builder {
    private DripCoffeeModule dripCoffeeModule;

    private PumpModule pumpModule;

    private Builder() {}

    public CoffeeApp.Coffee build() {
      if (dripCoffeeModule == null) {
        this.dripCoffeeModule = new DripCoffeeModule();
      }
      if (pumpModule == null) {
        this.pumpModule = new PumpModule();
      }
      return new DaggerCoffeeApp_Coffee(this);
    }

    public Builder dripCoffeeModule(DripCoffeeModule dripCoffeeModule) {
      this.dripCoffeeModule = Preconditions.checkNotNull(dripCoffeeModule);
      return this;
    }

    public Builder pumpModule(PumpModule pumpModule) {
      this.pumpModule = Preconditions.checkNotNull(pumpModule);
      return this;
    }
  }
}
