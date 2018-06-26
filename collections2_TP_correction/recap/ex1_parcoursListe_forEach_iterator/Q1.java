package ex1_parcoursListe_forEach_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
Exercice 1: for each et ite ́rateurs 
Question 1
Onveute ́crireuneme ́thodestatiqueafficheColl(Collection<String> c)permettantd’affichern’importe 
quelle collection contenant des String, par exemple, un ArrayList de String, un HashSet de String, 
etc. Ecrivez deux versions de cette me ́thode: la premie`re utilise une boucle for-each; 
la deuxie`me utilise un ite ́rateur. Dans le main, testez votre me ́thode sur un ArrayListe 
et sur un HashSet que vous aurez de ́fini et initialise ́ avec quelques e ́le ́ments au pre ́alable. 
N’oubliez pas d’importer java.util.* :
 // Dans le main
ArrayList<String> ac = new ArrayList<String>(); HashSet<String> sc = new HashSet<String>();
// Ajout elements ...
afficheColl(ac);
 afficheColl(sc);
 */

public class Q1 {

	public static void afficheColl_forEach(ArrayList<String> al) {
		System.out.println("afficheColl_forEach(ArrayList<String> al): ");
		for (String s : al) {
			System.out.println(s);
		}
	}

	public static void afficheColl_iterator(ArrayList<String> al) {
		System.out.println("afficheColl_iterator(ArrayList<String> al): ");
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void afficheColl_forEach(HashSet<String> hs) {
		System.out.println("afficheColl_forEach(HashSet<String> hs): ");
		for (String s : hs) {
			System.out.println(s);
		}
	}

	public static void afficheColl_iterator(HashSet<String> hs) {
		System.out.println("afficheColl_iterator(HashSet<String> hs: ");
		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		HashSet<String> hs = new HashSet<String>();
		// Ajout elements ...
		al.add("toto");
		al.add("marie");
		al.add("mimi");
		al.add("toto");
		afficheColl_forEach(al);
		afficheColl_iterator(al);

		hs.add("toto");
		hs.add("marie");
		hs.add("mimi");
		hs.add("toto");
		afficheColl_forEach(hs);
		afficheColl_iterator(hs);
	}
}
