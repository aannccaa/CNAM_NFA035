package collections2.exercice2;

/*
Question 3 : hashCode() et equals()
Ajoutez des me ́thodes hashCode() et equals() correctes dans la classe Carte. 
Vous pouvez demander a` Eclipse de les ge ́ne ́rer pour vous. Testez le bon 
fonctionnement de ces deux me ́thodes:
	1. recommencez l’exe ́cution du programme TestCarte0.
	2. toujours dans ce programme, utilisez un HashSet au lieu d’un arraylist 
	et testez a` nouveau (en y ajoutant des doublons).
 */

public class Carte {

	private int valeur;
	private Couleur couleur;

	public Carte(int valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}

	public int getValeur() {
		return this.valeur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	@Override
	public String toString() {
		return "" + this.valeur + " de " + this.couleur;
	}

	@Override
	public int hashCode() {
		String s = String.format("%s%s", this.valeur, this.couleur);
		return s.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Carte)) {
			return false;
		} else {
			Carte c = (Carte) obj;
			return (c.valeur == this.valeur && c.couleur == this.couleur);
		}
	}
}
