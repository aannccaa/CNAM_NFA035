package exo3;

import java.io.*;

public class Question2 {
	/**
	 * Calcule la somme des entiers qui sont listés dans r.
	 * 
	 * On considère maintenant qu'un entier est une suite
	 * de chiffres non précédée d'une lettre.
	 * 
	 * solution :
 	 * a) on dit que des chiffres précédés de lettre c'est 
	 * un identifiant, et on utilise trois états: rien, dans nombre, et dans identifiant.
	 * 
	 * b) on réfléchit par rapport au caractère précédent (qu'il
	 * faut donc conserver). 
	 * 
	 * si on n'est pas dans un nombre, que c est un chiffre, 
	 * et que le caractère précédent n'est NI une lettre, NI un chiffre,
	 * alors on commence un nouveau nombre.
	 * 
	 * Le point compliqué ici est le "NI un chiffre", auquel on ne pense 
	 * pas forcément. En effet, si on n'est pas dans un nombre,
	 * mais que le caractère précédent est déjà un chiffre, ça signifie
	 * qu'il est lui-même précédé d'une lettre.
	 * 
	 * En fait, en conservant le caractère précédent, on gère
	 * un état qui est défini par la valeur de dansEntier et 
	 * par le type du caractère précédent. C'est un état implicite, 
	 * d'une certaine manière.
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
			int c= ' '; // pour l'initialisation de precedent...
			int precedent; // le caractère qui précède c.
			do {
				precedent= c;
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
						// On voit peut être le début d'un nouveau nombre,
						// mais seulement si precendent n'est ni une lette
						// ni un chiffre.
						if (! Character.isDigit(precedent) && ! Character.isLetter(precedent)) {
							entierCourant = val;
							dansEntier = true;
						}
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
