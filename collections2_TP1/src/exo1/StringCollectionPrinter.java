package exo1;

/*
Exercice 1: for each et itérateurs 

Question 1
On veut écrire une méthode statique afficheColl(Collection<String> c) permettant 
d’afficher n’importe quelle collection contenant des String, par exemple, 
un ArrayList de String, un HashSet de String, etc. Ecrivez deux versions de cette 
méthode: la premiere utilise une boucle for-each; la deuxieme utilise un itérateur. 
Dans le main, testez votre méthode sur un ArrayListe et sur un HashSet que vous 
aurez de ́fini et initialise ́ avec quelques e ́le ́ments au pre ́alable. N’oubliez pas 
d’importer java.util.* :
 // Dans le main
ArrayList<String> ac = new ArrayList<String>(); 
HashSet<String> sc = new HashSet<String>();
// Ajout elements ...
afficheColl(ac);
 afficheColl(sc);
 
 Question 2
Voici une implantation de la méthode afficheListeSt(ArrayList<String> c)
demandee dans le Tp précedent (exercice 1). Elle permet d’afficher le contenu 
d’un ArrayList de String. Est-il possible de reprendre le corps de cette méthode 
tel quel pour implanter la méthode afficheColl(Collection<String> c) de la 
question 1? Expliquez votre reponse.

 // Cette methode est correcte (testez-la!!)
static void afficheListeSt(ArrayList<String> c){ 
	for (int i=0; i< c.size(); i++){
        System.out.println(c.get(i));
    }
}
 // Cette implantation est-elle correcte?
static void afficheCollNo(Collection<String> c){ 
	for (int i=0; i< c.size(); i++){
         System.out.println(c.get(i));
     }
}
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StringCollectionPrinter {

	public static String toStringForEach(Collection<String> collection) {
		String result = "";
		String sep = "";
		for (String s : collection) {
			result = result + sep + s;
			sep = ";";
		}
		return result;
	}

	public static void afficheCollForEach(Collection<String> collection) {
		String s = toStringForEach(collection);
		System.out.println(s);

	}

	public static String toStringIterator(Collection<String> collection) {
		String result = "";
		String sep = "";

		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			String s = it.next();
			result = result + sep + s;
			sep = ";";
		}
		return result;
	}

	public static void afficheCollIterator(Collection<String> collection) {
		String s = toStringIterator(collection);
		System.out.println(s);
	}
	
	 // Cette methode est correcte (testez-la!!)
	static void afficheListeSt(ArrayList<String> c){ 
		for (int i=0; i< c.size(); i++){
	        System.out.println(c.get(i));
	    }
	}
	 // Cette implantation est-elle correcte? 
	// => Non, pas de get(i) sur une collection.
//	static void afficheCollNo(Collection<String> c){ 
//		for (int i=0; i< c.size(); i++){
//	         System.out.println(c.get(i));
//	     }
//	}

	public static void main(String[] args) {
		//Q1
		// dans la partie gauche on peut se limiter à l'interface qui offre un minimum
		// suffisant
		// au lieu de ArrayList -> List
		// au lieu de HashSet -> Set
		// ArrayList<String> ac = new ArrayList<String>();
		// HashSet<String> sc = new HashSet<String>();
		List<String> ac = new ArrayList<String>();
		Set<String> sc = new HashSet<String>();
		// Ajout elements ...
		ac.add("A");
		ac.add("B");
		sc.add("D");
		sc.add("C");

		afficheCollIterator(ac);
		afficheCollIterator(sc);

		afficheCollForEach(ac);
		afficheCollForEach(sc);
		
		//Q2
		ArrayList<String> al = new ArrayList<String>();
		al.add("coco");
		al.add("chanel");
		afficheListeSt(al);
	}

}
