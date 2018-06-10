package exemple3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarreAvecRond3 extends JPanel {

	private int centreX = 30, centreY = 30, rayon = 30;
	private Color couleurCercle= Color.BLUE;

	public CarreAvecRond3() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		int w= Math.max(300, centreX + rayon);
		int h= Math.max(300, centreY+ rayon); 
		return new Dimension(w, h);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		g.setColor(couleurCercle);
		g.fillOval(centreX -rayon, centreY - rayon, rayon*2, rayon*2);
	}

	public void setCouleurCercle(Color couleurCercle) {
		this.couleurCercle = couleurCercle;
		repaint();
	}
	
	
	public void setCentreX(int centreX) {
		if (centreX < rayon) return;
		this.centreX = centreX;
		repaint();
		revalidate();
	}
	
	public void setCentreY(int centreY) {
		if (centreY < rayon) return;
		this.centreY = centreY;
		repaint();
		revalidate();
	}
	
	public void setRayon(int rayon) {
		if (rayon > centreX || rayon > centreY)
			return;
		this.rayon = rayon;
		repaint();
		revalidate();
	}
	
	public int getCentreX() {
		return centreX;
	}
	
	public int getCentreY() {
		return centreY;
	}
	
}
