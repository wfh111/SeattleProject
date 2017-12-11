/**
 * 
 */
package Energy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Walter Hanson
 * JUnit test for EnergyHistory
 */
public class EnergyHistoryTest {
	private EnergyHistory myHistory;
	/**
	 * @author Walter Hanson
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myHistory = new EnergyHistory();
	}

	/**
	 * @author Walter Hanson
	 * Test method for {@link Energy.EnergyHistory#add(java.lang.String, int, int)}.
	 */
	@Test
	public void testAdd() {
		myHistory.add("January", 2012, 234);
		ArrayList<Integer> months = myHistory.getMonths();
		ArrayList<Integer> years = myHistory.getYears();
		ArrayList<Integer> kWh = myHistory.getKwh();
		int month = months.get(0);
		int year = years.get(0);
		int kwh = kWh.get(0);
		assertEquals(1, month);
		assertEquals(2012, year);
		assertEquals(234, kwh);
	}

	/**
	 * @author Walter Hanson
	 * Test method for {@link Energy.EnergyHistory#delete(int)}.
	 */
	@Test
	public void testDelete() {
		myHistory.add("January", 2012, 234);
		myHistory.delete(0);
		ArrayList<Integer> months = myHistory.getMonths();
		ArrayList<Integer> years = myHistory.getYears();
		ArrayList<Integer> kWh = myHistory.getKwh();
		assertTrue(months.isEmpty());
		assertTrue(years.isEmpty());
		assertTrue(kWh.isEmpty());
	}
}
