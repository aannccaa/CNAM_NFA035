import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CarreAvecRond3 extends JPanel {
	private int centreX = 10;
	private int centreY = 10;
	private int rayon = 30;
	private Color couleurCercle = Color.BLUE; // ca peut être enlevé si on utilise un foregroundColor

	public int getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		if (centreX < rayon)
			return;
		this.centreX = centreX;
		// redessiner l'objet
		repaint();
		// informer que l'objet puisse préciser au composant qui le contienne que la
		// taille qu'il aimerait
		// avoir a été modifé
		revalidate();
	}

	public int getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		if (centreY < rayon)
			return;
		this.centreY = centreY;
		repaint();
		revalidate();
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		if (rayon > centreX || rayon > centreY) {
			return;
		}
		this.rayon = rayon;
		repaint();
		revalidate();
	}

	public Color getCouleurCercle() {
		return couleurCercle;
	}

	public void setCouleurCercle(Color couleurCercle) {
		this.couleurCercle = couleurCercle;
		repaint();
	}

	// si la classe aurait étendue JComponent,
	// on aurait eu un fond gris, en étendant JPanel
	// on peut utiliser sa méthode setBackground()
	public CarreAvecRond3() {
		setBackground(Color.GREEN);
		// si on decommente il va remplacer la variable couleur cercle
		// setForeground(Color.YELLOW);
	}

	public Dimension getPreferredSize() {
		int w = Math.max(300, centreX + rayon);
		int h = Math.max(300, centreY + rayon);
		return new Dimension(w, h);
	}

	protected void paintComponent(Graphics g) {
		// effacement de l'ancien dessin:
		// supper designe la classe parente donc JPanel,
		// qui commence aussi par un appel super.paintComponent(g)
		// qui va appeller le paintComponent de JComponent
		super.paintComponent(g); // si on comment cette ligne, le fond devient gris (plus dessiné par JPanel)
		// on fixe la couleur pour dessiner,
		// cette méthode aurait pu ne pas étre appellé
		// si on aurait utilisé setForeground():
		g.setColor(couleurCercle);
		// on desine un cercle:
		g.fillOval(centreX - rayon, centreY - rayon, rayon * 2, rayon * 2);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.add(new CarreAvecRond3());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

		});

	}

}
