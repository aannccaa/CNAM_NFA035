package solutioncartes;

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
	public boolean equals(Object obj) {
		if (obj instanceof Carte) {
			Carte c = (Carte) obj;
			return c.couleur.equals(this.couleur) && c.valeur == this.valeur;
		} else
			return false;
	}
	
	@Override
	public int hashCode() {
		return 17 + ((Integer)valeur).hashCode()* 37 + couleur.hashCode()* 101;
	}

   // Réponse possible question 8
   public int compareTo(Carte o) {
            if (this.getValeur() == o.getValeur()) {
            if (this.getCouleur().ordinal() < o.getCouleur().ordinal()) {
                return -1;
            } else if (this.getCouleur().ordinal() > o.getCouleur().ordinal()) {
                return 1;
            } else {
                return 0;
            }
        } else if (this.getValeur() < o.getValeur())
           return -1;
        else 
            return 1;
    }
}
