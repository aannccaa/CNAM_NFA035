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
		this.cartes = new ArrayList<Carte>();
		for (Couleur couleur : Couleur.values()) {
			for (int i = 1; i <= 13; i++) {
				this.cartes.add(new Carte(i, couleur));
			}
		}
		// on mélange les cartes dans le paquet
		Collections.shuffle(this.cartes);
	}
	
	public MainJoueur1 creerMain1() {
		MainJoueur1 m = new MainJoueur1();
		
		// on prend 5 cartes du paquet
		for (int i = 0; i < 5; i++) {
			// on ajoute dans la main la dernière carte du paquet
			int indexDerniereCarte = this.cartes.size() - 1;
			Carte derniereCarte = this.cartes.get(indexDerniereCarte);
			m.add(derniereCarte);
			// et on l'enlève du paquet
			this.cartes.remove(derniereCarte);
		}
		return m;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Carte c : this.cartes) {
			buffer.append(c);
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public int size() {
		return this.cartes.size();
	}
}
