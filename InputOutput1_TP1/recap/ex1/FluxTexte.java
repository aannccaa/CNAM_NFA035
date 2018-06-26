package ex1;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/*
Exercice 1 
Question 1
E ́crireuneme ́thodestatiquequiaffichelecontenud’unfluxtexte,passe ́enparame`tre.
Question 2
E ́crire un main et tester sur un fichier que vous aurez cre ́e ́ a` la main 
(de pre ́fe ́rence dans le meˆme dossier que votre projet).

 */

public class FluxTexte {

	public static void afficheContenuFluxTexte(Reader r) throws IOException {
		String s = "";
		while (true) {
			int c = r.read();
			if (c == -1) {
				break;
			}
			char ch = (char) c;
			s = s + ch;
		}
		System.out.println(s);
	}

	public static void main(String[] args) throws IOException {
		String s = "1\n2\n3\n4";
		Reader sr = new StringReader(s);
		afficheContenuFluxTexte(sr);
		sr.close();
		
		Reader fr = new FileReader("ex1.txt");
		afficheContenuFluxTexte(fr);
		fr.close();
	}
}
