import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
// import java.util.Map.Entry;

public class Banque {

	private String nom; // nom de la banque private
	int dernierNumero = 0; // Dernier numero compte

	// Tous les comptes de la banque
	private Map<Integer, Compte> tous = new HashMap<>();

	/* Constructeur */
	public Banque(String n) {
		nom = n;
	}

	public String getNom() {
		return this.nom;
	}

	/*
	 * Creation compte (titulaire, montant initial) ajout compte dans la liste des
	 * comptes de la banque ajout compte pour les titulaires
	 */

	public void creerCompte(Titulaire[] titulaires, double soldeInitial) {
		// incrementer dernierNumero puis l'attribuer à numeroCompte
		int numeroCompte = ++dernierNumero;
		Compte c = new Compte(this, numeroCompte, soldeInitial);
		tous.put(numeroCompte, c); // ajout dans comptes banque
		for (Titulaire t : titulaires) {
			t.ajouterCompte(this.getNom(), c.numero); // ajout dans chaque titulaire
			c.ajouterTitulaire(t);
		}
	}

	/**
	 * Teste si
	 * 
	 * @param n
	 *            est le numero d’un compte dans la banque
	 * @return true dans ce cas.
	 */
	public boolean isNumCompte(int n) {
		return tous.containsKey(n);
	}

	/* Effectuer un depot pour un numero de compte */
	/*
	 * Depot du montant
	 * 
	 * @param m dans compte de numero @param num
	 * 
	 * @return true si depot effectue, false si compte inexistant
	 */

	public boolean depot(int num, double m) {
		Compte c = getCompteDeNum(num);
		if (c == null) {
			return false;
		}
		c.depot(m); // appel methode depot de Compte
		return true;
	}

	/**
	 * Virement du montant m depuis compte numero
	 * 
	 * @param numS,
	 *            vers le compte numero
	 * @param numD
	 *            de la banque @param b
	 * @return true si virement effectue
	 */
	public boolean virerVers(double m, int numS, int numD, Banque b) {
		if (!isNumCompte(numS))
			return false;
		Compte c = getCompteDeNum(numS);
		c.retrait(m);
		return b.depot(numD, m);
	}

	/**
	 * Virement de montant m a partir du compte numero
	 * 
	 * @param numS,
	 *            vers le compte numero
	 * @param numD
	 *            de la banque courante
	 * @return true si virement effectue
	 */
	public boolean virerVers(double m, int numS, int numD) {
		if (!isNumCompte(numD) || !isNumCompte(numS))
			return false;
		else
			return virerVers(m, numS, numD, this); // b -> this
	}

	/**
	 * Obtenir le compte de numero
	 * 
	 * @param n
	 * @return ce compte s’il existe, null sinon
	 */
	private Compte getCompteDeNum(int n) {
		return this.tous.get(new Integer(n));
	}

	/* Bilan (solde total) des comptes de la banque */
	public double getSoldeTous() {
		double solde = 0;
		Collection<Compte> comptes = this.tous.values();
		for (Compte c : comptes) {
			solde = solde + c.getSolde();
		}
		// Collection<Compte> comptes = this.tous.values();
		// for(Entry<Integer, Compte> entry : this.tous.entrySet()) {
		// Compte c = entry.getValue();
		// Integer numero = entry.getKey();
		// solde = solde + c.getSolde();
		// }

		// for(Integer numero : this.tous.keySet()) {
		// Compte c = this.tous.get(numero);
		// solde = solde + c.getSolde();
		// }
		return solde;
	}

	public double bilan() {
		double res = 0;
		Set<Map.Entry<Integer, Compte>> s = this.tous.entrySet();
		for (Map.Entry<Integer, Compte> asso : s) {
			res = res + asso.getValue().getSolde();
		}
		return res;
	}
	
	public void suprimerComptesSoldeNull() {
		Set<Map.Entry<Integer, Compte>> s = tous.entrySet();
		Iterator<Map.Entry<Integer, Compte>> its = s.iterator();
		while(its.hasNext()) {
			if (its.next().getValue().getSolde() == 0) {
				its.remove();
			}
		}
	}

	@Override
	public String toString() {
		return "Banque [nom=" + nom + ", tous=" + tous + "]";
	}

	public void afficher() {
		System.out.println(this.toString());
	}

	public void afficheParSolde() {
		// copie de values() dans une liste
		ArrayList<Compte> comptes = new ArrayList<Compte>(this.tous.values());
		// on les trie
		Collections.sort(comptes, new ordreParSolde());
		// et on les affiche

		for (Compte c : comptes) {
			c.afficher();
		}
	}

}
