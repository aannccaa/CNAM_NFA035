package exo2;

/*
Question 3 : hashCode() et equals()
Ajoutez des méthodes hashCode() et equals() correctes dans la classe Carte. 
Vous pouvez demander à Eclipse de les genérer pour vous. Testez le bon 
fonctionnement de ces deux méthodes:
	1. recommencez l’execution du programme TestCarte0.
	2. toujours dans ce programme, utilisez un HashSet au lieu d’un arraylist 
	et testez à nouveau (en y ajoutant des doublons).
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

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Carte)) {
			return false;
		}
		Carte other = (Carte) obj;
		if (this.couleur != other.couleur) {
			return false;
		}
		if (this.valeur != other.valeur) {
			return false;
		}
		return true;
	}

//	@Override
//	public int hashCode() {
//		String s = String.format("%s%s", this.valeur, this.couleur);
//		return s.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof Carte)) {
//			return false;
//		} else if (obj == this) {
//			return true;
//
//		} else {
//			Carte c = (Carte) obj;
//			return (c.valeur == this.valeur && c.couleur == this.couleur);
//		}
//	}
	
	
}
