package exo3;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;

/*
Question 1
Écrire un programme qui extraira les entiers (suite de chiffres) d’un texte et en calculera 
la somme.
Vous ecrirez une fonction qui travaillera sur un flux, afin de pouvoir la tester. Dans cette 
version de l’exercice, on considerera que, par exemple 3 a22,34 contient les entiers3, 22 et 34.

Question 2
Si vous avez le temps, vous pouvez vous essayer à une version plus complexe du sujet: 
on considere maintenant que les entiers sont des suites de chiffres, non precédées 
d’une lettre (dans notre exemple, 22 ne serait plus utilisé, car precédé de “a”).
 */

public class ex3 {

	public static int getNextInteger(PushbackReader r) throws IOException, AucunChiffre {
		int result = 0;
		int signe = 1;
		boolean unChiffreAEteLu = false;
		while (true) {
			int c = r.read();
			if (c == -1) {
				break;
			}
			char ch = (char) c;

			if (Character.isDigit(ch)) {
				result = result * 10 + Character.digit(ch, 10);
				unChiffreAEteLu = true;
			} else if (ch == '-') {
				// si on a lu déja un chiffre quand on lit le '-', on revient avant le '-'
				if (unChiffreAEteLu) {
					r.unread(c);
					break;
				} else {
					// si on a n'a pas encore trouvé de chiffre, on lit un char
					int next = r.read();
					char nextChar = (char) next;
					if (Character.isDigit(nextChar)) {
						r.unread(next);
						signe = -1;
					} else if (nextChar == '-') {
						r.unread(next);
					}
				}
			} else {
				if (unChiffreAEteLu) {
					// on a déja trouvé un numéro. Car il n'est pas suivi d'un autre chiffre
					// on arrête la lecture pour le retourner
					break;
				} else {
					// pas de chiffre trouvé, on avance pour essayer d'en trouver
					continue;
				}
			}
		}

		if (unChiffreAEteLu)

		{
			return result * signe;
		} else {
			throw new AucunChiffre();
		}
	}

	public static int calculerSomme(Reader r) throws IOException {
		PushbackReader pushbackReader = new PushbackReader(r, 1);
		int result = 0;
		while (true) {
			try {
				result = result + getNextInteger(pushbackReader);
			} catch (AucunChiffre e) {// quand il ne reste plus de chiffre à lire dans le reader
				return result;
			}
		}
	}

	public static void main(String[] args) {

	}

}
