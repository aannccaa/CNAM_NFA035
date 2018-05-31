package exempleGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Couleurs extends JPanel {


	public Couleurs() {
		setBackground(Color.WHITE);
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Color ancienne= g.getColor();
		g.setColor(Color.RED);
		g.fillRect(0, 0, 100, 100);
		g.setColor(new Color(100,255,100));
		g.drawLine(0, 0, 300, 300);
		g.fillOval(200, 100, 100, 100);
		g.setColor(ancienne);
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame= new JFrame();
				frame.add(new Couleurs());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}
}
