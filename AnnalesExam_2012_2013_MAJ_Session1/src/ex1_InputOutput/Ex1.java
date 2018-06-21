package ex1_InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
Exercice 1 Entrées/Sorties, 6 points
On veut écrire des méthodes pour afficher les colonnes de caractères d’un fichier.

Question 1.1 2,5 points
Écrivez la méthode void couperFin(File f,int c2) qui affiche les c2 premièrs caractères 
de chaque ligne du fichier f. En cas de lignes trop courtes, les caractères manquants 
sont simplement ignorés.
La première colonnes est la colonne 0.
Remarque : Il n’est pas permis d’utiliser la méthode couper ci-dessous.

Question 1.2 2,5 points
Écrivez la méthode void couper(File f,int c1,int c2) qui affiche les caractères 
de la colonne c1 à la colonne c2-1 de chaque ligne. En cas de lignes trop courtes, 
les caractères manquants sont simplement ignorés.

bonjour ,␣comment 
vas␣tu␣vous 
Bien,␣et␣vous␣? 
bien

L’appel de méthode couper(fic,2,5) affichera le résultat :

njo 
s␣t 
en, 
en


Question 1.3 1 points
Question de cours: en utilisant la méthode couper(File f,int c1,int c2) de l’exercice1, 
même si vous ne l’avez pas définie, écrivez la méthode void couper(String s,int c1,int c2) 
qui affiche les caractères c1 à c2-1 de chaque ligne du fichier dont le nom est s.



 */
public class Ex1 {
	public static void couperFin(File f, int c2) throws IOException {
		Reader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		String extrait = "";

		while (true) {
			String textLine = br.readLine();
			if (textLine == null) {
				break;
			}
			if (textLine.length() < c2) {
				extrait = extrait + textLine.substring(0, textLine.length()) + "\n";
			} else {
				extrait = extrait + textLine.substring(0, c2) + "\n";
			}
		}
		System.out.println(extrait);
		r.close();
		br.close();
	}

	public static void couperFin(File f, int c1, int c2) throws IOException {
		Reader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		String extrait = "";

		while (true) {
			String textLine = br.readLine();
			if (textLine == null) {
				break;
			}
			if (textLine.length() < c2) {
				extrait = extrait + textLine.substring(c1, textLine.length()) + "\n";
			} else {
				extrait = extrait + textLine.substring(c1, c2) + "\n";
			}
		}
		System.out.println(extrait);
		r.close();
		br.close();
	}
	
	public static void couperFin(String fileName, int c1, int c2) throws IOException {
		File f = new File(fileName);
		couperFin(f, c1, c2);
	}

	public static void main(String[] args) throws IOException {
		// Ex1.1
		File f = new File("ex1_input.txt");
		couperFin(f, 3);

		// Ex1.2
		couperFin(f, 2, 5);
		
		// Ex1.3
		String fileName = "ex1_input.txt";
		couperFin(fileName, 2, 5);
	}

}
