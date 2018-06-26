package ex3;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Ex3 {
	public static int getSommeEntiers(Reader r) throws IOException {
		int result = 0;
		int entierCourrant = 0;
		boolean dansEntier = false;
		while (true) {
			int c = r.read();
			if (Character.isDigit(c)) {
				int val = Character.getNumericValue(c);
				if (dansEntier) {// sunt intr-un numar si am citit deja o cifra inainte
					entierCourrant = entierCourrant * 10 + val;
				} else {// intru intr-un numar, citesc prima cifra
					entierCourrant = val;
					dansEntier = true;
				}
			} else {
				if (dansEntier) {// eram intr-un intreg din care ies, il adaug la rezultat
					dansEntier = false;
					result = result + entierCourrant;
					entierCourrant = 0;
				}
				if (c == -1) {
					break;
				}
			}
		}
		r.close();
		return result;
	}

	public static boolean contient(Reader r, String s) throws IOException {
		boolean stringPartial = true;
		String tmp = "";
		

		while (true) {
			int c = r.read();
			char ch = (char) c;
			if (c == -1) {
				return false;
			}
			if (!stringPartial) {
				tmp = tmp.substring(1);// suprim primul char din stringul tmp.
			}
			tmp = tmp + ch;
			if (s.equals(tmp)) {
				return true;
			}
			stringPartial = tmp.length() != s.length();
		}
	}

	public static void main(String[] args) throws IOException {
		String s = "3 a22,34";
		Reader r = new StringReader(s);
		int sommeEntiers = getSommeEntiers(r);
		System.out.println(sommeEntiers);
		r.close();
		 r = new StringReader(s);
		System.out.println(contient(r, " a22,34"));
		r.close();
	}
}
