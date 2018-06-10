package ex1;

import java.util.HashSet;
import java.util.Set;

public class Logiciel {
	private String nom;
	private int version;

	// INVARIANT: dependances ne contient pas de doublons.
	private Set<Logiciel> dependances = new HashSet<Logiciel>();

	public Logiciel(String n, int v) {
		this.nom = n;
		this.version = v;
	}

	public String getNom() {
		return nom;
	}

	public int getVersion() {
		return version;
	}

	public boolean dependDe(Logiciel p) {
		return dependances.contains(p);
	}

	public boolean ajoutDependance(Logiciel l) {
		boolean added = dependances.add(l);
		return added;
	}

	public Set<Logiciel> getDependances() {
		// retourne une copie de la collection des dependances
		return new HashSet<Logiciel>(dependances);
	}
}
