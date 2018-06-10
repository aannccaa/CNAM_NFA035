package ex1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CarreAvecRond extends JPanel {
	private int centreX = 40;
	private int centreY = 40;
	private int rayon = 30;
	private Color couleurCercle = Color.BLUE; // ca peut être enlevé si on utilise un foregroundColor

	// si la classe aurait étendue JComponent,
	// on aurait eu un fond gris, en étendant JPanel
	// on peut utiliser sa méthode setBackground()
	public CarreAvecRond() {
		setBackground(Color.GREEN);
		// si on decommente il va remplacer la variable couleur cercle
		// setForeground(Color.YELLOW);
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
				frame.add(new CarreAvecRond());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

}
