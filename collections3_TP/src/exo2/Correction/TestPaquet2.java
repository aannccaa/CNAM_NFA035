package exo2.Correction;

import java.util.Scanner;

public class TestPaquet2 {
	public static void main(String[] args) {
		// Creation d’un paquet
		Paquet paquet = new Paquet();
		System.out.println("taille du paquet: " + paquet.size());
		// Creation d’une main1
		MainJoueur2 maMain = paquet.creerMain2();
		System.out.println("mon jeu:");
		System.out.println(maMain);
		// Les cartes restant dans le paquet
		System.out.println("Reste dans le paquet " + paquet.size() + " cartes:");
		System.out.println(paquet);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez une valeur de carte :");
		int valeur = scanner.nextInt();
		System.out.print("Entrez une couleur de carte :");
		String couleur = scanner.next();
		Carte c = new Carte(valeur, Couleur.valueOf(couleur));
		if (maMain.contientCarte(c)) {
			System.out.println("la main contient " + c);
		} else {
			System.out.println("la main ne contient pas " + c);
		}
	}
}
