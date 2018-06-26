package collections1_TP_correction;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class RecetteTest {

	@Test
	public void test_addNote01() {
		Recette glaceVanille = new Recette("Glace vanille");
		glaceVanille.addNote(2);
		int actual = glaceVanille.getNbNotes();
		int expected = 1;

		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test(expected = RuntimeException.class)
	public void test_addNoteHorsLimite1() {
		Recette glaceVanille = new Recette("Glace vanille");
		try {
			glaceVanille.addNote(7);
		} catch (RuntimeException re) {
			String message = "La note doite être comprise entre 1 et 5";
			Assert.assertEquals(message, re.getMessage());
			throw re;
		}
	}

	@Test(expected = RuntimeException.class)
	public void test_addNoteHorsLimite2() {
		Recette glaceVanille = new Recette("Glace vanille");
		glaceVanille.addNote(-1);
	}

	public void test_getMoyenneNotes() {
		Recette glaceVanille = new Recette("Glace vanille");
		glaceVanille.addNote(2);
		glaceVanille.addNote(3);
		double expected = 2.5;
		double actual = glaceVanille.getMoyenneNotes();
		Assert.assertEquals(expected, actual, 1e-15);
	}

}
