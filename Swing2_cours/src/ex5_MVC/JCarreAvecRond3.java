package ex5_MVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCarreAvecRond3 extends JPanel implements CarreAvecRondModeleListener {
	private CarreAvecRondModele modele;

	public JCarreAvecRond3() {
		setBackground(Color.WHITE);
		modele = new CarreAvecRondModele();
		setModele(modele);
	}

	public void setModele(CarreAvecRondModele modele) {
		if (this.modele != null) {
			this.modele.removeModeleListener(this);
		}
		this.modele = modele;
		modele.addModeleListener(this);
	}

	public CarreAvecRondModele getModele() {
		return this.modele;
	}

	@Override
	public void modeleModifie() {
		repaint();
		revalidate();
	}

	public Dimension getPreferredSize() {
		int w = Math.max(300, this.modele.getCentreX() + this.modele.getRayon());
		int h = Math.max(300, this.modele.getCentreY() + this.modele.getRayon());
		return new Dimension(w, h);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.modele.getCouleurCercle());
		g.fillOval(this.modele.getLeft(), this.modele.getTop(), this.modele.getDiametre(), this.modele.getDiametre());
	}

	public void setCouleur(Color couleurCercle) {
		this.modele.setCouleur(couleurCercle);

	}

	public Color getCouleurCercle() {
		return this.modele.getCouleurCercle();
	}

	public int getCentreX() {
		return this.modele.getCentreX();
	}

	public int getCentreY() {
		return this.modele.getCentreY();
	}

	public void setCenterX(int centreX) {
		this.modele.setCenterX(centreX);

	}

	public void setCentreY(int centreY) {
		this.modele.setCenterY(centreY);
	}

}
