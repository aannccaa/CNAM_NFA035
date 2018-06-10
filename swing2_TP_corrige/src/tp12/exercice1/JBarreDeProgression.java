package tp12.exercice1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JBarreDeProgression extends JPanel {
	private int valeur; // Entre 0 et 100 !!
	private Color textColor= Color.RED;
	private Color barColor= Color.YELLOW;
	
	public JBarreDeProgression() {
		setBackground(Color.GRAY);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 60);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color old= g.getColor();
		g.setColor(barColor);
		int w = (getWidth() * valeur) / 100;
		g.fillRect(0, 0, w, getHeight());
		g.setColor(textColor);
		g.drawString(valeur+ " %",getWidth()/2, getHeight()/2);
		g.setColor(old);
	}

	public void setValeur(int valeur) {
		if (this.valeur >= 0 && this.valeur <= 100) {
			this.valeur = valeur;
			repaint();
		}
	}
	
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
		repaint();
	}
	
	public void setBarColor(Color barColor) {
		this.barColor = barColor;
		repaint();
	}
}
