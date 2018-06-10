package mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CerclesEtSouris extends JPanel {

	private ArrayList<Cercle> cercles;
	
	public CerclesEtSouris() {
		setBackground(Color.WHITE);
		// Initialisation des données
		cercles= new ArrayList<Cercle>();
		cercles.add(new Cercle(this, 100, 100, 40));
		Cercle autre= new Cercle(this, 200, 200, 30);
		autre.setColor(Color.RED);
		cercles.add(autre);
		// On crée le listener :
		DeplacementListener listener= new DeplacementListener();
		// Ne pas oublier de l'ajouter comme listener
		addMouseListener(listener);
		addMouseMotionListener(listener);		
	}	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Laisser cette méthode ici.
		Color old= g.getColor();
		for (Cercle c: cercles) {
			c.draw(g);
		}
		g.setColor(old);
	}

	
	private class DeplacementListener extends MouseAdapter {
		/**
		 * Le cercle actuellement sélectionné.
		 */
		
		private Cercle cercleSelectionne= null;
		
		/**
		 * Les derniers x et y enregistrés (nécessaires pour connaître 
		 * le déplacement de la souris). 
		 */
		private int lastX, lastY;
		
		@Override
		public void mousePressed(MouseEvent e) {
			cercleSelectionne= null;
			// où clique-t-on ?
			Point p= e.getPoint();
			for (Cercle c: cercles) {
				if (c.contientPoint(p)) {
					cercleSelectionne= c;					
				}
			}
			lastX= p.x;
			lastY= p.y;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			cercleSelectionne= null;
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {	
			if (cercleSelectionne!= null) {
				Point p= e.getPoint();
				int dx= p.x - lastX; //p.x = position actuelle de la souris
				int dy= p.y - lastY;
				cercleSelectionne.setX(cercleSelectionne.getX() + dx);
				cercleSelectionne.setY(cercleSelectionne.getY() + dy);
				lastX= p.x;
				lastY= p.y;
			}
		}
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame= new JFrame();
				frame.add(new CerclesEtSouris());
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}
}
