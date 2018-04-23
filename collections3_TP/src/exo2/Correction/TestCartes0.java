package exo2.Correction;

import java.util.ArrayList;

public class TestCartes0 {

	public static void main(String[] args) {
	
		// question 2: expliquez les affichages puis corrigez (voir énoncé)
		ArrayList<Carte> cartes = new ArrayList<Carte>();

		cartes.add(new Carte(10, Couleur.Carreau));
		cartes.add(new Carte(1, Couleur.Coeur));
		
		// CORRECTION: 
		// Dans la version d'origine, la ligne qui suit ne donne pas le résultat 
		// attendu: 
		// en effet, Carte ne redéfinit pas (à l'origine) les méthodes hashCode et equals.
		// elle les hérite donc de Object.
		// DONC : deux objets Carte sont égaux ssi ils ont la même adresse.
		// Les deux 10 de Carreau que nous créons sont deux objets différents (créés par deux "new").
		// Ils ont des adresses différentes. Du coup, contains renvoie false.
		// SOLUTION: il semble logique de considérer - pour les cartes - que deux cartes sont
		// identiques si elles ont la même couleur et la même valeur, et donc de redéfinir hashCode et equals.
		if (cartes.contains(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
	}
}
