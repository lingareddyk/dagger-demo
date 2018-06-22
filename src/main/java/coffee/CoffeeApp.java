package coffee;


import javax.inject.Singleton;

import coffee.DaggerCoffeeApp_Coffee;
import dagger.Component;


public class CoffeeApp {
    @Singleton
    @Component(modules = {DripCoffeeModule.class})
    interface Coffee {
        CoffeeMaker maker();
    }

    public static void main(String[] args) {
        Coffee coffee = DaggerCoffeeApp_Coffee.builder().build();
        coffee.maker().brew();
    }
}
