package coffee;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;


public class ThermosiphonTest
{
	@Test
	public void constructingThermosiphon_WithNull_ShouldFail()
	{
		Assertions.assertThatThrownBy( () -> new Thermosiphon( null ) )
			.as( "The constructor should not be able to be initialized with 'null'." )
			.isExactlyInstanceOf( NullPointerException.class )
			.hasNoCause();
	}

	@Test
	public void constructingThermosiphon_WithHeater_ShouldWork() throws Exception
	{
		final Heater heaterMock = Mockito.mock( Heater.class );

		Assertions.assertThat( new Thermosiphon( heaterMock ) )
			.isEqualToComparingFieldByFieldRecursively( new Thermosiphon( heaterMock ) )
			.as( "Both thermosiphons use the same heater and should be the same and not 'null'." );
	}

	@Test
	public void pump_WithColdHeater_ShouldWork() throws Exception
	{
		// given
		final Heater heaterMock = Mockito.mock( Heater.class );
		Mockito.when( heaterMock.isHot() ).thenReturn( false );

		// redirect  sysout
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream backup = System.out;
		System.setOut( new PrintStream( outContent ) );

		// when
		new Thermosiphon( heaterMock ).pump();

		// cleanup
		System.setOut( backup );

		// then
		Assertions.assertThat( outContent.toString() )
			.isEqualTo( "" )
			.as( "Since the heater is cold, the thermosiphon is not working and should not print anything into system.out." );
	}

	@Test
	public void pump_WithHotHeater_ShouldWork() throws Exception
	{
		// given
		final Heater heaterMock = Mockito.mock( Heater.class );
		Mockito.when( heaterMock.isHot() ).thenReturn( true );

		// redirect  sysout
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream backup = System.out;
		System.setOut( new PrintStream( outContent ) );

		// when
		new Thermosiphon( heaterMock ).pump();

		// cleanup
		System.setOut( backup );

		// then
		Assertions.assertThat( outContent.toString() )
			.isEqualTo( "=> => pumping => =>" + System.lineSeparator() )
			.as( "Since the heater is hot, the thermosiphon should work and should print a String into the system.out." );
	}
}
