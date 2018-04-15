package exo2;

import java.util.ArrayList;
import java.util.Collections;

/*
Question 6 : paquet de cartes
On représente un paquet de cartes par la classe Paquet. Quand on cree un paquet, il est complet 
(cartes de valeurs 1 à 13 pour chaque couleur) et melangé. On dote la classe Paquet d’une méthode 
toString et d’une méthode size(). Une méthode creerMainDeJoueur1 permettra de tirer 5 cartes du paquet 
(les 5 premieres, par exemple), pour constituer une main, puis de retourner cette main. 
Sa signature est public MainDeJoueur1 creerMain1().
Notez que l’on doit retirer du paquet les cartes tirées et mises dans le resultat de cette méthode.
 */

public class Paquet {

	private ArrayList<Carte> cartes;

	public Paquet() {
		cartes = new ArrayList<Carte>();
		for (Couleur couleur : Couleur.values()) {
			for (int i = 0; i < 12; i++) {
				cartes.add(new Carte(i, couleur));
			}
		}
		// on mélange les cartes dans le paquet
		Collections.shuffle(cartes);
	}

	public MainJoueur1 creerMainDeJoueur1() {
		MainJoueur1 main = new MainJoueur1();
		int indexDerniereCarte = cartes.size() - 1;
		Carte derniereCarte = cartes.get(indexDerniereCarte);
		// on prend 5 cartes du paquet
		for (int i = 0; i < 5; i++) {
			// on ajoute dans la main la dernière carte du paquet
			main.addCarte(derniereCarte);
			// et on l'enlève du paquet
			cartes.remove(derniereCarte);
		}
		return main;
	}

	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Carte c : cartes) {
			buffer.append(c);
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
