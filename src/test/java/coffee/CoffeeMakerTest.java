package coffee;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import dagger.Lazy;


@RunWith( MockitoJUnitRunner.class )
public class CoffeeMakerTest
{
	@Mock
	public Lazy<Heater> heater;

	@Test
	@SuppressWarnings( "ConstantConditions" )
	public void instantiateCoffeeMaker_WithNullHeater_ShouldThrowException() throws Exception
	{
		Assertions.assertThatThrownBy( () -> new CoffeeMaker( null, null ) )
			.isExactlyInstanceOf( NullPointerException.class )
			.hasNoCause()
			.as( "The construction of a CoffeeMaker should fail fast if somebody tries to inject a null reference into the object" );
	}

	@Test
	@SuppressWarnings( "ConstantConditions" )
	public void instantiateCoffeeMaker_WithNullPump_ShouldThrowException() throws Exception
	{
		Assertions.assertThatThrownBy( () -> new CoffeeMaker( heater, null ) )
			.isExactlyInstanceOf( NullPointerException.class )
			.hasNoCause()
			.as( "The construction of a CoffeeMaker should fail fast if somebody tries to inject a null reference into the object" );
	}

	@Test
	public void instantiateCoffeeMaker_WithMocks_ShouldWork() throws Exception
	{
		final Pump pump = Mockito.mock( Pump.class );

		Assertions.assertThat( new CoffeeMaker( heater, pump ) )
			.isEqualToComparingFieldByFieldRecursively( new CoffeeMaker( heater, pump ) )
			.as( "It should not matter how a coffee maker is instantiated" );
	}

	@Test
	public void name() throws Exception
	{

	}
}
