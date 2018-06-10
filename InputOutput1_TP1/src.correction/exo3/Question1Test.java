package exo3;

import java.io.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Question1Test {
	@Test
	public void testSimple() {
		tester(12, "12");
	}
	
	@Test
	public void testDeuxNombres() {
		tester(46, "12fdsf az 34a");
	}

	@Test
	public void testDeuxNombresFin() {
		tester(46, "12fdsf az 34");
	}

	@Test
	public void testDeuxNombresPasDebut() {
		tester(46, "aad12fdsf az 34");
	}

	@Test
	public void testChiffresAraboIndiens() {
		// Ce test fonctionne si la procédure 
		// utilise Character.isDigit et Character.getNumericValue
		tester(123, " ۱۲۳ ");
	}
	
	private void tester(int somme, String txt)  {
		try {
		StringReader r= new StringReader(txt);
		int val= Question1.sommeEntiers(r);
		assertEquals("extraction de "+txt,somme, val);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
