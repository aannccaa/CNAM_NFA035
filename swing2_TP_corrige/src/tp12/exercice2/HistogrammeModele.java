package tp12.exercice2;

import java.util.ArrayList;
import java.util.List;

/**
 * Pour la version demandée en TP : on peut éventuellement considérer que les valeurs 
 * sont toujours positives. ça simplifie le dessin.
 * @author rosmord
 *
 */
public class HistogrammeModele {
	double valeurs [];
	List<HistogrammeListener> listeners= new ArrayList<HistogrammeListener>();
	
	public HistogrammeModele(int taille) {
		valeurs= new double[taille];
	}
	
	public void setValeur(int i, double v) {
		valeurs[i]= v;
		prevenirListeners();
	}
	
	public double getValeur(int i) {
		return valeurs[i];
	}
	
	public int getNombreDeValeurs() {
		return valeurs.length;
	}
	
	
	public double getMax() {
		double max= valeurs[0];
		for (int i= 1; i < valeurs.length; i++) {
			if (max < valeurs[i])
				max= valeurs[i];
		}
		return max;
	}
	
	public double getMin() {
		double min= valeurs[0];
		for (int i= 1; i < valeurs.length; i++) {
			if (min > valeurs[i])
				min= valeurs[i];
		}
		return min;
	}

	
	public void ajouterHistogrammeListener(HistogrammeListener l) {
		listeners.add(l);
	}
	
	public void supprimerHistogrammeListener(HistogrammeListener l) {
		listeners.remove(l);
	}
	
	private void prevenirListeners() {
		for (HistogrammeListener l: listeners) {
			l.valeurModifiee();
		}
	}
	
}
