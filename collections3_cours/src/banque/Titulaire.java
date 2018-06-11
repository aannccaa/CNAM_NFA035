package banque;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Titulaire {
	@Override
	public String toString() {
		return String.format("[nom=%s\ncomptesParBanque=%s]", nom, comptesParBanque);
	}

	String nom;
	Map<String, Set<Integer>> comptesParBanque;// <nomBanque, set numComptes>

	public Titulaire(String nom) {
		this.nom = nom;
		this.comptesParBanque = new HashMap<String, Set<Integer>>();
	}

	public Set<Integer> getComptes(String nomBanque){
		// map<key, val> => get(key) => returneaza val (setul de conturi)
		Set<Integer> comptesDansLaBanque = this.comptesParBanque.get(nomBanque);
		// daca nu exista deja setul de conturi pentru banca "nomBanque"
		if (comptesDansLaBanque == null) {
			// creez HashSet vide
			comptesDansLaBanque = new HashSet<Integer>();
			// si adaug HashSetul de numere de conturi (vid) in map 
			this.comptesParBanque.put(nomBanque, comptesDansLaBanque);
		}
		return comptesDansLaBanque;
	}
	
	public void ajouterCompte(String nomBanque, int numCompte) {
		Set<Integer> comptesDansLaBanque = this.getComptes(nomBanque);
		comptesDansLaBanque.add(numCompte);
	}
}
