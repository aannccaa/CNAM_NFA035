package exercice1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecetteTest {
	@Test
	public void testConstructeur() {
		Recette r= new Recette("a");
		assertEquals("a", r.getTitre());
		assertEquals(0.0, r.getMoyenneNotes(), 1.0e-10);
	}

	@Test(expected= IllegalArgumentException.class)
	public void testAddNoteHorsLimites1() {
		Recette r= new Recette("a");
		r.ajouterNote(0);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testAddNoteHorsLimites2() {
		Recette r= new Recette("a");
		r.ajouterNote(6);
	}

	@Test
	public void testAddNote1() {
		Recette r= new Recette("a");
		r.ajouterNote(4);		
		assertEquals(4.0, r.getMoyenneNotes(), 1.0e-10);
	}
	
	@Test
	public void testAddNote2() {
		Recette r= new Recette("a");
		r.ajouterNote(4);	
		r.ajouterNote(5);	
		assertEquals(4.5, r.getMoyenneNotes(), 1.0e-10);
	}
}
