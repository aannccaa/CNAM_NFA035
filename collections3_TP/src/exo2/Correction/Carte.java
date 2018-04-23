package exo2.Correction;

public class Carte implements Comparable<Carte>{

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
		// La valeur est un nombre... 
		// mais pour l'affichage, c'est modérément sympathique.
		// du coup :
		// (on pourrait aussi utiliser un tableau au lieu d'un switch)
		String valString;
		switch (valeur) {
		case 1:
			valString= "as";
			break;
		case 11:
			valString= "valet";
			break;
		case 12:
			valString= "dame";
			break;
		case 13:
			valString= "roi";
			break;			
		default:
			valString= ""+valeur;
			break;
		}
		return "" + valString + " de " + couleur;
	}
	
	@Override
	// Override est très intéressant ici: il vous protège contre une
	// erreur courante, qui serait d'écrire ... equals(Carte c) : ça
	// a l'air de fonctionner, mais c'est la méthode equals(Object o) qui 
	// est utilisé par les collections.
	public boolean equals(Object o) {
		if (o instanceof Carte) {
			Carte autre= (Carte)o;
			return this.couleur.equals(autre.couleur) && this.valeur== autre.valeur;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// NOTEZ l'utilisation de couleur.hashCode() pour écrire
		// this.hashCode.
		return this.valeur + 31*this.couleur.hashCode();
	}

	@Override
	public int compareTo(Carte o) {
		// On s'arrange pour que les as soient à leur place,
		// en utilisant la méthode privée "vraieValeur".
		int res= this.getVraieValeur() - o.getVraieValeur();
		if (res != 0) {
			return res;
		} else {
			return this.couleur.compareTo(o.couleur);
		}
	}

	/**
	 * Retourne la "vraie" valeur de la carte pour les comparaisons.
	 * La valeur "nominale" de l'as est 1, mais sa valeur réelle est 14.
	 * @return
	 */
	public int getVraieValeur() {
		if (valeur== 1)
			return 14;
		else 
			return valeur;
	}
}
