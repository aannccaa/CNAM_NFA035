package exo1;

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

	public static void main(String[] args) {
		//ArrayList<String> ac = new ArrayList<String>();
		//HashSet<String> sc = new HashSet<String>();
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
	}

}
