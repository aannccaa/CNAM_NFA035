package exempleGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PolygonesDemo extends JPanel {

	public PolygonesDemo() {
		setBackground(Color.WHITE);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		g.setColor(Color.BLUE);
		Polygon poly= new Polygon();
		poly.addPoint(100, 100);
		poly.addPoint(200, 200);
		poly.addPoint(150, 250);
		poly.addPoint(200, 30);
		poly.addPoint(100, 30);		
		g.drawPolygon(poly);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.add(new PolygonesDemo());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});
	}
}
