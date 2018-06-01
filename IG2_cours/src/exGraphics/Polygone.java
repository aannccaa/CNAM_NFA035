package exGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Polygone extends JPanel{

	public Polygone() {
		setBackground(Color.YELLOW);
	}
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Polygon poly = new Polygon();
		poly.addPoint(100, 100);
		poly.addPoint(200, 200);
		poly.addPoint(300, 150);
		poly.addPoint(200, 30);
		poly.addPoint(100, 40);
		g.drawPolygon(poly);
		//g.fillPolygon(poly);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("Polygones");
				frame.add(new Polygone());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		});
	}
}
