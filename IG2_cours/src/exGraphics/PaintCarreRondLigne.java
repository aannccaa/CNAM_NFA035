package exGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintCarreRondLigne extends JPanel {

	public PaintCarreRondLigne() {
		setBackground(Color.WHITE);
	}

	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// on stoque la couleur par défault
		Color ancienne = g.getColor();
		g.setColor(Color.RED);
		// desinner un rectangle plein
		g.fillRect(0, 0, 100, 100);
		this.setBackground(Color.YELLOW);
		g.clearRect(3, 10, 70, 80);
		g.setColor(new Color(100, 255, 100));//vert clair
		g.drawLine(0, 0, 300, 300);
		// dessiner un rond
		g.fillOval(200, 100, 100, 100);
		// on remet la couleur par default
		g.setColor(ancienne);
		//dessiner un ovale dans la couleur par défaut (noir)
		g.fillOval(400, 200, 50, 70);
		
		//hachurer un romb
		for(int i=0; i<30; i++) {
			g.drawLine(50 + i*10, 50, 200 + i*10,  200);
		}
		// dessiner un rectangle (contour)
		g.drawRect(250, 300, 50, 80);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.add(new PaintCarreRondLigne());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

		});

	}

}
