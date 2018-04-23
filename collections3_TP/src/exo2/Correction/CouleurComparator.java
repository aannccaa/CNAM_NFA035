package exo2.Correction;

import java.util.Comparator;

public class CouleurComparator implements Comparator<Carte>{

	@Override
	public int compare(Carte o1, Carte o2) {
		int res= o1.getCouleur().compareTo(o2.getCouleur());
		if (res != 0) {
			return res;
		} else {
			return o1.getVraieValeur() - o2.getVraieValeur();
		}
	}
	
}
