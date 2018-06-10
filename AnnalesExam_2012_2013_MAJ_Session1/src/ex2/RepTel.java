package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Question 2.2 classe RepTel, 3 points
L’ensemble de contacts d’un répertoire est représenté par une table d’associations entre 
noms de contacts (String) et objets Contact. Les noms de contacts doivent être tous différents, 
sans faire de distinction entre minuscules et majuscules. Afin d’éviter l’ajout multiple d’un 
nom identique aux majuscules/minuscules près, l’ajout d’un nouveau nom dans la table se fait après 
avoir convertit celui-ci en minuscules (méthode nouveauContact). Complétez le code des méthodes 
signalées plus bas.

 */

public class RepTel {
	// noms de contacts (String) et objets Contact
	private HashMap<String, Contact> rep;

	public RepTel() {
		rep = new HashMap<String, Contact>();
	}

	/** Ajoute un nouveau contact dans le repertoire */
	public void nouveauContact(String nom, String[] nums) {
		Contact c = new Contact(nom);
		for (String n : nums) {
			c.ajoutNum(n);
		}
		String key = nom.toLowerCase();
		rep.put(key, c);
	}

	// Compléter les methodes suivantes
	/**
	 * Ajoute un nouveu numero sur contact deja existant. Renvoie false si le
	 * contact n’existe pas et true si le numero a pu etre ajoute
	 */
	public boolean ajoutNum(String nom, String num) {
		// A completer
		Contact c = rep.get(nom.toLowerCase());
		if (c == null) {
			return false;
		} else {
			return c.ajoutNum(num);
		}
	}

	/** Affiche toutes les donnes et numeros du contact de nom donné */
	// moins efficace que la variante suivante, on cherche la key 2 fois
	public void afficheContactDeNom(String nom) {
		// A completer
		String key = nom.toLowerCase();
		boolean trouve = rep.containsKey(key);
		if (trouve) {
			Contact c = rep.get(key);
			c.affiche();
		} else {
			System.out.println("Contact pas trouvé pour le nom " + nom);
		}
	}

	/** Affiche toutes les donnes et numeros du contact de nom donné */
	public void afficheContactDeNom_variante(String nom) {
		// A completer
		String key = nom.toLowerCase();
		Contact c = rep.get(key);
		if (c == null) {
			System.out.println("Contact pas trouvé pour le nom " + nom);
		} else {
			c.affiche();
		}
	}

	/** Affiche le nom du repertoire et tous les contacts qu’il contient */
	public void affiche() {
		// A compléter
		for (Contact c : rep.values()) {
			c.affiche();
		}
	}

	/** Affiche le premier contact trouvé qui possede un numero donné */
	public void afficheContactDeNum(String num) {
		// A compléter
		for (Contact c : rep.values()) {
			if (c.contientNumero(num)) {
				c.affiche();
				return;
			}
		}
	}

	/** Affiche le premier contact trouvé qui possede un numero donné */
	public void afficheContactDeNum_variante(String num) {
		// A compléter
		List<Contact> contacts = new ArrayList<>(rep.values());
		for (int i = 0; i < contacts.size(); i++) {
			Contact c = contacts.get(i);
			if (c.contientNumero(num)) {
				c.affiche();
				return;
			}
		}
	}

	// Question 2.3 Comparator et affichage par ordre alphabéthique, 3 points
	/**
	 * On veut ajouter une méthode afficheParOrdreAlphabetique() qui affiche tous
	 * les contacts du répertoire téléphonique dans l’ordre alphabétique de
	 * leurs noms. Pour cela, vous donnerez en premier une classe OrdreAlphaBethique
	 * qui implante l’interface Comparator, afin de trier les Contacts du
	 * répertoire. Donnez ensuite la méthode d’affichage. Dans quelle classe
	 * faut-il l’ajouter (reponse => dans RepTel)?
	 * 
	 * /** Affiche les contacts en ordre alphabétique de leur nom
	 */
	public void afficheParOrdreAlphabetique() {
		List<Contact> contacts = new ArrayList<>(rep.values());
		// on trie les contacts par ordre alphabétique
		OrdreAlphabetique comparatorOrdreAlphabetique = new OrdreAlphabetique();
		Collections.sort(contacts, comparatorOrdreAlphabetique);
		// on affiche un a un les contacts déjà triés
		for (Contact c : contacts) {
			c.affiche();
		}
	}
}
