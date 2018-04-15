package exo2.Correction;

import java.util.Scanner;

public class TestPaquet {
	public static void main(String[] args) {
		Paquet paquet = new Paquet();
		System.out.println("taille du paquet: "+paquet.size());
		MainJoueur1 maMain = paquet.creerMain1();
		System.out.println("mon jeu: ");
		System.out.println(maMain);
		System.out.println("Reste dans le paquet  "+paquet.size()+ " cartes:");
		System.out.println(paquet);	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez une valeur de carte :");
		int valeur = scanner.nextInt();
		System.out.print("Entrez une couleur de carte :");
		String couleur = scanner.next();

		Carte c = new Carte(valeur, Couleur.valueOf(couleur));
		if (maMain.contient(c)) {
			System.out.println("La main contient la carte");
		} else
			System.out.println("La main ne contient pas la carte");
	}
}
