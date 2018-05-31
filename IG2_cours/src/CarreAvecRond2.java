import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CarreAvecRond2 extends JPanel {
	private int centreX = 10;
	private int centreY = 10;
	private int rayon = 30;
	private Color couleurCercle = Color.BLUE; // ca peut être enlevé si on utilise un foregroundColor

	public int getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		this.centreX = centreX;
		repaint();
	}

	public int getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		this.centreY = centreY;
		repaint();
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
		repaint();
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
	public CarreAvecRond2() {
		setBackground(Color.GREEN);
		//si on decommente il va remplacer la variable couleur cercle
		//setForeground(Color.YELLOW);
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
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
			frame.add(new CarreAvecRond2());
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			
		});

	}

}
