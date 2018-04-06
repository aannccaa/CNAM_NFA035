package collections2.exercice2;

import java.util.ArrayList;
import java.util.HashSet;

public class TestCartes0 {

	public static void main(String[] args) {
	
		// question 2: expliquez les affichages puis corrigez (voir énoncé)
		ArrayList<Carte> cartes = new ArrayList<>();

		cartes.add(new Carte(10, Couleur.CARREAU)); // A)
		cartes.add(new Carte(1, Couleur.COEUR));

		// NOTE : avant l'ajout de hashCode et equals, les cartes sont identifiées
		// par leur adresse. Les deux objets créés  en A) et en B) pour 
		// représenter le 10 de carreau ont des adresses différentes,
		// et sont donc considérés comme différents.
		//
		// Après redéfinition de hashCode et equals, les cartes sont égales ssi elles
		// ont même couleur et même valeur.
		if (cartes.contains(new Carte(10, Couleur.CARREAU))) { // B)
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		
		// Question 3, fin : jeu de carte avec doublons pas doublonnant :
		HashSet<Carte> cartesSet = new HashSet<>();

		cartesSet.add(new Carte(10, Couleur.CARREAU));
		cartesSet.add(new Carte(1, Couleur.COEUR));
		cartesSet.add(new Carte(1, Couleur.COEUR));
		cartesSet.add(new Carte(10, Couleur.CARREAU));
		cartesSet.add(new Carte(1, Couleur.PIQUE));
		
		System.out.println("Contenu du hashSet : "+cartesSet);
	}
}
