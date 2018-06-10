
import java.util.ArrayList;
import java.util.Collections; // pour le tri

/** Client titulaire de plusieurs comptes **/

public class Client {
	private String nom; // Nom titulaire
	private ArrayList<Compte> cmptes; // Liste de ses comptes

	/**
	 * Constructeur
	 * 
	 * @param n
	 *            nom du titulaire
	 */
	public Client(String n) {
		nom = n;
		cmptes = new ArrayList<Compte>();
	}

	/**
	 * @return nom du titulaire
	 */
	public String getNom() {
		return nom;
	}

	public void ajout(Compte c) {
		cmptes.add(c);
	}

	/**
	 * Affiche dans l'ordre des numéros de compte.
	 */
	public void affiche() {
		if (cmptes.isEmpty()) {
			System.out.println("Aucun compte");
			return;
		}
		System.out.println("Comptes de " + nom + " :");
		ArrayList<Compte> t = new ArrayList<Compte>(cmptes);
		Collections.sort(t);
		for (Compte c : t) {
			c.affiche();
		}
		System.out.println();
	}

	public void afficheParSolde() {
		if (cmptes.isEmpty()) {
			System.out.println("Aucun compte");
			return;
		}
		System.out.println("Comptes de " + nom + " tries par solde:");
		ArrayList<Compte> t = new ArrayList<Compte>(cmptes);
		Collections.sort(t, new ordreParSolde());
		for (Compte c : t) {
			c.affiche();
		}
		System.out.println();
	}

	public double bilan() {
		double s = 0;
		for (Compte c : cmptes) {
			s = s + c.getSolde();
		}
		return s;
	}
}
