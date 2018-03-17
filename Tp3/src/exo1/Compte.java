package exo1;

public class Compte {
	/* Variables d'instance */
	private int numero;
	private String nom;
	private double solde;

	/**
	 * Constructeur
	 * 
	 * @param num
	 *            numero compte
	 * @param nom
	 *            nom du titulaire
	 * @param init
	 *            solde initial
	 * 
	 */
	public Compte(int num, String nom, double init) {
		this.numero = num;
		this.nom = nom;
		this.solde = init;
	}

	/** Accesseurs */

	/**
	 * Solde du compte
	 * 
	 * @return valeur courante du solde
	 */
	public double getSolde() {
		return this.solde;
	}

	/**
	 * 
	 * @return Nom du titulaire
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @return numero du compte
	 */
	public int getNum() {
		return this.numero;
	}
	/* Operations sur le compte */

	/**
	 * Depot du montant
	 * 
	 * @param n
	 */
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

	public String toString() {
		return ("Numero: " + this.numero + "," + " titulaire: " + this.nom + "," + " solde: " + this.solde);
	}

	public void affiche() {
		System.out.println(this.toString());
		System.out.println();
	}

	/**
	 * Virement de m du compte actuel vers dest
	 * 
	 * @param m
	 *            montant à virer
	 * @param dest
	 *            compte destinataire
	 */
	public void virerVers(double m, Compte dest) {
		this.retrait(m);
		dest.depot(m);
	}

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
}
