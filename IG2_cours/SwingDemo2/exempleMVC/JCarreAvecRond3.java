package exempleMVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Un objet graphique. On "observe" ce qui se produit sur notre modèle.
 *
 * (Noter qu'on obtiendra une meilleure structure en utilisant une classe
 * interne pour implanter l'observateur {@link CarreAvecRondModeleListener}, ce
 * qui évitera d'avoir les méthodes de l'interface publique).
 * 
 * @author rosmord
 */
@SuppressWarnings("serial")
public class JCarreAvecRond3 extends JPanel implements CarreAvecRondModeleListener {

	private CarreAvecRondModele modele;

	/**
	 * Listener pour le modèle.
	 */

	/**
	 * Appelée quand le modèle est modifié.
	 */
	@Override
	public void modeleModifie() {
		repaint();
		revalidate();
		// Note: dans une version plus avancée du système,
		// on pourrait passer un "événement" au listener,
		// celui-ci permettrait de décrire plus précisément ce qui
		// s'est passé (voir ActionEvent par exemple), afin de
		// savoir s'il faut appeler repaint ET revalidate.
	}

	public JCarreAvecRond3() {
		setModele(new CarreAvecRondModele());
		setBackground(Color.WHITE);
	}

	public CarreAvecRondModele getModele() {
		return this.modele;
	}

	public void setModele(CarreAvecRondModele modele) {
		// Si on observe déjà un ancien modèle, on
		// se désabonne...
		if (this.modele != null) {
			this.modele.removeModeleListener(this);// this represente le JCarreAvecRond, qui implemente l'interface
													// CarreAvecRondModeleListener qui va appeler la méthode
													// modeleModifie() quand
													// le modèle est modifié
		}
		// on s'inscrit auprès du nouveau modèle pour qu'il nous previenne quand il est
		// modifié
		this.modele = modele; // this.modele prend la valeur du paramètre
		modele.addModeleListener(this);// this represente le JCarreAvecRond, qui implemente l'interface
										// CarreAvecRondModeleListener qui va appeler la méthode
										// modeleModifie() quand
										// le modèle est modifié
	}

	@Override
	public Dimension getPreferredSize() {
		int w = Math.max(300, modele.getCentreX() + modele.getRayon());
		int h = Math.max(300, modele.getCentreY() + modele.getRayon());
		return new Dimension(w, h);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		g.setColor(this.modele.getCouleurCercle());
		g.fillOval(this.modele.getLeft(), this.modele.getTop(), this.modele.getDiametre(), this.modele.getDiametre());
	}

	public void setCouleurCercle(Color couleurCercle) {
		this.modele.setCouleurCercle(couleurCercle); // le repaint sera appelé indirectement par l'appel de
												// modele.setCouleurCercle()
	}

	public void setCentreX(int centreX) {
		this.modele.setCentreX(centreX);
	}

	public void setCentreY(int centreY) {
		this.modele.setCentreY(centreY);
	}

	public void setRayon(int rayon) {
		this.modele.setRayon(rayon);
	}

	public int getCentreX() {
		return this.modele.getCentreX();
	}

	public int getCentreY() {
		return this.modele.getCentreY();
	}

}
