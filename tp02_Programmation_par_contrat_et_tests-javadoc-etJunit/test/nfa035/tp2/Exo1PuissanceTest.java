package nfa035.tp2;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Exo1PuissanceTest {

	@Test(timeout=1000)
	public void testPuissanceNormale() {
		Assert.assertEquals("2 puissance 3 = 8", 8.0, Exo1Puissance.puissance(2, 3), 1e-5);
	}

	@Test(timeout=1000)
	public void testPuissance0() {
		Assert.assertEquals("2 puissance 0 = 1", 1.0, Exo1Puissance.puissance(2, 0), 1e-5);
	}

	@Test(timeout=1000)
	public void test0Puissance0() {
		Assert.assertEquals("0 puissance 0 = 1", 1.0, Exo1Puissance.puissance(0, 0), 1e-5);
	}
	
	@Test(timeout=1000)
	public void testPuissanceNegative() {
		Assert.assertEquals("2 puissance -1", 0.5, Exo1Puissance.puissance(2, -1), 1e-5);
	}
	
	@Test(timeout=1000)
	public void testPuissanceParite() {
		Assert.assertEquals("-2 puissance 2", 4, Exo1Puissance.puissance(-2, 2), 1e-5);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testException() {
		double r= Exo1Puissance.puissance(0, -1);		
	}
	
}
