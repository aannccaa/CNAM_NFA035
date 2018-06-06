package tp12.exercice2;

/**
 * Listener pour les histogrammes.
 * Un listener est un objet qui veut être prévenu quand on modifie les valeurs d'un 
 * histogramme. Typiquement, les objets graphiques sont des listeners.
 * @author rosmord
 */
public interface HistogrammeListener {

	/**
	 * Prévient qu'une ou plusieurs valeurs ont été modifiées.
	 * (on pourrait faire plus précis).
	 */
	void valeurModifiee();
}
