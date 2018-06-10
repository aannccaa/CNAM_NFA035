package collections2.exercice2;

public class Carte {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + valeur;
		return result;
	}

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
	
	
}
