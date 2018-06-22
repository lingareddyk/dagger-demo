package coffee;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DripCoffeeModule_ProvideHeaterFactory implements Factory<Heater> {
  private final DripCoffeeModule module;

  public DripCoffeeModule_ProvideHeaterFactory(DripCoffeeModule module) {
    this.module = module;
  }

  @Override
  public Heater get() {
    return Preconditions.checkNotNull(
        module.provideHeater(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DripCoffeeModule_ProvideHeaterFactory create(DripCoffeeModule module) {
    return new DripCoffeeModule_ProvideHeaterFactory(module);
  }

  public static Heater proxyProvideHeater(DripCoffeeModule instance) {
    return Preconditions.checkNotNull(
        instance.provideHeater(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
