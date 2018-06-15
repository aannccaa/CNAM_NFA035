package colectii.map.elev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clasa {
	public final String nume;
	public final Set<Elev> elevi;

	public Clasa(String nume) {
		this.nume = nume;
		this.elevi = new HashSet<>();
	}

	public List<Nota> getMedii() {
		List<Nota> result = new ArrayList<>();
		for (Elev e : elevi) {
			List<Nota> mediiElev = e.getMedii();
			result.addAll(mediiElev);
		}
		return result;
	}

	// lista eleviilor triati in functie de nota la o materie
	public List<Elev> getEleviSortatiDupaMedie(String materie) {
		List<Elev> result = new ArrayList<>(this.elevi);
		result.sort(new ComparatorEleviDupaMediiMaterie(materie));
		return result;
	}

	public int getNumarNote(String materie) {
		int result = 0;
		for(Elev e: elevi) {
			int numarNoteElev = e.getNumarNote(materie);
			result = result + numarNoteElev;
		}
		
		return result;
	}
}
