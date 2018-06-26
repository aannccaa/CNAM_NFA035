package ex2_cartes;
/*
Exercice 2: jeu de cartes (partie 1)

Dans cet exercice nous allons implanter les classes ne ́cessaires a` un jeu de cartes. 
Dans le site du cours, re ́cuperez les sources pour Tp. Vous trouverez 3 classes: Carte, 
TestCarte0 et un type e ́nume ́re ́ (classe Couleur).

Question 1: type e ́nume ́re ́ Couleur
Untypee ́nume ́re ́estforme ́d’unensembledemotsconsidere ́scommedesconstantes.Dans le type enum 
Couleur chacun de ces mots est de type Couleur. Avant de porsuivre: allez voir comment 
utiliser les types e ́nume ́re ́s dans la documentation et tutoriels java (site oracle). 
Testez Couleur avec le programme TestCouleur0. Notez e ́galement comment ce type est utilise ́ 
dans la classe Carte.

 */

public class Carte implements Comparable<Carte> {

	private int valeur;
	private Couleur couleur;

	public Carte(int valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public String toString() {
		return "" + valeur + " de " + couleur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + valeur;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (couleur != other.couleur)
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}

	@Override
	public int compareTo(Carte o) {
		if (this.getValeur() == (o.getValeur())) {
			return this.getCouleur().compareTo(o.getCouleur());
		} else if (this.getValeur() > o.getValeur()) {
			return 1;
		} else {
			return 0;
		}
	}
}
