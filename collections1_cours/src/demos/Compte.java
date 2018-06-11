package demos;

public class Compte implements Comparable<Compte> {
	/* Variables d'instance */
	private int numero;
	private double solde;

	/* Constructeur */
	public Compte(int n, double init) {
		this.solde = init;
		this.numero = n;
	}

	/* Méthodes d'instance */

	public double getSolde() {
		return this.solde;
	}

	public int getNumero() {
		return this.numero;
	}

	public void depot(double n) {
		this.solde = this.solde + n;
	}

	/**
	 * Retrait du montant
	 * 
	 * @param m
	 */
	public void retrait(double m) {
		this.solde = this.solde - m;
	}

	public void affiche() {
		System.out.println("Numero: " + this.numero + ", solde: " + this.getSolde());
		System.out.println();
	}

	/* Une méthode statique */
	/**
	 * Affichage d'un tableau de comptes
	 * 
	 * @param tc
	 */
	public static void afficheTabComptes(Compte[] tc) {
		for (int i = 0; i < tc.length; i++) {
			tc[i].affiche();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Compte other = (Compte) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public int compareTo(Compte o) {
		Integer ici = this.getNumero();
		return ici.compareTo(o.getNumero());
	}
}
