package ex2.Q2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/*
Question 2.2 4 points
Dans un logiciel de blog, on a decidé que les rédacteurs pourraient taper des fichiers 
textes simplifiés au lieu de html. Dans le format qu’on a defini, un lien entre 
une page et un site web est donnée de la maniére suivante :
[ LABEL DU LIEN | URL DU LIEN ]

Comme par exemple :
voir le [cours de NFA035|http://www.cnam.fr/nfa035]
pour plus de dètails

Le label du lien et son URL sont considerés comme du texte quelconque, avec comme 
seule condition que le label ne peut pas contenir le caractere '|' et que l’URL n’a 
pas le droit de contenir le caractere ’]’.
On considere la classe java (que vous n’avez pas à ecrire).
class Lien {
	private String label;
	private String url;
	public Lien(String label, String url)  { . . . }
	public String getLabel() { . . . }
	public String getUrl() { . . . }
}
Ecrivez la méthode
public List<Lien> listerLiens(Reader r) throws IOException {
. . .
}
Qui cree et retourne la liste des liens trouvés dans le flux lu par r.
Vous supposerez que le fichier est correctement ecrit (on ne vous demande 
pas de gérer les erreurs). 
 */

public class Lien {
	private String label;
	private String url;

	public Lien(String label, String url) {
		this.label = label;
		this.url = url;
	}

	public String getLabel() {
		return this.label;
	}

	public String getUrl() {
		return this.url;
	}

	public List<Lien> listerLiens(Reader r) throws IOException {
		List<Lien> result = new ArrayList<>();

		int c = 0;
		char ch = (char) c;
		while (true) {
			this.url = "";
			this.label = "";
			c = r.read();
			ch = (char) c;
			if (c == -1) {
				break;
			}
			while (ch != '|') {
				label = label + ch;
			}
			while (ch != ']') {
				url = url + ch;
			}
			Lien lien = new Lien(label, url);
			result.add(lien);
		}
		return result;
	}

	/*
	 * variante 1) La premiere dècision est de choisir la bonne classe... on a
	 * un fichier structuré, donc le ´StreamTokenizer peut vous tenter... mais
	 * en realité, on n’utilise pas du tout la notion de mot... Les seuls cas
	 * importants sont les caracteres ` [, ] et |. Du coup, on realise que la
	 * lecture caractere par caractere est sans doute la meilleure approche. La
	 * remarque Vous supposerez que le fichier est correctement ecrit (on ne
	 * vous demande pas de gerer les erreurs) simplifie considerablement le code
	 * : elle vous permet de décider que quand on rencontre un '[' , on est sur
	 * de rencontrer un | puis un ].
	 */

	public List<Lien> listerLiens_cor1(Reader r) throws IOException {
		List<Lien> result = new ArrayList<>();
		String label = "";
		String url = "";
		int c = 0;
		// char ch = (char) c;
		while ((c = r.read()) != -1) {
			if (c == '[') {
				label = "";
				url = "";
			}
			while ((c = r.read()) != '|' && c != -1) {
				label = label + (char) c;
			}
			while ((c = r.read()) != ']' && c != -1) {
				url = url + (char) c;
			}
			Lien lien = new Lien(label, url);
			result.add(lien);
		}
		return result;
	}

	/*
	 * variante 2) Une seconde solution, plus tout terrain, est de raisonner en
	 * terme d’etats. C’est un peu plus complexe, et la premiere version rèpond
	 * très bien à l’ènoncè. Nous donnons cette solution à titre pèdagogique
	 * (evidemment, si c’est ce que vous avez ècrit, c’est très bien). .
	 */

	public List<Lien> listerLiens_cor2(Reader r) throws IOException {
		// On a 3 états, qu’on peut identifier par trois valeurs
		// On utilise des constantes pour ameliorer
		// la lisibilité du code .
		final int DANS_TEXTE = 0;
		final int DANS_LABEL = 1;
		final int DANS_URL = 2;

		List<Lien> result = new ArrayList<>();
		int etat = DANS_TEXTE;
		String label = "";
		String url = "";
		int c;
		// char ch = (char) c;
		while ((c = r.read()) != -1) {
			if (etat == DANS_LABEL) {
				if (c == '|') {
					etat = DANS_URL;
				} else {
					label = label + (char) c;
				}
				// attention, ligne suivante, si on supprime le "else"
				// ca buggue : p o u r q u oi ?
			} else if (etat == DANS_URL) {
				if (c == ']') {
					Lien lien = new Lien(label, url);
					result.add(lien);
					label = "";
					url = "";
					etat = DANS_TEXTE;
				} else {
					url = url + (char) c;
				}
			} else {
				if (c == '[') {
					etat = DANS_TEXTE;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Lien lien;
		Reader r;
		String s;
		s = "[cours de NFA035|http://www.cnam.fr/nfa035]";
		r = new StringReader(s);
		lien = new Lien("", "");
		List<Lien> liens1 = lien.listerLiens_cor1(r);
		for (Lien l : liens1) {
			System.out.println(" [ " + l.getLabel() + " | " + l.getUrl() + " ] ");
		}
		r.close();

		s = "[cours de NFA032|http://www.cnam.fr/nfa032]";
		r = new StringReader(s);
		Lien lien2 = new Lien("", "");
		List<Lien> liens2 = lien2.listerLiens_cor2(r);
		for (Lien l : liens2) {
			System.out.println(" [ " + l.getLabel() + " | " + l.getUrl() + " ] ");
		}
		r.close();
	}

}
