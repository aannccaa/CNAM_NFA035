package exo2;

import java.util.Comparator;

public class OrdreCartes implements Comparator<Carte> {

	@Override
	public int compare(Carte c1, Carte c2) {
		// L’ordre des cartes sera testé selon leur valeur
		// puis selon leur couleur.
		if (c1.getValeur() == c2.getValeur()) {
			if (c1.getCouleur().ordinal() < c2.getCouleur().ordinal()) {
				return -1;
			} else if (c1.getCouleur().ordinal() > c2.getCouleur().ordinal()) {
				return 1;
			} else {
				return 0;
			}
		} else if (c1.getValeur() < c2.getValeur()) {
			return -1;
		} else {
			return 1;
		}
	}

}
