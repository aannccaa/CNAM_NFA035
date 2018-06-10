package exercice2;

/**
 * Une recette.
 * 
 * @author rosmord
 */
public class Recette implements Comparable<Recette> {
	private String titre;
	private double sommeNotes;
	private int nombreDeNotes;

	/**
	 * Crée une recette avec un titre (non vide !)
	 * 
	 * @param titre
	 *            le titre (non vide ou null)
	 * @throws IllegalArgumentException
	 *             si titre est null.
	 * @throws NullPointerException
	 *             si titre est vide.
	 */
	public Recette(String titre) {
		if (titre == null)
			throw new NullPointerException();
		if (titre.isEmpty())
			throw new IllegalArgumentException();
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	/**
	 * Ajoute une note.
	 * <p>
	 * condition: note doit être compris entre 1 et 5.
	 * <p>
	 * post condition: la moyenne des notes est à jour.
	 * 
	 * @param note
	 *            un entier entre 1 et 5.
	 * @throws IllegalArgumentException
	 *             si note est hors intervalle.
	 */
	public void ajouterNote(int note) {
		if (note < 1 || note > 5)
			throw new IllegalArgumentException("note hors limites");
		sommeNotes += note;
		nombreDeNotes++;
	}

	/**
	 * Retourne la moyenne des notes obtenues (ou 0 si aucune note). (noter le
	 * second cas !)
	 * 
	 * @return
	 */
	public double getMoyenneNotes() {
		if (nombreDeNotes == 0)
			return 0;
		else
			return sommeNotes / nombreDeNotes;
	}

	@Override
	public String toString() {
		return titre + " note moyenne: " + getMoyenneNotes();
	}

	/**
	 * Compare par titre, puis par note.
	 * <p>
	 * Note: il serait cohérent, comme on implémente Comparable, de redéfinir
	 * aussi equals et hashCode...
	 * <p>
	 * dans ce cas, il faudrait se demander si la recette n'est pas en fin de
	 * compte identifiée par son titre. Auquel cas, seule la comparaison par
	 * titre devrait être effectuée.
	 */
	@Override
	public int compareTo(Recette o) {
		int resultat = this.getTitre().compareTo(o.getTitre());
		if (resultat != 0)
			return resultat;
		resultat = Double.compare(this.getMoyenneNotes(), o.getMoyenneNotes());
		return resultat;
	}

}
