package exempleMVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.*;

public class App {
	private JFrame frame = new JFrame("Carré avec rond 2, le retour de la vengeance");
	private JCarreAvecRond3 monObjet = new JCarreAvecRond3();
	// Pour montrer l'architecture MVC:
	private JCarreAvecRond3 copie = new JCarreAvecRond3();

	private JButton choisirCouleurBouton = new JButton("couleur");
	private JButton droiteBouton = new JButton("droite");
	private JButton gaucheBouton = new JButton("gauche");
	private JButton hautButton = new JButton("haut");
	private JButton basButton = new JButton("bas");

	public App() {
		copie.setModele(monObjet.getModele());
		activer();
		mettreEnPage();
	}

	private void mettreEnPage() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.add(choisirCouleurBouton);
		toolBar.add(gaucheBouton);
		toolBar.add(droiteBouton);
		toolBar.add(hautButton);
		toolBar.add(basButton);

		panel.add(new JScrollPane(monObjet), BorderLayout.CENTER);
		panel.add(new JScrollPane(copie), BorderLayout.EAST);
		panel.add(toolBar, BorderLayout.WEST);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void activer() {
		choisirCouleurBouton.addActionListener(EventHandler.create(ActionListener.class, this, "choisirCouleur")); // this represent le frame
		droiteBouton.addActionListener(EventHandler.create(ActionListener.class, this, "droite"));
		gaucheBouton.addActionListener(EventHandler.create(ActionListener.class, this, "gauche"));
		hautButton.addActionListener(EventHandler.create(ActionListener.class, this, "haut"));
		basButton.addActionListener(EventHandler.create(ActionListener.class, this, "bas"));

	}

	public void choisirCouleur() {
		Color newColor = JColorChooser.showDialog(frame, "Choisir la couleur de dessin", monObjet.getForeground());
		monObjet.setCouleurCercle(newColor);
	}

	public void droite() {
		monObjet.setCentreX(monObjet.getCentreX() + 10);
	}

	public void gauche() {
		monObjet.setCentreX(monObjet.getCentreX() - 10);
	}

	public void haut() {
		monObjet.setCentreY(monObjet.getCentreY() - 10);
	}

	public void bas() {
		monObjet.setCentreY(monObjet.getCentreY() + 10);
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
