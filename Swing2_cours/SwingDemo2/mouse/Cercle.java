package mouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Un cercle dans un dessin dessiné par un objet CerclesEtSouris.
 * <p> Dépend trop de la classe CerclesEtSouris, mais on veut rester simple.
 * <p> Le MVC pur et dur, c'est l'étape suivante.
 * @author rosmord
 *
 */
public class Cercle {
	private CerclesEtSouris proprietaire;
	private int x, y; // coordonnées du cercle
	private int rayon;
	private Color color= Color.BLUE;
	
	
	public Cercle(CerclesEtSouris proprietaire, int x, int y, int rayon) {
		super();
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.proprietaire= proprietaire;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		proprietaire.repaint();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		proprietaire.repaint();
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
		proprietaire.repaint();
	}
	
	public boolean contientPoint(Point p) {
		return ((p.x - x)*(p.x -x) + (p.y -y)*(p.y-y)) < rayon* rayon;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
		proprietaire.repaint();
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x- rayon, y- rayon, 2*rayon, 2*rayon);
	}
	
	
}
