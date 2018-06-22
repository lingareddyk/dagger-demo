package coffee;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;


public class PumpModuleTest
{
	@Test
	public void constructingPumpModule_ShouldWork() throws Exception
	{
		Assertions.assertThat( new PumpModule() )
			.isEqualToComparingFieldByFieldRecursively( new PumpModule() )
			.as( "It should not matter how a pump module is instantiated" );
	}

	@Test
	public void providePump_WithAnyInput_ShouldReturnSame() throws Exception
	{
		final PumpModule module = new PumpModule();
		final Thermosiphon thermosiphon = Mockito.mock( Thermosiphon.class );

		Assertions.assertThat( module.providePump( thermosiphon ) )
			.isSameAs( thermosiphon )
			.as( "The provider is just returning the input." );
	}
}
