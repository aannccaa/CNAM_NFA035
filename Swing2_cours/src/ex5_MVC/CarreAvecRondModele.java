package ex5_MVC;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CarreAvecRondModele {
	private int centreX;
	private int centreY;
	private int rayon;
	private Color couleurCercle;
	private List<CarreAvecRondModeleListener> listeners;

	public CarreAvecRondModele() {
		centreX = 30;
		centreY = 30;
		rayon = 30;
		couleurCercle = Color.BLUE;
		listeners = new ArrayList<>();
	}

	public void setCenterX(int centreX) {
		this.centreX = centreX;
		notifyListeners();
	}

	public void setCenterY(int centreY) {
		this.centreY = centreY;
		notifyListeners();
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
		notifyListeners();
	}

	public void setCouleur(Color couleurCercle) {
		this.couleurCercle = couleurCercle;
		notifyListeners();
	}

	public int getCentreX() {
		return this.centreX;
	}

	public int getCentreY() {
		return this.centreY;
	}

	public int getRayon() {
		return this.rayon;
	}

	public Color getCouleurCercle() {
		return this.couleurCercle;
	}
	
	public int getDiametre() {
		return this.rayon*2;
	}
	
	public int getLeft() {
		return this.centreX - this.rayon;
	}
	
	public int getTop() {
		return this.centreY - this.rayon;
	}

	public void notifyListeners() {
		for (CarreAvecRondModeleListener l : listeners) {
			l.modeleModifie();
		}
	}

	public void addModeleListener(CarreAvecRondModeleListener listener) {
		listeners.add(listener);
	}

	public void removeModeleListener(CarreAvecRondModeleListener listener) {
		listeners.remove(listener);
	}
}
