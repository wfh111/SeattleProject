package Energy;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Dino Hadzic
 *
 */
public class CalculatorTest {
	private EnergyHistory myHistory;
	
	private Calculator myCalc;

	/**
	 * @author Dino Hadzic
	 * Creates history object.
	 */
	@Before
	public void setUp() throws Exception {
		myHistory = new EnergyHistory();
		myHistory.add("January", 2012, 234);
		myHistory.add("February", 2012, 230);
	}
	
	/**
	 * @author Dino Hadzic
	 * Test for constructor method.
	 */
	@Before
	public void testCalculator() {
		myCalc = new Calculator(myHistory);
	}
	
	/**
	 * @author Dino Hadzic
	 * Test for getAverage method.
	 */
	@Test
	public void testGetAverage() {
		assertEquals(232, myCalc.getAverage(), 0.00001);
	}
	

}
