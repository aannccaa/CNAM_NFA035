package ex1_InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
Exercice 1 Entrées/sorties 7 points

Indication : pour cet exercice, nous ne pensons pas qu’il soit utile d’utiliser 
StreamTokenizer.
On veut écrire des méthodes pour afficher la table des matières d’un fichier texte 
au format décrit ci-après.
On suppose que le fichier lu est au format suivant :
– Les titres de niveau3 (sous-sous-titres) sont sur une ligne séparée dont les trois 
premiers caractères sont ’***’;
– Les titres de niveau 2 (sous-titres) sont sur une ligne séparée dont les deux premiers 
caractères sont ’**’
(attention, une ligne qui commence par "***” commence aussi par deux "*", mais c’est un 
titre de niveau 3 et pas de niveau 2).
– Les titres de niveau 1 sont sur une ligne séparée dont le premier caractère est ’*’ 
(évidemment les titres de niveau 3 et 2 sont exclus) ;
– Les autres lignes sont du texte normal.
Par exemple le fichier ci-dessous à gauche a pour table des matière le texte 

=> Contenu fichier:

* Programmation
La programmation c’est bien. Ça ouvre l’esprit.
** Langages de programmation Les langages ...
*** Langage C
Le langage C c’est bien car ça forme la jeunesse.
*** Langage Java
Le langage Java ...
** Compilation
La compilation c’est mal connu.
* Système
Le système c’est bien aussi. 
** Unix
Unix c’est bien
** Windows
Windows c’est moins bien
** Mac
Mac c’est pas mal

ci-dessous à droite.

=> Table de matières:

* Programmation
** Langages de programmation 
**** Langage C
*** Langage Java
** Compilation
* Système
** Unix
** Windows
** Mac

Question 1.1 2 points
Écrivez la méthode void tableDesMatieres(File f) qui affiche les lignes qui commencent 
par "*” (y compris leur préfixes ’*’, ’**’ et ’***’) du fichier f.
Remarque : Il n’est pas permis d’utiliser la méthode titres ci-dessous. 

Question 1.2 4 points
Écrivez la méthode void titres(File f,int n) qui affiche les lignes du fichier f qui sont 
des titres de niveau n.

Question 1.3 1 points
Question de cours : en utilisant la méthode titres(File f,int n) de l’exercice 1 
(même si vous ne l’avez pas définie), écrivez la méthode void titres(String s,int n) 
qui affiche les lignes du fichier dont le nom est s qui sont des titres de niveau n.
 */
public class Ex1 {

	public static void tableDesMatieres(File f) throws IOException {
		Reader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		List<String> list = new ArrayList<>();
		System.out.println("============> Chapitres *, ou **, ou ***: ");
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			String extrait = line.length() > 0 ? line.substring(0, 1) : "";
			if (extrait.equals("*")) {
				list.add(line);
				System.out.println(line);
			}
		}

		r.close();
		br.close();
	}

	public static String getEtoiles(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result = result + "*";
		}
		return result;
	}

	public static int getNiveauTitre(String line) {
		int result = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '*') {
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	public static void titres(File f, int n) throws IOException {
		Reader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		List<String> list = new ArrayList<>();
		String etoiles = getEtoiles(n);
		String etoiles1 = etoiles + "*";

		System.out.println("============> Chapitres: " + etoiles);
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			// variante 1
			if (getNiveauTitre(line) == n) {
				list.add(line);
				System.out.println(line);
			}

			// variante 2
			if (line.startsWith(etoiles) && !line.startsWith(etoiles1)) {
				//list.add(line);
				//System.out.println(line);
			}
		}

		r.close();
		br.close();
	}

	public static void tableDesMatieres(String s) throws IOException {
		File f = new File(s);
		tableDesMatieres(f);
	}

	public static void main(String[] args) throws IOException {
		File f = new File("ex1_input.txt");
		// Q1.1
		tableDesMatieres(f);

		// Q1.2
		titres(f, 1);

		// Q1.3
		// tableDesMatieres("ex1_input.txt");
	}

}
