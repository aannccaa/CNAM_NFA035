package collections1_TP_correction;

import java.util.Comparator;

public class CompareRecetteByNoteDesc implements Comparator<Recette> {

	@Override
	public int compare(Recette r1, Recette r2) {
		if (r1.getMoyenneNotes() > r2.getMoyenneNotes()) {
			return -1;
		}
		if (r1.getMoyenneNotes() < r2.getMoyenneNotes()) {
			return 1;
		} else {
			return 0;
		}
	}

}
