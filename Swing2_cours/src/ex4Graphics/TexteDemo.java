package ex4Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TexteDemo extends JPanel{
	
	public TexteDemo() {
		setBackground(Color.WHITE);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(500, 300);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Serif", Font.ITALIC, 48));
		g.drawString("Bonjour tout le monde!", 10, 100);
		g.setColor(Color.RED);
		g.drawLine(10, 100, 500, 100); // surlignage
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new JFrame("Draw String");
				frame.add(new TexteDemo());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

}
