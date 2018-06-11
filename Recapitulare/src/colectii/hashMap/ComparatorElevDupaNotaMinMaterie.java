package colectii.hashMap;

import java.util.Comparator;

public class ComparatorElevDupaNotaMinMaterie implements Comparator<Elev> {

	private String numeMaterie;

	public ComparatorElevDupaNotaMinMaterie(String numeMaterie) {
		this.numeMaterie = numeMaterie;
	}

	public int compare(Elev e1, Elev e2) {
		double minE1 = e1.getMinMaterie(this.numeMaterie);
		double minE2 = e2.getMinMaterie(this.numeMaterie);
		if (minE1 > minE2) {
			return 1;
		}
		if (minE1 < minE2) {
			return -1;
		}
		return 0;
	}
}
