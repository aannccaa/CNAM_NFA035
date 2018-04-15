package exo2;

import java.util.ArrayList;
import java.util.HashSet;

public class TestCartes0 {

	public static void main(String[] args) {

		// question 2: expliquez les affichages puis corrigez (voir énoncé)

		ArrayList<Carte> cartes = new ArrayList<Carte>();

		// cartes.add(new Carte(10, Couleur.CARREAU));
		// cartes.add(new Carte(1, Couleur.COEUR));

		Carte carreau10 = new Carte(10, Couleur.CARREAU);
		Carte coeur1 = new Carte(1, Couleur.COEUR);
		Carte trefle3 = new Carte(3, Couleur.TREFLE);
		Carte pique5 = new Carte(5, Couleur.PIQUE);
		Carte coeur1bis = new Carte(1, Couleur.COEUR);

		cartes.add(carreau10);
		cartes.add(coeur1);
		cartes.add(coeur1bis);

		String s;
		s = cartes.toString();
		// doublons ajoutés pour ArrayList
		System.out.println(s);

		// if (cartes.contains(carreau10)) {
		// ça marche après avoir redefini equals() dans la classe Carte
		if (cartes.contains(new Carte(10, Couleur.CARREAU))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}

		// Q3
		HashSet<Carte> cartesHashSet = new HashSet<>();

		cartesHashSet.add(coeur1);
		cartesHashSet.add(coeur1bis);

		s = cartesHashSet.toString();
		// pas de doublons ajoutés pour HashSet
		System.out.println(s);

		System.out.println("coeur1bis.equals(coeur1) ? => " + coeur1bis.equals(coeur1));
		System.out.println(coeur1.hashCode());
		System.out.println(coeur1bis.hashCode());

		System.out.println(coeur1.hashCode() == coeur1bis.hashCode());
	}
}
