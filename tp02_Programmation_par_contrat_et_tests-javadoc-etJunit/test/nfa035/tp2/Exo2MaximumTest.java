package nfa035.tp2;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

public class Exo2MaximumTest {


	@Test(timeout=1000)
	public void testMaxTabAllPositives() {
		double tab[] = { 2.1, 4.9, 5.0 };
		Assert.assertEquals("Max tableau 5.0", 5.0, Exo2Maximum.maximum(tab), 0);
	}

	@Test(timeout=1000)
	public void testMaxTabPositivesEtNeg() {
		double tab[] = { 2, 3, -5 };
		Assert.assertEquals("Max tableau 3", 3, Exo2Maximum.maximum(tab), 0);
	}

	@Test(timeout=1000)
	public void testMaxTabAllEquals() {
		double tab[] = { 0.0, 0.0, 0.0 };
		Assert.assertEquals("Max tableau 0.0", 0.0, Exo2Maximum.maximum(tab), 0);
	}
	
	@Test(timeout=1000)
	public void testMaxTabAllNeg() {
		double tab[] = { -3.6, -3.4, -3.1 };
		Assert.assertEquals("Max tableau -3.1", -3.1, Exo2Maximum.maximum(tab), 0);
	}


	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		double tab[] = {};
		Exo2Maximum.maximum(tab);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerException() {
		Exo2Maximum.maximum(null);
	}

}
