package coffee;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class ElectricHeaterTest
{
	@Test
	public void constructingElectricHeater_ShouldWork() throws Exception
	{
		final Heater heater = new ElectricHeater();
		final Heater other = new ElectricHeater();

		Assertions.assertThat( heater )
			.isEqualToComparingFieldByFieldRecursively( other )
			.as( "The constructor of ElectricHeater has no special requirements and should always work." );
	}

	@Test
	public void initialElectricHeater_ShouldNotBeHot() throws Exception
	{
		final Heater heater = new ElectricHeater();

		Assertions.assertThat( heater.isHot() )
			.isEqualTo( false )
			.as( "The initial state of the electrical heater should not be hot." );
	}

	@Test
	public void turnedOffElectricHeater_ShouldNotBeHot() throws Exception
	{
		// given
		final Heater heater = new ElectricHeater();

		// when
		heater.off();

		Assertions.assertThat( heater.isHot() )
			.isEqualTo( false )
			.as( "The turned off electrical heater should not be hot." );
	}

	@Test
	public void turnedOnElectricHeater_ShouldBeHot() throws Exception
	{
		// given
		final Heater heater = new ElectricHeater();

		// when
		heater.on();

		Assertions.assertThat( heater.isHot() )
			.isEqualTo( true )
			.as( "The turned on electrical heater should be hot." );
	}

	@Test
	public void turnedOnElectricHeater_ShouldPrintMessage() throws Exception
	{
		// given
		final Heater heater = new ElectricHeater();

		// redirect  sysout
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream backup = System.out;
		System.setOut( new PrintStream( outContent ) );

		// when
		heater.on();

		// cleanup
		System.setOut( backup );

		Assertions.assertThat( outContent.toString() )
			.isEqualTo( "~ ~ ~ heating ~ ~ ~" + System.lineSeparator() )
			.as( "The turned on electrical heater should give some info about his status." );
	}
}
