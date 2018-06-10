package ex6_Mouse;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CercleModele {
	private int x;
	private int y;
	private int rayon;
	private Color couleurCercle;
	private List<CercleModeleListener> listeners;

	public CercleModele(int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.couleurCercle = Color.BLUE;
		this.listeners = new ArrayList<>();
	}

	public boolean contientPoint(Point p) {
		// si la distance du point au centre du cercle < rayon => le point est dans le
		// cercle
		return ((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y) < this.rayon * this.rayon);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
		notifyListener();
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
		notifyListener();
	}

	public int getRayon() {
		return this.rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
		notifyListener();
	}

	public Color getCouleurCercle() {
		return this.couleurCercle;
	}

	public void setCouleurCercle(Color couleurCercle) {
		this.couleurCercle = couleurCercle;
		notifyListener();
	}

	public int getLeft() {
		return this.x - this.rayon;
	}

	public int getTop() {
		return this.y - this.rayon;
	}
	
	public int getDiametre() {
		return this.rayon*2;
	}

	public void notifyListener() {
		for (CercleModeleListener l : listeners) {
			l.modeleModifie();
		}
	}

	public void addModelListener(CercleModeleListener listener) {
		listeners.add(listener);
	}

	public void removeModelListener(CercleModeleListener listener) {
		listeners.remove(listener);
	}
}
