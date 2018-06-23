package ex2_Colectii;
/*
Exercice 2 collections (7 points)
On souhaite modéliser le dossier de patients qui sont les clients d’une pharmacie. 
Chaque patient est représenté par son nom et sa liste de médicaments (chacun de type String) 
de son ordonnance, sans doublons. Les opérations sur le dossier des patients devront garantir 
que les noms de patients sont différents, et qu’un médicament ne figure qu’une fois dans une 
ordonnance. Une partie du code des classes Patient et DossierPharmacie vous est fournie: 
à vous de compléter le corps des méthodes signalées et de répondre aux questions posées.

Question 2.1 classe Patient, 1 point
Complétez le code pour la classe Patient donné plus bas.
 */

import java.util.HashSet;
import java.util.Set;

public class Patient {
	private String nom;
	private Set<String> ordonnance;

	public Patient(String n) {
		this.nom = n;
		this.ordonnance = new HashSet<String>();
	}

	public String getNom() {
		return this.nom;
	}

	public boolean ordonnanceVide() {
		return this.ordonnance.isEmpty();
	}

	public void affiche() {
		System.out.println((getNom()));
		afficheOrdonnance();
	}

	/** Ajoute un medicament de nom m dans ordonnance */
	public void ajoutMedicament(String m) {
		this.ordonnance.add(m);
	}

	// A completer −> code methodes suivantes

	/** Affiche l’ordonnance du patient */
	public void afficheOrdonnance() {
		// A completer
		for (String o : this.ordonnance) {
			System.out.println(o);
		}
	}

	/** Teste si ordonnance contient un medicament m */
	public boolean contientMedicament(String m) {
		// A completer
		return this.ordonnance.contains(m);
	}
}
