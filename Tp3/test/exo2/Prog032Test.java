package exo2;
import static org.junit.Assert.*;

import org.junit.Test;

public class Prog032Test {
	/*
	private double session1; // note session 1
	private double session2; // note session 2
	private String code = "NFA032";
	if (session1 >= 10 || session2 == 0)
			return session1;
		else
			return session2;
	*/

	@Test
	public void TestCalculeNote_01() {
		double session1 = 10;
		double session2 = 0;
		Prog032 note = new Prog032(session1, session2);
		double current = note.calculeNote();
		assertEquals(10, current, 1e-5);	
	}
	
	@Test
	public void TestCalculeNote_02() {
		double session1 = 9.99;
		double session2 = 7;
		Prog032 note = new Prog032(session1, session2);
		double current = note.calculeNote();
		assertEquals(7, current, 1e-5);	
	}
	
	@Test
	public void TestCalculeNote_03() {
		double session1 = 10;
		double session2 = 20;
		Prog032 note = new Prog032(session1, session2);
		double current = note.calculeNote();
		assertEquals(10, current, 1e-5);	
	}
	
}
