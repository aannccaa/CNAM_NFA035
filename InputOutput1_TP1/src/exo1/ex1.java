package exo1;
/*
Exercice 1 Question 1
Ecrire une méthode statique qui affiche le contenu d’un flux texte, passé en parametre.

Question 2
Écrire un main et tester sur un fichier que vous aurez cree à la main 
(de préference dans le meme dossier que votre projet).
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ex1 {

	public static void afficheContenu(Reader r) throws IOException {
		String result = "";
		int c = r.read();
		while (c != -1) {
			char ch = (char) c;
			result = result + ch;
			c = r.read();
		}
		System.out.println(result);
		System.out.println("=============");
	}

	public static String afficheContenu(FileReader fr) throws IOException {
		String result = "";
		int c = fr.read();
		while (c != -1) {
			char ch = (char) c;
			result = result + ch;
			c = fr.read();
		}
		return result;
	}

	public static String afficheContenu(StringReader sr) throws IOException {
		String result = "";
		int c = sr.read();
		while (c != -1) {
			char ch = (char) c;
			result = result + ch;
			c = sr.read();
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		// afficher content Reader = FileReader
		Reader r1 = null;
		try {
			r1 = new FileReader("ex1.txt");
			afficheContenu(r1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (r1 != null) {
				try {
					r1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// afficher content Reader = StringReader
		Reader r2 = null;
		try {
			r2 = new StringReader("Ici j'écris\nsur 2 lignes.");
			afficheContenu(r2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (r2 != null) {
				try {
					r2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// afficher content FileReader
		FileReader fr = null;
		try {
			fr = new FileReader("ex1.txt");
			System.out.println(afficheContenu(fr));
			System.out.println("=============");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// afficher content StringReader
		StringReader sr = null;
		try {
			sr = new StringReader("Ici j'écris\nsur 2 lignes.");
			System.out.println(afficheContenu(sr));
			System.out.println("=============");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sr != null) {
				sr.close();
			}
		}
	}
}
