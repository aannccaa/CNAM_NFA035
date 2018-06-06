package tp12.exercice2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Un objet sachant afficher un histogramme.
 * (vous êtes libre de faire ce que vous voulez, mais les variables d'instances proposées 
 * sont un point de départ utile).
 * @author rosmord
 *
 */
@SuppressWarnings("serial")
public class JHistogramme extends JPanel {
	private HistogrammeModele modele;
	
	/**
	 * Le listener qui va déclencher le dessin de l'objet quand l'histogramme est modifié
	 * est une classe interne.
	 * <p> Intérêt : on ne le voit pas de l'extérieur.
	 * Personne n'a besoin de connaître cet objet.
	 */
	private MonHistoListener listener;
	
	/**
	 * épaisseur des barres de l'histogramme.
	 */
	private int largeurBarre = 30;
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
		// On pourra détruire ce code quand tout fonctionnera...
		for (int i = 0; i < histogrammeModele.getNombreDeValeurs(); i++) {
			histogrammeModele.setValeur(i, (i+1)* 10);
		}
		setModele(histogrammeModele);
		setBackground(Color.WHITE);
	}

	public void setModele(HistogrammeModele histogrammeModele) {
		if (this.modele != null) {
			// On se déconnecte de l'ancien modèle...
			this.modele.supprimerHistogrammeListener(listener);
		}
		// à compléter... cette méthode est assez simple à écrire, mais 
		// c'est pour être sûr que vous suivez.
	}

	/**
	 * Retourne le modèle associé à ce composant graphique.
	 * @return
	 */
	public HistogrammeModele getModele() {
		return modele;
	}

	@Override
	public Dimension getPreferredSize() {
		// calculez la taille de votre histogramme (longueur et largeur)
		return null;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// à compléter...
	}


	/**
	 * Classe interne fournissant un listener pour voir ce que fait un histogramme.
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
