package exo2;

/**
 * Modélise un élève avec plusieurs modules d'enseignement avec évaluation.
 * 
 * @author aponte
 *
 */

public class Eleve {
	private String nom;
	private AvecNote[] ues;

	/**
	 * Constructeur.
	 * 
	 * @param n
	 */
	public Eleve(String n) {
		nom = n;
		ues = new AvecNote[0];
	}

	/**
	 * Ajout d'un nouveau module c.
	 * 
	 * @param c
	 * @return
	 */
	public boolean ajout(AvecNote c) {
		AvecNote[] tmp = new AvecNote[ues.length + 1];
		for (int i = 0; i < ues.length; i++) {
			tmp[i] = ues[i];
		}
		tmp[ues.length] = c;
		this.ues = tmp;
		return true;
	}

	/**
	 * Moyenne de toutes les ues. Retourne 0 si aucune ue.
	 * 
	 * @return
	 */
	public double moyenne() {
		if (ues.length == 0)
			return 0;
		double res = 0;
		for (int i = 0; i < ues.length; i++) {
			res = res + ues[i].calculeNote();
		}
		return res / ues.length;
	}
	
	public void afficher() {
		System.out.println(this.nom + ": ");
		for (int i = 0; i < ues.length; i++) {
			System.out.println(ues[i]);
		}
	}
}
