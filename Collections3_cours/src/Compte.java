import java.util.HashSet;
import java.util.Set;

class Compte {
	@Override
	public String toString() {
		return "Compte [banque=" + banque.getNom() + ", numero=" + numero + ", titulaires=" + titulaires + ", solde=" + solde
				+ "]";
	}

	final Banque banque;
	final int numero;
	final Set<Titulaire> titulaires;
	private double solde;

	Compte(Banque banque, int numc, double init) {
		this.banque = banque;
		this.numero = numc;
		this.solde = init;
		this.titulaires = new HashSet<Titulaire>();
	}

	double getSolde() {
		return this.solde;
	}

	void ajouterTitulaire(Titulaire t) {
		this.titulaires.add(t);
	}

	void depot(double m) {
		this.solde = this.solde + m;

	}

	void retrait(double m) {
		this.solde = this.solde - m;
	}

}
