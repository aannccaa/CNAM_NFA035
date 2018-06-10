package tp12.exercice1;

/*
Exercice 1 : Un objet graphique simple
On de ́sire re ́aliser un objet graphique pour une barre de progression. 

Question 1
Modifiez la classe JBarreDeProgression pour que l’objet barre de progression affiche en rouge, 
approximativement au milieu de l’objet barre de progression, la valeur de la progression (un entier entre 
0 et 100).
Vous pourrez tester votre code avec le programme Question1.
Rappel : Outre les me ́thodes de la classe Graphics, vous pourrez utiliser les me ́thodes getWidth() et 
getHeight() de la classe JComponent, pour savoir ou` se situe le milieu de votre composant.

Question 2
Ajoutez a` ce code le dessin de la barre de progression : un rectangle bleu, dont la longueur est 
proportionnelle a` la progression (si elle est a` 100, il rempli toute la barre, si elle est a` 50, 
il en rempli la moitie ́, et enfin, si elle est a` 0, on ne voit pas de rectangle bleu.

Question 3
Lire, comprendre et tester le programme Question3. Il ne fonctionne pas comme pre ́vu.
En modifiant uniquement la classe JBarreDeProgression (et pas du tout Question3), faites fonctionner ce
programme.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JBarreDeProgression extends JPanel {
	int progression;

	/*
	 * Constructeur par défaut: crée une barre de progression à 0.
	 */
	public JBarreDeProgression() {
		super();
		this.setProgression(0);
	}

	/**
	 * Constructeur qui prend une valeur de départ pour la barre de progression.
	 */
	public JBarreDeProgression(int progression) {
		super();
		this.setProgression(progression);
	}

	/**
	 * Implantation bidon pour l'exemple.
	 * <p>
	 * Donne la taille que l'objet "a envie" d'avoir.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 100);
	}

	/**
	 * Implémentation bidon pour l'exemple.
	 * <p>
	 * Dessine une diagonale en rouge.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		String text = this.getProgression() + " %";

		

		// get metrics from the graphics
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		// get the height of a line of text in this
		// font and render context
		int textHeight = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int textWidth = metrics.stringWidth(text);
		Color initialColor = g.getColor();
		g.setColor(Color.BLUE);
		int progressionWidth = this.getProgression() * this.getWidth() / 100;
		int progressionHeight = this.getHeight();
		g.fillRect(0, 0, progressionWidth, progressionHeight);
		
		g.setColor(Color.RED);
		//int xText = (this.getWidth() - textWidth) / 2;
		int xTextWanted = progressionWidth;
		int maxXText = this.getWidth() - textWidth;
		int xText = min(xTextWanted , maxXText);
		int yText = (this.getHeight() + textHeight) / 2;
		g.drawString(text, xText, yText);
		
		g.setColor(initialColor);
	}
	private int min(int a, int b) {
		return a < b  ? a : b;
	}
	public int getProgression() {
		return this.progression;
	}

	/**
	 * Fixe la valeur de la barre de progression
	 * 
	 * @param valeur
	 *            une valeur entre 0 et 100.
	 */
	public void setProgression(int progression) {
		if (progression < 0 || progression > 100) {
			throw new RuntimeException();
		}
		this.progression = progression;
		this.repaint();
	}
}
