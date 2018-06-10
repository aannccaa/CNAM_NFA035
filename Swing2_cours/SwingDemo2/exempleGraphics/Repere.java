package exempleGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Repere extends JPanel {


	public Repere() {
		setBackground(Color.WHITE);
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		Color old= g.getColor();
		for (int i= 0; i < 30; i++) {
			g.setColor(new Color((i*100)/30+155, 100, 100));
			g.drawLine(50 + i* 10, 50, 1000 + i* 10, 1000);
		}
		g.setColor(old);
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame= new JFrame();
				frame.add(new Repere());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}
}
