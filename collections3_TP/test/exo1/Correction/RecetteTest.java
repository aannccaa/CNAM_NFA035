package exo1.Correction;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

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
	
	@Test
	public void testPasDIngredient() {
		Recette r= new Recette("a");
		Collection<String> ingredients = r.getIngredients();
		assertEquals(0, ingredients.size());
	}
	
	@Test
	public void testAjouterIngredient() {
		Recette r= new Recette("a");
		r.ajouterIngredient("sucre", 4);
		HashSet<String> attendus= new HashSet<>();
		attendus.add("sucre");
		Collection<String> ingredients = new HashSet<>(r.getIngredients());		
		assertEquals(attendus, ingredients);
		assertEquals(4, r.getQuantite("sucre"));
	}

	@Test
	public void testAjouterIngredient2() {
		Recette r= new Recette("a");
		r.ajouterIngredient("chantilly", 4);
		r.ajouterIngredient("fraise", 30);
		r.ajouterIngredient("morue", 2);
		HashSet<String> attendus= new HashSet<>(Arrays.asList("chantilly", 
				"morue", "fraise"));
		Collection<String> ingredients = new HashSet<>(r.getIngredients());		
		assertEquals(attendus, ingredients);
		assertEquals(4, r.getQuantite("chantilly"));
		assertEquals(30, r.getQuantite("fraise"));
		assertEquals(2, r.getQuantite("morue"));
	}
	
	@Test
	public void testGetQuantiteAbsent() {
		Recette r= new Recette("a");
		r.ajouterIngredient("chantilly", 4);
		assertEquals(0, r.getQuantite("morue"));
	}
	
	@Test
	public void testGetQuantiteAbsent1() {
		Recette r= new Recette("a");
		assertEquals(0, r.getQuantite("morue"));
	}

	@Test
	public void testSupprimerIngredient() {
		Recette r= new Recette("a");
		r.ajouterIngredient("chantilly", 4);
		r.ajouterIngredient("fraise", 30);
		r.ajouterIngredient("morue", 2);
		r.supprimerIngredient("fraise");
		HashSet<String> attendus= new HashSet<>(Arrays.asList("chantilly", 
				"morue"));
		Collection<String> ingredients = new HashSet<>(r.getIngredients());		
		assertEquals(attendus, ingredients);
		assertEquals(0, r.getQuantite("fraise"));	
	}
	
	@Test
	public void testAjouterIngredientQuiNestPasLa() {
		Recette r= new Recette("a");
		r.ajouterIngredient("chantilly", 4);
		r.ajouterIngredient("fraise", 30);
		r.ajouterIngredient("morue", 2);
		r.supprimerIngredient("cornichon");
		HashSet<String> attendus= new HashSet<>(Arrays.asList("chantilly", 
				"morue", "fraise"));
		Collection<String> ingredients = new HashSet<>(r.getIngredients());		
		assertEquals(attendus, ingredients);
		assertEquals(0, r.getQuantite("cornichon"));
	}
	
}
