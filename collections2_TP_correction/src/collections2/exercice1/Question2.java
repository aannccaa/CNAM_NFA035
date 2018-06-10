package collections2.exercice1;

import java.util.Collection;

public class Question2 {
	// Cette implémentation est-elle correcte?

	// NON, car la méthode get(int index) n'existe pas dans Collection.
	// Elle est spécifique aux Listes. 
	
	static void afficheCollNo(Collection<String> c) {
		
		for (int i = 0; i < c.size(); i++) {
			// System.out.println(c.get(i));
		}
	}
}
