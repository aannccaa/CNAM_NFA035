package colectii.map.elev;

import java.util.Comparator;

public class ComparatorEleviDupaMediiMaterie implements Comparator<Elev> {
	String materie;
	
	public ComparatorEleviDupaMediiMaterie(String materie) {
		this.materie = materie;
	}
	
	@Override
	public int compare(Elev e1, Elev e2) {
		Double medieE1 = e1.getMedieMaterie2(materie);
		Double medieE2 = e2.getMedieMaterie2(materie);
		int result = - medieE1.compareTo(medieE2);//folosesc minus pt ordine descrescator
		
		return result;
	}
	
}
