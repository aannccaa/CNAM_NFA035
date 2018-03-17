package nfa035.utils;
/*
Creez dans le package ´ utils une classe TableauUtils qui contiendra des methodes pour travailler
sur les tableaux. Ecrire les methodes suivantes :
public static int[] saisirTableauInt()
qui demande la taille d’un tableau, permet d’en saisir le contenu, et le retourne.
public static void afficheTableauInt(int [] tab)
qui affiche un tableau d’entiers.
Ecrire dans le package ´ nfa035.application un petit programme qui utilise ces deux methodes ´
pour saisir un tableaux d’int et l’afficher.
Supprimer le mot public devant le nom des methodes dans ´ TableauUtils. Que se passe-t-il ?
 */

public class TableauUtils {

	public static int[] saisirTableauInt() {
		System.out.println("Taille tableau ? ");
		int tailleTab = Terminal.lireInt();
		int[] tab = new int[tailleTab];
		for(int i=0; i< tab.length; i++) {
			String s = String.format("donner une valeur entière pour l'élément %d : ", i);
			System.out.println(s);
			tab[i] = Terminal.lireInt();
		}
		return tab;
	}
	
	public static void afficheTableauInt(int[] tab) {
		String sep = "";
		System.out.print("{");
		for(int i=0; i< tab.length; i++) {
			System.out.print(sep + tab[i]);
			sep = "; ";
		}
		System.out.println("}");
	}
}
