package exo2;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void findById() {
		Recette r = livre.findById(brownie.getId());
		Assert.assertEquals(brownie, r);
	}

	@Test
	public void addRecetteTest() {
		Recette saladeDeFruits = new Recette("Salade de fruits");
		livre.addRecette(saladeDeFruits);
		Recette r = livre.findById(saladeDeFruits.getId());
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
		livre.removeRecette(saladeDeFruits.getId());
		Assert.assertEquals(initialCount, livre.getCountRecettes());
		Assert.assertEquals(null, livre.findById(saladeDeFruits.getId()));
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
		String actual = livre.toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void sortByNoteDesc() {
		glaceVanille.addNote(3);
		brownie.addNote(4);
		livre.sortByNoteDesc();
		ArrayList<Recette> livreDesc = livre.getRecettes();
		Recette[] expecteds = {brownie, glaceVanille};
		Assert.assertArrayEquals(expecteds, livreDesc.toArray());
	}
	
	@Test
	public void sortByNomEtNote() {
		glaceVanille.addNote(3);
		brownie.addNote(4);
		Recette brownie2 = new Recette(brownie.getNom());
		livre.addRecette(brownie2);
		brownie2.addNote(5);
		Recette cremeschnitte = new Recette("cremeschnitte");
		livre.addRecette(cremeschnitte);
		Recette cremeschnitte2 = new Recette("Cremeschnitte");
		livre.addRecette(cremeschnitte2);
		livre.sortByNomEtNote();
		ArrayList<Recette> livreDesc = livre.getRecettes();
		Recette[] expecteds = {brownie2, brownie, cremeschnitte, cremeschnitte2, glaceVanille};
		Assert.assertArrayEquals(expecteds, livreDesc.toArray());
	}
	
	
}
