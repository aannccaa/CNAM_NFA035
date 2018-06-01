package exGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageBox extends JPanel {
	Image image;

	public ImageBox() {
		setBackground(Color.WHITE);
	}

	public void setImage(Image image) {
		this.image = image;
		this.invalidate();
	}

	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.image != null) {
			int w = image.getWidth(null);
			int h = image.getHeight(null);
			g.drawImage(image, 0, 0, null);
			// double scale = Math.min(1.0*this.getWidth()/w, 1.0*this.getHeight()/h);
			// g.drawImage(image, 0, 0, (int) Math.round(scale*w), (int)
			// Math.round(scale*h), null);

			g.drawImage(this.image, 0, 0, null);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFileChooser fc = new JFileChooser();
				Image img = null;
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						img = ImageIO.read(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				JFrame frame = new JFrame("Image");
				ImageBox imageBox = new ImageBox();
				imageBox.setImage(img);
				frame.add(imageBox);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

}
