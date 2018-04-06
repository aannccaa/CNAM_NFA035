package collections2.exercice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Question1 {
	public static void afficheCollForEach(Collection<String> collection) {
		System.out.println("Affichage foreach");
		for (String s: collection) {
			System.out.println(s);
		}
		System.out.println();
	}

	public static void afficheCollIterator(Collection<String> collection) {
		System.out.println("Affichage iterator");
		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			String s= iterator.next();
			System.out.println(s);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// Remarquez que l'ordre d'ajout des éléments dans le hashSet et
		// leur ordre d'affichage n'ont rien à voir !
		HashSet<String> set= new HashSet<>();
		set.add("un");
		set.add("deux");
		set.add("trois");
		ArrayList<String> list= new ArrayList<>();
		list.add("quatre");
		list.add("cinq");
		list.add("six");
		afficheCollForEach(set);
		afficheCollIterator(set);
		afficheCollForEach(list);
		afficheCollIterator(list);
	}
}
