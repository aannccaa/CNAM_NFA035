package exemple1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CarreAvecRond extends JPanel {

	private int centreX = 40, centreY = 40, rayon = 30;
	private Color couleurCercle= Color.BLUE;

	public CarreAvecRond() {
		setBackground(Color.WHITE);
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		g.setColor(couleurCercle);
		g.fillOval(centreX -rayon, centreY - rayon, rayon*2, rayon*2);
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame= new JFrame();
				CarreAvecRond comp = new CarreAvecRond();
				frame.add(comp);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}
}
