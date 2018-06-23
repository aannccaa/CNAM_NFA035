package ex2_Colectii;
/*
Question 2.2 classe DossierPharmacie, 3 points

L’ensemble de patients clients de la pharmacie est représenté par une table d’associations 
entre noms de patients (String) et objets Patient. Les noms des patients doivent être tous 
différents, sans distinction entre minuscules et majuscules. Afin d’éviter l’ajout multiple 
d’un nom identique aux majuscules/minuscules près, l’ajout d’une nouveau nom dans la table 
se fait après avoir convertit celui-ci en minuscules (méthode nouveauPatient). Complétez le 
code des méthodes signalées plus bas.

Question 2.3 (Patients ayant pris un médicament), 1,5 points

Ajoutez dans la classe DossierPharmacie une méthode qui prend en paramètre le nom d’un 
médicament et retourne une collection contentant tous les patients de la pharmacie ayant 
pris ce médicament.
/∗∗ Retourne collection de patients qui prennent le medicament m ∗/ 
 * public Collection <String > affichePatientAvecMedicament(String m){
// Compléter
}

Question 2.4 Suppresion de patients, 1,5 points
Ajoutez dans la classe DossierPharmacie une méthode permettant de supprimer du dossier des 
patients tous les patients dont l’ordonnance est vide (aucun médicamant).
/** Enleve du dossier tous les les patients dont
* l’ordonnance est vide (ne contient aucun medicament) ∗/
public void enlevePatientOrdonnanceVide() {
// Compléter

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DossierPharmacie {
	private String nom;
	private HashMap<String, Patient> patients;

	public DossierPharmacie(String n) {
		this.nom = n;
		this.patients = new HashMap<String, Patient>();
	}

	/** Ajoute un nouveau patient de nom et ordonnance donnés */
	public void nouveauPatient(String nom, String[] ord) {
		Patient p = new Patient(nom);
		for (String n : ord) {
			p.ajoutMedicament(n);
		}
		String key = nom.toLowerCase();
		this.patients.put(key, p);
	}

	// Compléter les methodes suivantes
	/**
	 * Ajoute un nouveau medicament sur un patient deja existant. Renvoie false si
	 * le patient n’existe pas et true si l’ajout a pu etre effectue
	 */
	public boolean ajoutMedicament(String nom, String m) {
		// Completer
		Patient p = this.patients.get(nom.toLowerCase());
		if (p == null) {
			System.out.println("Le patient de nom: " + this.nom + " n'existe pas.");
			return false;
		} else {
			p.ajoutMedicament(m);
			return true;
		}
	}

	/** Affiche nom + ordonnance du patient du nom donné */
	public void affichePatient(String nom) {
		// Completer
		Patient p = this.patients.get(nom.toLowerCase());
		if (p == null) {
			System.out.println("Le patient de nom: " + this.nom + " n'existe pas.");
		} else {
			p.affiche();
		}
	}

	/** Affiche nom pharmacie + tous les patients du dossier */
	public void affiche() {
		// Completer
		for (Patient p : patients.values()) {
			p.affiche();
		}
	}

	/** Retourne collection de patients qui prennent le medicament m */
	public Collection<String> affichePatientAvecMedicament(String m) {
		// Compléter
		Collection<String> result = new HashSet<>();
		for (Patient p : patients.values()) {
			if (p.contientMedicament(m)) {
				result.add(p.getNom().toLowerCase());
			}
		}
		return result;
	}

	/**
	 * Enleve du dossier tous les les patients dont l’ordonnance est vide (ne
	 * contient aucun medicament)
	 */
	public void enlevePatientOrdonnanceVide() {
		// Compléter
		Set<Map.Entry<String, Patient>> entries = patients.entrySet();
		Iterator<Map.Entry<String, Patient>> it = entries.iterator();
		while (it.hasNext()) {
			Patient p = it.next().getValue();
			if (p.ordonnanceVide()) {
				it.remove();
			}
		}
	}
}
