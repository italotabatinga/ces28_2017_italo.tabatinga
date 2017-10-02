package q3test;

import static org.junit.Assert.*;

import q3.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class Teste {

	@Mock private ISensor _sensormock;
	private Alarm alarm;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		alarm = new Alarm(_sensormock);
	}

	@Test
	public void returnLowerPressure() {
		Mockito.when(_sensormock.popNextPressurePsiValue()).thenReturn(16.5);
		
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void returnHigherPressure() {
		Mockito.when(_sensormock.popNextPressurePsiValue()).thenReturn(22.0);
		
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void returnValidPressure() {
		Mockito.when(_sensormock.popNextPressurePsiValue()).thenReturn(18.0);
		
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

}
