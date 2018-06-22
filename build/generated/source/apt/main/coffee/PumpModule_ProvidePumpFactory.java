package coffee;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PumpModule_ProvidePumpFactory implements Factory<Pump> {
  private final PumpModule module;

  private final Provider<Thermosiphon> pumpProvider;

  public PumpModule_ProvidePumpFactory(PumpModule module, Provider<Thermosiphon> pumpProvider) {
    this.module = module;
    this.pumpProvider = pumpProvider;
  }

  @Override
  public Pump get() {
    return Preconditions.checkNotNull(
        module.providePump(pumpProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static PumpModule_ProvidePumpFactory create(
      PumpModule module, Provider<Thermosiphon> pumpProvider) {
    return new PumpModule_ProvidePumpFactory(module, pumpProvider);
  }

  public static Pump proxyProvidePump(PumpModule instance, Object pump) {
    return Preconditions.checkNotNull(
        instance.providePump((Thermosiphon) pump),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
