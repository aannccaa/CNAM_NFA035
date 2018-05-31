package exempleGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TextDemo extends JPanel {

	public TextDemo() {
		setBackground(Color.WHITE);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		g.setColor(Color.BLUE);
		g.setFont(new Font("Serif", Font.ITALIC, 48));
		g.drawString("Bonjour tout le monde!", 10, 100);
		g.setColor(Color.RED);
		g.drawLine(0, 100, 600, 100);
		g.drawLine(10, 0, 10, 300);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.add(new TextDemo());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});
	}
}
