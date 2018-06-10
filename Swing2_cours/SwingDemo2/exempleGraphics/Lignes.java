package exempleGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Lignes extends JPanel {


	public Lignes() {
		setBackground(Color.WHITE);
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		for (int i= 0; i < 30; i++) {
			g.drawLine(50 + i* 10, 50, 1000 + i* 10, 1000);
		}
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame= new JFrame();
				frame.add(new Lignes());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}
}
