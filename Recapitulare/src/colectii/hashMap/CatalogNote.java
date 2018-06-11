package colectii.hashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogNote {
	// nume elev
	Set<Elev> catalog;

	public CatalogNote() {
		catalog = new HashSet<>();
	}

	public double getMedieClasa(String numeMaterie) {
		ArrayList<Double> mediiElevi = new ArrayList<>();
		for (Elev e : catalog) {
			double medieElev = e.getMedieMaterie(numeMaterie);
			mediiElevi.add(medieElev);
		}
		return Util.getMedie(mediiElevi);
	}

	public List<Elev> getCelMaiSlab(String numeMaterie) {
		List<Elev> eleviSlabi = new ArrayList<>(catalog);
		Comparator<Elev> comparator = new ComparatorElevDupaNotaMinMaterie(numeMaterie);
		List<Elev> elevi = new ArrayList<>(catalog);
		Collections.sort(elevi, comparator);
		Elev celMaiSlab = elevi.get(0);
		eleviSlabi.add(celMaiSlab);
		double notaCeaMaiSlaba = celMaiSlab.getMinMaterie(numeMaterie);
		for (int i = 1; i < elevi.size(); i++) {
			Elev elev = elevi.get(i);
			double notaMinElev = elev.getMinMaterie(numeMaterie);
			if()
			
		}
		
		return eleviSlabi;
	}
}
