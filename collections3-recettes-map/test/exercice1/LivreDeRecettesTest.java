package exercice1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class LivreDeRecettesTest {

	public static final String R0= "oeufs";
	public static final String R1= "pizza";
	public static final String R2= "asperges";
	private LivreDeRecettes creerLivre() {
		LivreDeRecettes l= new LivreDeRecettes();
		l.ajouterRecette(R0);
		l.ajouterRecette(R1);
		l.ajouterRecette(R2);
		return l;
	}
	
	@Test
	public void testerCreation() {
		LivreDeRecettes l= new LivreDeRecettes();
		assertEquals(0, l.getNombreDeRecettes());
	}

	@Test
	public void testerAjout() {
		LivreDeRecettes l = creerLivre();		
		assertEquals(3, l.getNombreDeRecettes());
		assertEquals(R0, l.getRecette(R0).getTitre());
		assertEquals(R1, l.getRecette(R1).getTitre());
	}

	@Test
	public void testerSupprimer() {
		LivreDeRecettes l = creerLivre();		
		assertEquals(3, l.getNombreDeRecettes());
		l.supprimerRecette(R1);
		assertEquals(2, l.getNombreDeRecettes());
		assertEquals(false,l.contiens(R1));
	}
	@Test
	public void testerSupprimerAbsent() {
		LivreDeRecettes l = creerLivre();		
		assertEquals(3, l.getNombreDeRecettes());
		l.supprimerRecette("toto");
		assertEquals(3, l.getNombreDeRecettes());
		assertEquals(false,l.contiens("toto"));
	}

	@Test
	public void testerNotation() {
		LivreDeRecettes l = creerLivre();
		l.noterRecette(R0, 4);
		l.noterRecette(R1, 4);
		l.noterRecette(R1, 2);
		assertEquals(4, l.getRecette(R0).getMoyenneNotes(), 1.0e-10);
		assertEquals(3, l.getRecette(R1).getMoyenneNotes(), 1.0e-10);
	}
	
	@Test
	public void testerTriParNotes() {
		LivreDeRecettes l= creerLivre();
		l.noterRecette(R0, 2);
		l.noterRecette(R2, 4);
		l.noterRecette(R2, 2);
		// ordre attendu : R1, R0, R2
		List<Recette> trie= l.recettesTrieesParNote();
		assertEquals(R1, trie.get(0).getTitre());
		assertEquals(R0, trie.get(1).getTitre());
		assertEquals(R2, trie.get(2).getTitre());
	}
		

	@Test
	public void testerTriParTitre() {
		LivreDeRecettes l= creerLivre();
		l.noterRecette(R0, 2);
		// ordre attendu : R2, R0, R1
		List<Recette> trie= l.recettesTrieesParTitre();
		assertEquals(R2, trie.get(0).getTitre());
		assertEquals(R0, trie.get(1).getTitre());
		assertEquals(R1, trie.get(2).getTitre());
	}
}
