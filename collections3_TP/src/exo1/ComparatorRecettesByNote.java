package exo1;

import java.util.Comparator;

public class ComparatorRecettesByNote implements Comparator<Recette> {

	@Override
	public int compare(Recette r1, Recette r2) {
		if (r1.getMoyenneNotes() > r2.getMoyenneNotes()) {
			return -1;
		} else if (r1.getMoyenneNotes() == r2.getMoyenneNotes()) {
			return 0;
		} else {
			return 1;
		}
	}

}
