package exercice1;

import java.util.*;
public class Question1 {
	public static void main(String[] args) {
		ArrayList<String> l= new ArrayList<String>();
		for (int i= 1; i <= 6; i++) {
			l.add("" + i);
		}
		System.out.println(l); // On peut afficher directement une Liste !
		l.set(4, "remplacement");
		System.out.println(l); // On peut afficher directement une Liste !
		l.add(3, "ajout");
		System.out.println(l); // On peut afficher directement une Liste !
		l.remove(2);
		System.out.println(l); // On peut afficher directement une Liste !
		// On a ajouté un élément en position 3 ("ajout")
		// puis enlevé un élément en position 2,
		// ce qui revient au même que remplacer l'élément en position 2 par "ajout" 
		// (p.s. : le résultat final est le même, mais l'opération 
		// est différente, et éventuellement plus coûteuse, puisqu'elle 
		// change la taille de la liste).
		
		//l.remove(20); // (ou l.add(20, "toto"));
		// lève : java.lang.IndexOutOfBoundsException: Index: 20, Size: 6			
	}

}
