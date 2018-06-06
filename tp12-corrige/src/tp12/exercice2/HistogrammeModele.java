package tp12.exercice2;

import java.util.ArrayList;
import java.util.List;

/**
 * Pour la version demandée en TP : on peut éventuellement considérer que les
 * valeurs sont toujours positives. ça simplifie le dessin.
 * 
 * @author rosmord
 *
 */
public class HistogrammeModele {
	double valeurs[];
	List<HistogrammeListener> listeners = new ArrayList<HistogrammeListener>();

	/**
	 * Crée un histogramme correspondant à <em>nombreDeValeurs</em> valeurs.
	 * 
	 * @param nombreDeValeurs
	 *            le nombre de valeurs dans l'histogramme. Initialement, toutes les
	 *            valeurs seront à 0.
	 */
	public HistogrammeModele(int nombreDeValeurs) {
		// À COMPLÉTER.
	}

	/**
	 * Fixe l'une des valeurs de l'histogramme.
	 * 
	 * @param i
	 *            le numéro de la valeur, entre 0 et getNombreDeValeurs()
	 * @param v
	 *            la nouvelle valeur à donner.
	 */
	public void setValeur(int i, double v) {
		// À COMPLÉTER.
	}

	/**
	 * Renvoie la valeur numéro i de l'histogramme.
	 * 
	 * @param i
	 *            le numéro de la valeur, entre 0 et getNombreDeValeurs()
	 * @return la valeur numéro i.
	 */
	public double getValeur(int i) {
		// À COMPLÉTER.
		return 0;
	}

	/**
	 * Renvoie le nombre de valeurs dans l'histogramme.
	 * 
	 * @return
	 */
	public int getNombreDeValeurs() {
		// À COMPLÉTER.
		return 0;
	}

	/**
	 * Renvoie la plus grande valeur dans l'histogramme.
	 * 
	 * @return la plus grande valeur dans l'histogramme.
	 */
	public double getMax() {
		// À COMPLÉTER.
		return 0;
	}

	/**
	 * Renvoie la plus petite valeur dans l'histogramme.
	 * 
	 * @return la plus petite valeur dans l'histogramme.
	 */
	public double getMin() {
		// À COMPLÉTER.
		return 0;
	}

	/**
	 * Ajoute un listener, qui devra être prévenu quand les valeurs changeront.
	 * @param l
	 */
	public void ajouterHistogrammeListener(HistogrammeListener l) {
		listeners.add(l);
	}

	/**
	 * Enlève un listener.
	 * @param l
	 */
	public void supprimerHistogrammeListener(HistogrammeListener l) {
		listeners.remove(l);
	}

	/**
	 * Méthode auxiliaire à utiliser pour prévenir tous les listener d'un histogramme que celui-ci a été modifié.
	 */
	private void prevenirListeners() {
		for (HistogrammeListener l : listeners) {
			l.valeurModifiee();
		}
	}

}
