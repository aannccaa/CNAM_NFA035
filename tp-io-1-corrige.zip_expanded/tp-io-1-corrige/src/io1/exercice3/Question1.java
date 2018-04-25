package io1.exercice3;

import java.io.IOException;
import java.io.Reader;

public class Question1 {
	/**
	 * Calcule la somme des entiers qui sont listés dans r.
	 * 
	 * @param r
	 * @return
	 * @throws IOException
	 */
	public static int sommeEntiers(Reader r) throws IOException {
		int resultat = 0;
		try {
			boolean dansEntier = false;
			int entierCourant = 0;
			int c;
			do {
				c = r.read();
				// Cette version gère normalement des
				// chiffres qui ne sont pas seulement les
				// chiffres arabes de l'écriture latine.
				// else rien...
				// Version "ascii":
				// if ('0' < c && c < '9') {
				//    int val= c - '0';
				// }
				if (Character.isDigit(c)) {
					int val = Character.getNumericValue(c);
					if (dansEntier) {
						// on voit un nouveau chiffre. Donc, si on 
						// a c= '7' et qu'on avait lu 23, on a en fait
						// 237, soit 23 * 10 (pour décaler) plus 7.
						entierCourant= 10 * entierCourant + val;
					} else {
						// On voit le début d'un nouveau nombre.
						entierCourant = val;
						dansEntier = true;
					}
				} else {
					if (dansEntier) {
						// Fin d'un entier... l'ajouter à la somme.
						dansEntier = false;
						resultat+= entierCourant;
						// entierCourant= 0; // Pas nécessaire en fait.
					}
				}
			} while (c != -1);
			// Grâce au do... while, quand on arrive à la fin, on 
			// traite correctement le cas où le dernier caractère du fichier 
			// est un chiffre.
		} finally {
			r.close();
		}
		return resultat;
	}
}
