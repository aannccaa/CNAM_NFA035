package ex4Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Polylignes extends JPanel {

	public Polylignes() {
		setBackground(Color.WHITE);
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		int[] xPoints = { 100, 10, 34, 100, 150, 200, 30, 10 };
		int[] yPoints = { 100, 40, 200, 60, 0, 89, 200, 300 };
		int nPoints = xPoints.length;
		g.drawPolygon(xPoints, yPoints, nPoints);
	}
	
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("Poly lignes");
				frame.add(new Polylignes());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		});
	}

}
