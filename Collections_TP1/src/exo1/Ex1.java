package exo1;
import java.util.ArrayList;

/*
TP n◦1 sur les Collections
Exercice 1: travail avec ArrayList

L’objectif de cet exercice est de tester les principales operations de la classe ArrayList. 
Pour cela, commencez par aller sur la page qui de ́crit la javadoc des ArrayList (site oracle). 
avec une methode main.

Question 1
Dans une nouvelle classe, definissez une methode statique 
afficheListeSt( ArrayList<String> l) permettant d’afficher un arrayList de String. 
Dans le main, creez une ArrayList de String (n’oubliez pas d’importer java.util.* ):
ArrayList<String> ls = new ArrayList<String>(); 
Vous allez effectuer les operations suivantes sur cette liste.
1. Ajoutez succésivement les chaines ”1”, ”2”, ”3”, ”4” , ”5” et ”6” dans la liste. 
Affichez la liste avec la methode afficheListeSt.
2. Remplacez l’élément de position 4 par la chaine ”remplacement”.
3. Ajoutez dans la position 3 la chaine ”ajout”.
4. Enlevez l’element de position 2.
5. Affichez la liste apres tous ces changements. Que constatez vous?
6. Que se passe-t-il si vous essayez d’enlever l’element de position 20, ou d’ajouter 
un element a` la position 30?

Question 2
Ajoutez dans votre programme main le code suivant:
// Question 2
boolean b = ls.contains("4");
		System.out.println("Contient 4 ? " + b);
		int index = ls.indexOf("4");
		if (index == -1)
			System.out.println("Ne contient pas 4");
		else
			System.out.println("Contient 4 a la position :" + index);
		
		ls.add("1");
		afficheListeSt(ls);
		int lastIndex = ls.lastIndexOf("1");
		if (lastIndex == -1)
			System.out.println("Ne contient pas 1");
		else
			System.out.println("Derniere occurrence de 1:" + lastIndex);
        
Expliquez le comportement de ce code.
 */

public class Ex1 {

	// Q1
	public static void afficheListeSt(ArrayList<String> l) {
		System.out.print("{");
		String sep = "";
		for (int i = 0; i < l.size(); i++) {
			String current = l.get(i);
			System.out.print(sep + current.toString());
			sep = "; ";
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		ArrayList<String> ls = new ArrayList<String>();
		String[] liste = { "1", "2", "3", "4", "5", "6" };
		for (int i = 0; i < liste.length; i++) {
			ls.add(liste[i]);
		}

		afficheListeSt(ls);
		ls.set(4, "remplacement");
		afficheListeSt(ls);

		ls.add(3, "ajout");
		afficheListeSt(ls);

		ls.remove(2);
		afficheListeSt(ls);

		// ls.remove(20);
		// ls.add(30, "element");

		// Question 2
		boolean b = ls.contains("4");
		System.out.println("Contient 4 ? " + b);
		int index = ls.indexOf("4");
		if (index == -1)
			System.out.println("Ne contient pas 4");
		else
			System.out.println("Contient 4 a la position :" + index);
		
		ls.add("1");
		afficheListeSt(ls);
		int lastIndex = ls.lastIndexOf("1");
		if (lastIndex == -1)
			System.out.println("Ne contient pas 1");
		else
			System.out.println("Derniere occurrence de 1:" + lastIndex);
	}
}
