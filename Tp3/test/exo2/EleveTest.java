package exo2;

import static org.junit.Assert.*;
import org.junit.Test;

public class EleveTest {

	@Test
	public void testMoyenne() {
		Eleve e1 = new Eleve("Bob");
		e1.ajout(new Prog032(10, 0));
		e1.ajout(new Prog035(5, 15, 12));
		// Moyenne ((5+15)*.4 + 12*.6 + 10)/2 = 12.6
		assertEquals(12.6, e1.moyenne(), 1e-5);
	}
}
