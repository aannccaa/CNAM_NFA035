package tp12.exercice2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JHistogramme extends JPanel {
	private HistogrammeModele modele;
	private MonHistoListener listener;
	private int largeurBarre = 30;
	private double echelleY = 1.0;
	private Color couleurTrait = Color.BLACK;
	private Color couleurRectangle = Color.BLUE;
	private Color couleurRepaire = Color.RED;

	/**
	 * Marge verticale (espace pour repère, éventuellement).
	 */
	private int espaceVertical= 10;
	/**
	 * Marge horizontale.
	 */
	private int espaceHorizontal= 10;
	
	public JHistogramme() {
		listener = new MonHistoListener();
		HistogrammeModele histogrammeModele = new HistogrammeModele(10);
		// On fabrique un histogramme de départ plus intéressant...
		int s= 1;
		for (int i = 0; i < histogrammeModele.getNombreDeValeurs(); i++) {
			histogrammeModele.setValeur(i, (i+1)* 10* s);
			s= -s;
		}
		setModele(histogrammeModele);
		setBackground(Color.WHITE);
	}

	public void setModele(HistogrammeModele histogrammeModele) {
		if (this.modele != null) {
			// On se déconnecte de l'ancien modèle...
			this.modele.supprimerHistogrammeListener(listener);
		}
		this.modele = histogrammeModele;
		this.modele.ajouterHistogrammeListener(listener);
		revalidate();
		repaint();
	}

	public HistogrammeModele getModele() {
		return modele;
	}

	@Override
	public Dimension getPreferredSize() {
		double max = modele.getMax();
		double min = modele.getMin();
		if (min > 0)
			min = 0;
		int h = (int) ((max - min) * echelleY) + 1;
		int w = modele.getNombreDeValeurs() * largeurBarre;
		return new Dimension(w+ 2* espaceHorizontal, h+ 2* espaceVertical);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		double max = modele.getMax();
		double min = modele.getMin();

		// Ordonnée du 0 (note : prendre en compte un espace pour le repère?)
		int y0 = getHeight() - espaceVertical;
		if (min < 0) {
			y0 = (int) (getHeight() -espaceVertical + min * echelleY);
		}

		int x = espaceHorizontal;
		
	
		for (int i = 0; i < modele.getNombreDeValeurs(); i++) {
			g.setColor(couleurRectangle);
			int h = (int) Math.abs(modele.getValeur(i) * echelleY);
			int y;
			if (modele.getValeur(i) > 0) {
				y = y0 - (int) (modele.getValeur(i) * echelleY);
			} else {
				y= y0;
			}
			g.fillRect(x, y, largeurBarre, h);
			g.setColor(couleurTrait);
			g.drawRect(x, y, largeurBarre, h);
			x += largeurBarre;
		}
		
		g.setColor(couleurRepaire);
		g.drawLine(espaceHorizontal, y0, getWidth()- espaceHorizontal, y0);
		g.drawLine(espaceHorizontal, espaceVertical, espaceHorizontal, getHeight() - espaceVertical);

	}

	public void setLargeurBarre(int largeurBarre) {
		this.largeurBarre = largeurBarre;
		revalidate();
		repaint();
	}

	public void setEchelleY(double echelleY) {
		this.echelleY = echelleY;
		revalidate();
		repaint();
	}

	public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
		repaint();
	}

	public void setCouleurRectangle(Color couleurRectangle) {
		this.couleurRectangle = couleurRectangle;
		repaint();
	}

	private class MonHistoListener implements HistogrammeListener {

		@Override
		public void valeurModifiee() {
			// Pourrait être plus précis si on passait des informations sur la
			// valeur modifiée...
			// et n'appeler revalidate() que si c'est nécessaire...
			revalidate();
			repaint();
		}

	}
}
