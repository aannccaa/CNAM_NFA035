package exo2;

import java.util.Scanner;

public class TestPaquet {
	public static void main(String[] args) {
		// Creation d’un paquet
		Paquet paquet = new Paquet();
		System.out.println("nb. cartes paquet : " + paquet.size());
		// Creation d’une main1
		MainJoueur1 maMain = paquet.creerMain1();

		System.out.println("mon jeu : ");
		System.out.println(maMain);

		// Les cartes restant dans le paquet
		System.out.println("Nb. cartes restant dans le paquet: " + paquet.size());
		System.out.println(paquet);
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez une valeur de carte: ");
		int valeurCarte = scan.nextInt();
		System.out.println("Entrez une valeur de carte parmis (carreau, pique, carreau, trefle): ");
		String couleurCarte = scan.next().toUpperCase();
		Carte c = new Carte(valeurCarte, Couleur.valueOf(couleurCarte));
		if (maMain.contient(c)) {
			System.out.println("La main contient la carte " + c.toString());
		} else {
			System.out.println("La main ne contient pas la carte " + c.toString());
		}
	}
}
