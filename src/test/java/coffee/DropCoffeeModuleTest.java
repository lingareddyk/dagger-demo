package coffee;


import org.assertj.core.api.Assertions;
import org.junit.Test;


public class DropCoffeeModuleTest
{
	@Test
	public void constructingDropCoffeeModule_ShouldWork() throws Exception
	{
		final DripCoffeeModule module = new DripCoffeeModule();
		final DripCoffeeModule other = new DripCoffeeModule();

		Assertions.assertThat( module )
			.isEqualToComparingFieldByFieldRecursively( other )
			.as( "The constructor of DripCoffeeModule has no special requirements and should always work." );
	}

	@Test
	public void provideHeater_ShouldNeverBeNull() throws Exception
	{
		final DripCoffeeModule module = new DripCoffeeModule();
		final Heater heater = module.provideHeater();

		Assertions.assertThat( heater )
			.isNotNull()
			.as( "A provider should always return something meaningful." );
	}
}
