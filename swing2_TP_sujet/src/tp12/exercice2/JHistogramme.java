package tp12.exercice2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Un objet sachant afficher un histogramme. (vous êtes libre de faire ce que
 * vous voulez, mais les variables d'instances proposées sont un point de départ
 * utile).
 * 
 * @author rosmord
 *
 */
@SuppressWarnings("serial")
public class JHistogramme extends JPanel {
	private HistogrammeModele modele;

	/**
	 * Le listener qui va déclencher le dessin de l'objet quand l'histogramme est
	 * modifié est une classe interne.
	 * <p>
	 * Intérêt : on ne le voit pas de l'extérieur. Personne n'a besoin de connaître
	 * cet objet.
	 */
	private MonHistoListener listener;

	/**
	 * épaisseur des barres de l'histogramme.
	 */
	// private int largeurBarre = 30;
	private Color couleurTrait = Color.BLACK;
	private Color couleurRectangle = Color.BLUE;
	private Color couleurRepaire = Color.RED;

	/**
	 * Marge verticale (espace pour repère, éventuellement).
	 */
	private int espaceVertical = 10;

	/**
	 * Marge horizontale.
	 */
	private int espaceHorizontal = 10;

	public JHistogramme() {
		listener = new MonHistoListener();
		HistogrammeModele histogrammeModele = new HistogrammeModele(10);
		// On fabrique un histogramme de départ plus intéressant...
		// On pourra détruire ce code quand tout fonctionnera...
		for (int i = 0; i < histogrammeModele.getNombreDeValeurs(); i++) {
			histogrammeModele.setValeur(i, (i + 1) * 10);
		}
		setModele(histogrammeModele);
		setBackground(Color.WHITE);
	}

	/**
	 * @return the couleurRectangle
	 */
	public Color getCouleurRectangle() {
		return couleurRectangle;
	}

	/**
	 * @param couleurRectangle
	 *            the couleurRectangle to set
	 */
	public void setCouleurRectangle(Color couleurRectangle) {
		this.couleurRectangle = couleurRectangle;
	}

	/**
	 * @return the couleurTrait
	 */
	public Color getCouleurTrait() {
		return couleurTrait;
	}

	/**
	 * @param couleurTrait
	 *            the couleurTrait to set
	 */
	public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
	}

	public void setModele(HistogrammeModele histogrammeModele) {
		if (this.modele != null) {
			// On se déconnecte de l'ancien modèle...
			this.modele.supprimerHistogrammeListener(this.listener);
		}
		// à compléter... cette méthode est assez simple à écrire, mais
		// c'est pour être sûr que vous suivez.
		this.modele = histogrammeModele;
		if (this.modele != null) {
			this.modele.ajouterHistogrammeListener(this.listener);
		}
	}

	/**
	 * Retourne le modèle associé à ce composant graphique.
	 * 
	 * @return
	 */
	public HistogrammeModele getModele() {
		return modele;
	}

	@Override
	public Dimension getPreferredSize() {
		// calculez la taille de votre histogramme (longueur et largeur)
		// la histograme s'adapte à la taille de l'affichage
		return new Dimension(200, 500);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// à compléter...
		Color originalColor = g.getColor();
		g.setColor(couleurRepaire);
		int width = this.getWidth();
		int height = this.getHeight();

		int x1 = espaceHorizontal;
		int y1 = 0;
		int x2 = x1;
		int y2 = height - espaceVertical;
		// axe verticale repaire rouge
		g.drawLine(x1, y1, x2, y2);

		x1 = espaceHorizontal;
		y1 = height - espaceVertical;
		x2 = width;
		y2 = y1;
		// axe horizontale repaire rouge
		g.drawLine(x1, y1, x2, y2);

		g.setColor(couleurTrait);
		double maxHisto = this.modele.getMax();
		int nbBarres = this.modele.getNombreDeValeurs();
		double largeurBarre = 1.0 * (width - 2 * espaceHorizontal) / nbBarres;
		double scale = 1.0 * (height - 2 * espaceVertical) / maxHisto;
		for (int i = 0; i < nbBarres; i++) {
			int x = (int) (espaceHorizontal + Math.round(i * largeurBarre));
			int heightRect = (int) (this.modele.getValeur(i) * scale);
			int y = height - espaceVertical - heightRect;
			int widthRect = (int) (espaceHorizontal + Math.round((i + 1) * largeurBarre)) - x;
			// colorer les barres
			g.setColor(couleurRectangle);
			g.fillRect(x, y, widthRect, heightRect);
			// desiner les bordures des barres
			g.setColor(couleurTrait);
			g.drawRect(x, y, widthRect, heightRect);
		}
		g.setColor(originalColor);
	}

	/**
	 * Classe interne fournissant un listener pour voir ce que fait un histogramme.
	 * 
	 * @author rosmord
	 *
	 */
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
