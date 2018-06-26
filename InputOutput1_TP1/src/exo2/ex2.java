package exo2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
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

public class ex2 {
	public static void copierUneSurDeuxLignes(Reader r, Writer w) throws IOException {
		boolean aCopier = true;
		boolean premiereLigne = true;
		while (true) {
			String line = readLine(r);
			if (line == null) {
				// le reader est arrivé à la fin
				break;
			}
			if (aCopier) {
				if(! premiereLigne) {
					w.write('\n');
				}
				w.write(line);
			}
			aCopier = !aCopier;
			premiereLigne = false;
		}
	}

	private static String readLine(Reader r) throws IOException {
		boolean rienLu = true;
		StringBuffer sb = new StringBuffer();
		while (true) {
			int c = r.read();
			char ch = (char) c;
			if (c == -1) {
				if (rienLu) {
					return null;
				}
			} else {
				rienLu = false;
			}
			if (ch == '\n' || c == -1) {
				return sb.toString();
			}
			sb.append(ch);
		}
	}

	public static void main(String[] args) {

		Reader r = null;
		Writer w = null;
		try {
			r = new FileReader("ex2.txt");
			w = new FileWriter("ex2_lignesImpaires");
			copierUneSurDeuxLignes(r, w);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
