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

public class Carte implements Comparable<Carte> {

//decommenter si on veut pas implementer Comparable et la méthode "compareTo"
// public class Carte {

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
		if (this.getCouleur() != other.getCouleur()) {
			return false;
		}
		if (this.getValeur() != other.getValeur()) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Carte other) {
		// on compare d'abord par valeur, puis par couleur
		if (this.valeur == other.valeur) {
			if (this.couleur.ordinal() < other.couleur.ordinal()) {
				return -1;
			} else if (this.couleur.ordinal() > other.couleur.ordinal()) {
				return 1;
			} else {
				return 0;
			}
		} else if (this.valeur < other.valeur) {
			return -1;
		} else {
			return 1;
		}
	}
}
