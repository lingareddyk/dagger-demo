package coffee;


import java.util.Objects;
import javax.inject.Inject;


class Thermosiphon implements Pump {
    private final Heater heater;

    @Inject
    Thermosiphon(Heater heater) {
        Objects.requireNonNull(heater, "The 'heater' can not be 'null' because it will be used for pumping and would result in a NPE.");

        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("=> => pumping => =>");
        }
    }
}
