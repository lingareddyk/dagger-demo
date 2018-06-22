package coffee;


import dagger.Lazy;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import static java.util.Objects.requireNonNull;


class CoffeeMaker {
    @Nonnull
    private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.

    @Nonnull
    private final Pump pump;

    @Inject
    CoffeeMaker(@Nonnull Lazy<Heater> heater, @Nonnull Pump pump) {
        this.heater = requireNonNull(heater, "The 'heater' can not be 'null'");
        this.pump = requireNonNull(pump, "The 'pump' can not be 'null'.");
    }

    void brew() {
        heater.get().on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.get().off();
    }
}
