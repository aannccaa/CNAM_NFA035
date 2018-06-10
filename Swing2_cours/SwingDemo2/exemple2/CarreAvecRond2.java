package exemple2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarreAvecRond2 extends JPanel {

	private int centreX = 10, centreY = 10, rayon = 30;
	private Color couleurCercle= Color.BLUE;

	public CarreAvecRond2() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

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
		this.centreX = centreX;
		repaint();
	}
	
	public void setCentreY(int centreY) {
		this.centreY = centreY;
		repaint();
	}
	
	public void setRayon(int rayon) {
		this.rayon = rayon;
		repaint();
	}
	
	public int getCentreX() {
		return centreX;
	}
	
	public int getCentreY() {
		return centreY;
	}
	
}
