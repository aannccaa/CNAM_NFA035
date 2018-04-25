package io1.exercice3;

import java.io.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class Question2Test {
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
	public void testAvecIdentifiant() {
		tester(34, "aad12fdsf az 34");
	}

	@Test
	public void testAvecEspaceetIdentifiant() {
		tester(46, "aad 12fdsfaz (34) u1000");
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
		int val= Question2.sommeEntiers(r);
		assertEquals("extraction de "+txt,somme, val);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
