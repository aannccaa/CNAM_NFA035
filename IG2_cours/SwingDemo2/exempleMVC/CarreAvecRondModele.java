package exempleMVC;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Version MVC de notre exemple. On pourrait utiliser la classe
 * {@link Observable}, mais on aurait une interface trop vague... et d'autre
 * part, le lecteur comprendra sans doute mieux ce qui se passe avec une
 * implantation spécialisée.
 * 
 * @author rosmord
 * 
 */
public class CarreAvecRondModele {

	private int centreX = 30;
	private int centreY = 30;
	private int rayon = 30;
	private Color couleurCercle = Color.BLUE;
	
	private List<CarreAvecRondModeleListener> listeners = new ArrayList<CarreAvecRondModeleListener>();

	public int getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		if (centreX < rayon)
			return;
		this.centreX = centreX;
		notifyListeners();
	}

	public int getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		if (centreY < rayon)
			return;
		this.centreY = centreY;
		notifyListeners();
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		if (rayon > centreX || rayon > centreY)
			return;
		this.rayon = rayon;
		notifyListeners();
	}

	public Color getCouleurCercle() {
		return couleurCercle;
	}

	public void setCouleurCercle(Color couleurCercle) {
		this.couleurCercle = couleurCercle;
		notifyListeners();
	}

	public int getDiametre() {
		return 2 * rayon;
	}

	public int getLeft() {
		return centreX - rayon;
	}

	public int getTop() {
		return centreY - rayon;
	}
	
	public void addModeleListener(CarreAvecRondModeleListener listener) {
		listeners.add(listener);
	}
	
	public void removeModeleListener(CarreAvecRondModeleListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Prévient les listeners d'une modification.
	 * @param event
	 */
	private void notifyListeners() {
		for (CarreAvecRondModeleListener l: listeners) {
			l.modeleModifie();
		}
	}
}
