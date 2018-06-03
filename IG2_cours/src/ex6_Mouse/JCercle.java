package ex6_Mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class JCercle extends JPanel implements CercleModeleListener {
	CercleModele modele;

	public JCercle() {
		setBackground(Color.WHITE);
		CercleModele m = new CercleModele(100, 100, 40);
		setModele(m);
		DeplacementListener listener = new DeplacementListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void setModele(CercleModele modele) {
		if (this.modele != null) {
			this.modele.removeModelListener(this);
		}
		this.modele = modele;
		modele.addModelListener(this);
	}

	public CercleModele getModele() {
		return this.modele;
	}

	@Override
	public void modeleModifie() {
		repaint();
		revalidate();
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}

	public void drawModele(Graphics g) {
		g.setColor(this.modele.getCouleurCercle());
		g.fillOval(this.modele.getLeft(), this.modele.getTop(), this.modele.getDiametre(), this.modele.getDiametre());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		Color old = g.getColor();
		if (this.modele != null) {
			this.drawModele(g);
		}
		g.setColor(old);
	}

	private class DeplacementListener extends MouseAdapter {
		/**
		 * Le cercle actuellement sélectionné.
		 */

		private CercleModele cercleSelectionne = null;

		/**
		 * Les derniers x et y enregistrés (nécessaires pour connaître le déplacement de
		 * la souris).
		 */
		private int lastX, lastY;

		@Override
		public void mousePressed(MouseEvent e) {
			cercleSelectionne = null;
			// où clique-t-on ?
			Point p = e.getPoint();

			if (modele.contientPoint(p)) {
				cercleSelectionne = modele;
			}
			lastX = p.x;
			lastY = p.y;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			cercleSelectionne = null;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (cercleSelectionne != null) {
				Point p = e.getPoint();
				int dx = p.x - lastX; // p.x = position actuelle de la souris
				int dy = p.y - lastY;
				cercleSelectionne.setX(cercleSelectionne.getX() + dx);
				cercleSelectionne.setY(cercleSelectionne.getY() + dy);
				lastX = p.x;
				lastY = p.y;
			}
		}
	}
}
