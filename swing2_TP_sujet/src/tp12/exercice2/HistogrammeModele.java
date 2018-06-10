package tp12.exercice2;
/*
Exercice 2 : Affichage d’histogramme
On de ́sire re ́aliser un objet capable d’afficher des histogrammes, en utilisant l’architecture MVC. 
On peut supposer que le mode`le, HistogrammeModele, repre ́sente un histogramme ou` toutes les valeurs 
sont positives (ça simplifiera votre code de dessin).

Question 1
Comple ́tez le mode`le HistogrammeModele. 

Question 2
Comple ́tez la classe JHistogramme 

Question 3
Modifiez le programme pour pouvoir changer la valeur d’une entre ́e de l’histogramme.
 */

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
		valeurs = new double[nombreDeValeurs];
		for (int i = 0; i < nombreDeValeurs; i++) {
			valeurs[i] = 0;
		}
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
		this.valeurs[i] = v;
		prevenirListeners();
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
		return this.valeurs[i];
	}

	/**
	 * Renvoie le nombre de valeurs dans l'histogramme.
	 * 
	 * @return
	 */
	public int getNombreDeValeurs() {
		// À COMPLÉTER.
		return valeurs.length;
	}

	/**
	 * Renvoie la plus grande valeur dans l'histogramme.
	 * 
	 * @return la plus grande valeur dans l'histogramme.
	 */
	public double getMax() {
		// À COMPLÉTER.
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < valeurs.length; i++) {
			if (valeurs[i] > max) {
				max = valeurs[i];
			}
		}
		return max;
	}

	/**
	 * Renvoie la plus petite valeur dans l'histogramme.
	 * 
	 * @return la plus petite valeur dans l'histogramme.
	 */
	public double getMin() {
		// À COMPLÉTER.
		double min = Integer.MAX_VALUE;
		for (int i = 0; i < valeurs.length; i++) {
			if (valeurs[i] < min) {
				min = valeurs[i];
			}
		}
		return min;
	}

	/**
	 * Ajoute un listener, qui devra être prévenu quand les valeurs changeront.
	 * 
	 * @param l
	 */
	public void ajouterHistogrammeListener(HistogrammeListener l) {
		listeners.add(l);
		l.valeurModifiee();
	}

	/**
	 * Enlève un listener.
	 * 
	 * @param l
	 */
	public void supprimerHistogrammeListener(HistogrammeListener l) {
		listeners.remove(l);
	}

	/**
	 * Méthode auxiliaire à utiliser pour prévenir tous les listener d'un
	 * histogramme que celui-ci a été modifié.
	 */
	private void prevenirListeners() {
		for (HistogrammeListener l : listeners) {
			l.valeurModifiee();
		}
	}

}
