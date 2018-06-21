package ex2_Colectii;

import java.util.Comparator;

// trie les Contacts en ordre alphabétique de leur nom
public class OrdreAlphabetique implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		String nom1 = c1.getNom().toLowerCase();
		String nom2 = c2.getNom().toLowerCase();
		return nom1.compareTo(nom2);
	}
}
