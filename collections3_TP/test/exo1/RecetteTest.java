package exo1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exo1.Recette;
import exo1.RecetteException;

public class RecetteTest {

	Recette tartePommes;

	@Before
	public void init() {
		tartePommes = new Recette("Tarte aux pommes");
	}

	@Test
	public void getMoyenneNotes() {
		int[] notes = { 1, 3, 2 };
		for (int note : notes) {
			tartePommes.addNote(note);
		}
		double actuals = tartePommes.getMoyenneNotes();
		Assert.assertEquals(2, actuals, 1e-5);
	}

	@Test
	public void addNote() {
		int[] notes = tartePommes.getNotes();
		Assert.assertEquals(notes.length, 0);
		tartePommes.addNote(5);
		notes = tartePommes.getNotes();
		int[] expected = { 5 };
		Assert.assertArrayEquals(expected, notes);
	}

	@Test(expected = RecetteException.class)
	public void addNoteSup5() {
		tartePommes.addNote(10);
	}

	@Test(expected = RecetteException.class)
	public void addNoteInf1() {
		tartePommes.addNote(0);
	}

	@Test
	public void toStringTest() {
		String tartePommesString = "Tarte aux pommes";
		String actual = tartePommes.toString();
		Assert.assertEquals(tartePommesString, actual);

		tartePommes.addNote(1);
		actual = tartePommes.toString();
		Assert.assertEquals(String.format("%s (%.1f)", tartePommesString, 1.0), actual);

		tartePommes.addNote(2);
		tartePommes.addNote(2);
		actual = tartePommes.toString();
		Assert.assertEquals(String.format("%s (%.1f)", tartePommesString, 5.0 / 3), actual);
	}

}
