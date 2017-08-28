import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class moneyBagTests {
	private Money m10BRL;
	private Money m5USD;
	private MoneyBag bag;
	
	@Before
	public void setUp() {
		Currency brlCurrency = new Currency("BRL");
		Currency usdCurrency = new Currency("USD");
		
		bag = new MoneyBag();
		
		m10BRL = new Money();
		m10BRL.setAmount(10);
		m10BRL.setCurrency(brlCurrency);
		
		m5USD = new Money();
		m5USD.setAmount(5);
		m5USD.setCurrency(usdCurrency);
		
	}
	
	@Test
	public void SizeMethodTestOfMoneyBag() {
		
		assertTrue(bag.size() == 0);
	}
	
	@Test
	public void AddMethodTestOfMoneyBag() {
		bag.add(m10BRL);
		bag.add(m5USD);
		
		assertTrue(bag.size() == 2);
	}
}
