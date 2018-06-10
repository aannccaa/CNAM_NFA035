package exercice1;

import java.util.*;

public class Question2 {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		for (int i = 1; i <= 6; i++) {
			l.add("" + i);
		}
		System.out.println(l); // On peut afficher directement une Liste !
		l.set(4, "remplacement");
		System.out.println(l); // On peut afficher directement une Liste !
		l.add(3, "ajout");
		System.out.println(l); // On peut afficher directement une Liste !
		l.remove(2);
		System.out.println(l); // On peut afficher directement une Liste !
		boolean b = l.contains("4");
		System.out.println("Contient 4 : " + b);

		// fonctionnement de indexOf :
		int index = l.indexOf("4");
		System.out.println("index: " + index);
		if (index == -1)
			System.out.println("ne contient pas 4");
		else
			System.out.println("contient 4 en position " + index);

		// Démonstration du fonctionnement de indexOf et lastIndexOf:
		l.add("1");
		System.out.println("indice du premier '1' trouvé: " + l.indexOf("1"));
		System.out.println("dernier indice de '1': " + l.lastIndexOf("1"));
	}

}
