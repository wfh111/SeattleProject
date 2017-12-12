package Energy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Dino Hadzic
 *
 */
public class MatTest {
	
	private Mat myMat; // test object

	
	/**
	 * @author Dino Hadzic
	 * Test for constructor method.
	 */
	@Before
	public void setUp() throws Exception {
		myMat = new Mat(30, 20, 10);
	}
	
	
	/**
	 * @author Dino Hadzic
	 * Test for getInstallCost method.
	 */
	@Test
	public void testGetInstallCost() {
		assertEquals(200, myMat.getInstallCost(), 0.00001);
	}
	
	/**
	 * @author Dino Hadzic
	 * Test for getPrice method.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(20, myMat.getPrice(), 0.00001);
	}
	
	/**
	 * @author Dino Hadzic
	 * Test for getWatts method.
	 */
	@Test
	public void testGetWatts() {
		assertEquals(30, myMat.getWatts(), 0.00001);
	}
	
	/**
	 * @author Dino Hadzic
	 * Test for getAmount method.
	 */
	@Test
	public void testGetAmount() {
		assertEquals(10, myMat.getAmount(), 0.00001);
	}

}
