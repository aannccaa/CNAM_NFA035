package ex3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class App {

	private JFrame frame = new JFrame("Carré avec rond");
	private CarreAvecRond3 monObjet = new CarreAvecRond3();
	private JButton choisirCouleurBouton = new JButton("couleur");
	private JButton droiteBouton = new JButton("droite");
	private JButton gaucheBouton = new JButton("gauche");
	private JButton hautBouton = new JButton("haut");
	private JButton basBouton = new JButton("bas");

	public App() {
		activer();
		mettreEnPage();
	}

	private void activer() {
		choisirCouleurBouton.addActionListener(EventHandler.create(ActionListener.class, this, "choisirCouleur"));
		droiteBouton.addActionListener(EventHandler.create(ActionListener.class, this, "droite"));
		gaucheBouton.addActionListener(EventHandler.create(ActionListener.class, this, "gauche"));
		hautBouton.addActionListener(EventHandler.create(ActionListener.class, this, "haut"));
		basBouton.addActionListener(EventHandler.create(ActionListener.class, this, "bas"));
	}
	
	private void choisirCouleur() {
		Color newColor = JColorChooser.showDialog(frame, "Choisir la couleur du dessin", monObjet.getForeground());
		monObjet.setCouleurCercle(newColor);
	}
	
	private void droite() {
		monObjet.setCentreX(monObjet.getCentreX() + 10);
	}
	
	private void gauche() {
		monObjet.setCentreX(monObjet.getCentreX() - 10);
	}
	
	private void bas() {
		monObjet.setCentreY(monObjet.getCentreY() + 10); // axe y valeurs croissantes vers le bas
	}
	
	private void haut() {
		monObjet.setCentreY(monObjet.getCentreY() - 10); // axe y valeurs decroissantes vers le haut
	}
	
	

	private void mettreEnPage() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.add(choisirCouleurBouton);
		toolBar.add(gaucheBouton);
		toolBar.add(droiteBouton);
		toolBar.add(hautBouton);
		toolBar.add(basBouton);

		JScrollPane scrollPane = new JScrollPane(monObjet);
		panel.add(scrollPane);
		panel.add(toolBar, BorderLayout.WEST);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new App();
			}

		});

	}
}
