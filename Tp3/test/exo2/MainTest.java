package exo2;

import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {

	@Test
	public void testMoyenneTabNotes() {
		AvecNote[] UEs = new AvecNote[4];
		UEs[0] = new Prog032(8, 13);
		UEs[1] = new Prog035(20, 10, 10);
		UEs[2] = new Prog032(20, 0);
		UEs[3] = new Prog035(17, 13, 20);
		assertEquals(18.75, Main.moyenneTabNotes(UEs), 1e-5);
		
	}
}
