package colectii.anale;

import java.util.Comparator;

public class ComparatorCarteDupaAutorPrincipal implements Comparator<Carte> {

	@Override
	public int compare(Carte o1, Carte o2) {
		if (o1 == o2) {
			return 0;
		}
		if (o1 == null) {
			return -1;
		}
		if (o2 == null) {
			return 1;
		}
		String autorPrincipal1 = o1.getAutorPrincipal();
		String autorPrincipal2 = o2.getAutorPrincipal();
		if (autorPrincipal1 == null) {
			return autorPrincipal2 == null ? 0 : -1;
		}
		return autorPrincipal1.compareTo(autorPrincipal2);
	}

}
