package sujetcartes;

import java.util.ArrayList;

public class TestCartes0 {

	public static void main(String[] args) {
	
		// question 2: expliquez les affichages puis corrigez (voir énoncé)
		ArrayList<Carte> cartes = new ArrayList<Carte>();

		cartes.add(new Carte(10, Couleur.Carreau));
		cartes.add(new Carte(1, Couleur.Coeur));

		if (cartes.contains(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
	}
}
