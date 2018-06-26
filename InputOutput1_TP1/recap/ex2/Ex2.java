package ex2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/*
Exercice 2
On veut ecrire une méthode statique qui prend comme argument un flux texte en lecture et un flux texte en ecriture, 
et qui copie une ligne sur deux du premier dans le second.

Question 1
Definissez l’en-tete de votre méthode.

Question 2
En utilisant JUnit et eventuellement StringReader et StringWriter, écrivez un jeu de test. Testez au moins :
- le cas ou` l’entrée est vide ;
- le cas ou` elle fait une seule ligne ;
- le cas ou` elle fait exactement deux lignes ;
- deux cas ou` elle fait plus de deux lignes, un cas pair et un cas impair. 
	Note: ’\n’ termine une ligne, ce qui signifie par exemple que
	- un flux qui contient exactement ab\n fait une ligne ;
	- un flux qui contient exactement ab\nc fait deux lignes ;
	- un flux qui contient exactement ab\nc\n fait deux lignes ;
	- un flux qui contient exactement ab fait une ligne ;
Vous pouvez intégrer cette problematique dans vos tests.

Question 3
Ecrivez un main qui appellera votre fonction avec des “vrais” fichiers.
 */

public class Ex2 {

	public static void copierUneLigneSurDeux(Reader r, Writer w) throws IOException {
		BufferedReader br = new BufferedReader(r);
		int numeroLigne = 0;
		String line = "";
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			if (estPair(numeroLigne)) {
				w.write(line);
				w.write("\n");
			}
			numeroLigne++;
		}
		br.close();
	}

	public static boolean estPair(int n) {
		return n % 2 == 0;
	}

	public static void main(String[] args) throws IOException {
		String s = "0\n1\n2\n3\n4\n5";
		Reader r = new StringReader(s);
		Writer w = new FileWriter("recapEx2_output.txt");
		copierUneLigneSurDeux(r, w);
		System.out.println(w.toString());
		r.close();
		w.close();
	}

}
