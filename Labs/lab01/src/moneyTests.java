import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class moneyTests {
	private Money m10BRL;
	private Money m5BRL;
	
	@Before
	public void setUp() {
		Currency testCurrency = new Currency("BRL");
		
		m10BRL = new Money();
		m10BRL.setAmount(10);
		m10BRL.setCurrency(testCurrency);
		
		m5BRL = new Money();
		m5BRL.setAmount(5);
		m5BRL.setCurrency(testCurrency);
	}
	
	@Test
	public void WhenAddMoneyThenTheyAddAssertTrue() {
		
		Money sum15BRL = new Money();
		sum15BRL = m10BRL.add(m5BRL);
		sum15BRL.getCurrency().setStringCurrency("BRL");
		
		assertTrue(sum15BRL.getAmount() == 15);
		assertTrue(sum15BRL.getCurrency().getStringCurrency() == "BRL");
	}
	
	@Test
	public void WhenAddMoneyThenTheyAddAssertEquals() {
		
		Money sum15BRL = new Money();
		sum15BRL = m10BRL.add(m5BRL);
		sum15BRL.getCurrency().setStringCurrency("BRL");
		
		assertEquals(sum15BRL.getAmount(), 15);
		assertEquals(sum15BRL.getCurrency().getStringCurrency(), "BRL");
	}
}
