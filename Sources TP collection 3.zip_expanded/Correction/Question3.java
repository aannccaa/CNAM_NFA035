package solutioncartes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question3 {

	public static void main(String[] args) {
	
		// question 3: on refait les tests du main TestCarte0
		ArrayList<Carte> cartes = new ArrayList<Carte>();

		cartes.add(new Carte(10, Couleur.Carreau));
		cartes.add(new Carte(1, Couleur.Coeur));

		if (cartes.contains(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		// on teste equals sur un set avec doublons
		Set<Carte> carset = new HashSet<Carte>();
		carset.add(new Carte(10, Couleur.Coeur));
		carset.add(new Carte(10, Couleur.Coeur));		
		carset.add(new Carte(7, Couleur.Pique));
		carset.add(new Carte(7, Couleur.Pique));
		carset.add(new Carte(3, Couleur.Pique));
		for(Carte c: carset){
			System.out.println(c);
		}		
	}
}
