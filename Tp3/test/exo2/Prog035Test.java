package exo2;
import static org.junit.Assert.*;

import org.junit.Test;

public class Prog035Test {
	/*
	private double session1; // note session 1
	private double session2; // note session 2
	private double exam;
	(devoir1 + devoir2) * 0.4 + exam * 0.6;
	*/

	@Test
	public void TestCalculeNote_01() {
		double session1 = 10;
		double session2 = 14;
		double exam = 12;
		Prog035 note = new Prog035(session1,session2,exam);
		double current = note.calculeNote();
		assertEquals(12, current, 1e-5);	
	}
	
}
