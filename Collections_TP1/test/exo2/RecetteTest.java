package exo2;

import org.junit.Assert;
import org.junit.Test;

public class RecetteTest {

	@Test
	public void getMoyenneNotes() {
		int[] notes = { 1, 3, 2 };
		Recette tartePommes = new Recette("Tarte aux pommes");
		for (int note : notes) {
			tartePommes.addNote(note);
		}
		double actuals = tartePommes.getMoyenneNotes();
		Assert.assertEquals(2, actuals, 1e-5);
	}

	@Test
	public void addNote() {
		Recette tartePommes = new Recette("Tarte aux pommes");
		int[] notes = tartePommes.getNotes();
		Assert.assertEquals(notes.length, 0);
		tartePommes.addNote(5);
		notes = tartePommes.getNotes();
		int[] expected = { 5 };
		Assert.assertArrayEquals(expected, notes);
	}

	@Test(expected = RecetteException.class)
	public void addNoteSup5() {
		Recette tartePommes = new Recette("Tarte aux pommes");
		tartePommes.addNote(10);
	}

	@Test(expected = RecetteException.class)
	public void addNoteInf1() {
		Recette tartePommes = new Recette("Tarte aux pommes");
		tartePommes.addNote(0);
	}

}
