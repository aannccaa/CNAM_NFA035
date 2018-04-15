package exo1;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exo1.LivreRecettes;
import exo1.OrdreRecettes;
import exo1.Recette;
import exo1.RecetteException;

public class LivreRecettesTest {
	LivreRecettes livre;
	Recette glaceVanille;
	Recette brownie;
	int initialCount;

	@Before
	public void init() {
		livre = new LivreRecettes("Desserts inoubliables");
		glaceVanille = new Recette("Glace à la vanille");
		brownie = new Recette("Brownie");
		livre.addRecette(glaceVanille);
		livre.addRecette(brownie);
		initialCount = livre.getCountRecettes();
	}

	@Test
	public void findByNom() {
		Recette r = livre.findByNom(brownie.getNom());
		Assert.assertEquals(brownie, r);
	}

	@Test
	public void addRecetteTest() {
		Recette saladeDeFruits = new Recette("Salade de fruits");
		livre.addRecette(saladeDeFruits);
		Recette r = livre.findByNom(saladeDeFruits.getNom());
		Assert.assertEquals(r, saladeDeFruits);

		Assert.assertEquals(initialCount + 1, livre.getCountRecettes());
	}

	@Test(expected = RecetteException.class)
	public void addRecetteNulle() {
		Recette r = null;
		livre.addRecette(r);
	}

	@Test(expected = RecetteException.class)
	public void addRecetteDoublon() {
		Recette r = brownie;
		livre.addRecette(r);
	}

	@Test
	public void removeRecetteTest() {
		Recette saladeDeFruits = new Recette("Salade de fruits");
		livre.addRecette(saladeDeFruits);
		Assert.assertEquals(initialCount + 1, livre.getCountRecettes());
		livre.removeRecette(saladeDeFruits.getNom());
		Assert.assertEquals(initialCount, livre.getCountRecettes());
		Assert.assertEquals(null, livre.findByNom(saladeDeFruits.getNom()));
	}

	@Test(expected = RecetteException.class)
	public void removeRecetteInexistante() {
		Recette r = new Recette("Marrons glaces");
		livre.removeRecette(r);
	}

	@Test
	public void toStringTest() {
		glaceVanille.addNote(3);
		String expected = "Desserts inoubliables\n" + glaceVanille.toString() + "\n" + brownie.toString();
		String actual = livre.toString(OrdreRecettes.PAR_NOTES);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void sortParNotes() {
		/*
		 * brownie2: note 5
		 * brownie: note 4 
		 * glace vanille: note 3
		 * cremeschnitte: note 2
		 * cremeschnitte2: note 1
		 */
		glaceVanille.addNote(3);
		brownie.addNote(4);
		Recette brownie2 = new Recette("Brownie noisette");
		livre.addRecette(brownie2);
		brownie2.addNote(5);
		Recette cremeschnitte = new Recette("cremeschnitte");
		livre.addRecette(cremeschnitte);
		cremeschnitte.addNote(2);
		Recette cremeschnitte2 = new Recette("Cremeschnitte");
		livre.addRecette(cremeschnitte2);
		cremeschnitte2.addNote(1);
		List<Recette> recettesParNotesDesc = livre.sort(OrdreRecettes.PAR_NOTES);
		Recette[] expecteds = { brownie2, brownie, glaceVanille, cremeschnitte, cremeschnitte2 };
		Assert.assertArrayEquals(expecteds, recettesParNotesDesc.toArray());
	}

	@Test
	public void sortParNom() {
		/*
		 * brownie "Brownie": note 4 
		 * brownie2 "Brownie nouvelle recette": note 5 
		 * cremeschnitte2 "Cremeschnitte": note 1
		 * cremeschnitte "cremeschnitte": note 2
		 * glace vanille "Glace à la vanille": note 3 
		 */
		glaceVanille.addNote(3);
		brownie.addNote(4);
		Recette brownie2 = new Recette("Brownie nouvelle recette");
		livre.addRecette(brownie2);
		brownie2.addNote(5);
		Recette cremeschnitte = new Recette("cremeschnitte");
		livre.addRecette(cremeschnitte);
		cremeschnitte.addNote(2);
		Recette cremeschnitte2 = new Recette("Cremeschnitte");
		livre.addRecette(cremeschnitte2);
		cremeschnitte2.addNote(1);
		// List<Recette> recettesParNomAsc = livre.sort(OrdreRecettes.PAR_NOM);
		Recette[] expecteds = { brownie, brownie2, cremeschnitte2, glaceVanille, cremeschnitte  };
		Assert.assertArrayEquals(expecteds, livre.getRecettes().toArray());
	}
}
