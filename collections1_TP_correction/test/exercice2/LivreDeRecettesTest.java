package exercice2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class LivreDeRecettesTest {
	public static final String R0= "oeufs";
	public static final String R1= "pizza";
	public static final String R2= "asperges";
	@Test
	public void testerCreation() {
		LivreDeRecettes l= new LivreDeRecettes();
		assertEquals(0, l.getNombreDeRecettes());
	}


	@Test
	public void testerAjout() {
		LivreDeRecettes l = creerLivre();		
		assertEquals(3, l.getNombreDeRecettes());
		assertEquals(R0, l.getRecette(0).getTitre());
		assertEquals(R1, l.getRecette(1).getTitre());
	}


	private LivreDeRecettes creerLivre() {
		LivreDeRecettes l= new LivreDeRecettes();
		l.ajouterRecette(R0);
		l.ajouterRecette(R1);
		l.ajouterRecette(R2);
		return l;
	}
	
	@Test
	public void testerNotation() {
		LivreDeRecettes l = creerLivre();
		l.noterRecette(0, 4);
		l.noterRecette(1, 4);
		l.noterRecette(1, 2);
		assertEquals(4, l.getRecette(0).getMoyenneNotes(), 1.0e-10);
		assertEquals(3, l.getRecette(1).getMoyenneNotes(), 1.0e-10);
	}
	
	@Test
	public void testerTriParNotes() {
		LivreDeRecettes l= creerLivre();
		l.noterRecette(0, 2);
		l.noterRecette(2, 4);
		l.noterRecette(2, 2);
		// ordre attendu : R1, R0, R2
		List<Recette> trie= l.recettesTrieesParNote();
		assertEquals(R1, trie.get(0).getTitre());
		assertEquals(R0, trie.get(1).getTitre());
		assertEquals(R2, trie.get(2).getTitre());
	}
		

	@Test
	public void testerTriParTitre() {
		LivreDeRecettes l= creerLivre();
		l.noterRecette(0, 2);
		// ordre attendu : R2, R0, R1
		List<Recette> trie= l.recettesTrieesParTitre();
		assertEquals(R2, trie.get(0).getTitre());
		assertEquals(R0, trie.get(1).getTitre());
		assertEquals(R1, trie.get(2).getTitre());
	}
}
