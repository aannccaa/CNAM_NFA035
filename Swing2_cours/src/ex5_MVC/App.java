package ex5_MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.management.RuntimeErrorException;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class App {
	private JFrame frame;
	private JButton choisirCouleurBouton;
	private JButton hautBouton;
	private JButton basBouton;
	private JButton gaucheBouton;
	private JButton droiteBouton;
	private JToolBar toolBar;
	private JCarreAvecRond3 monObjet;
	private JCarreAvecRond3 copieMonObjet;

	public App() {
		createControles();
		this.copieMonObjet.setModele(this.monObjet.getModele());
		activate();
		mettreEnPage();
	}

	public void createControles() {
		frame = new JFrame("Carre avec rond 3");
		monObjet = new JCarreAvecRond3();
		copieMonObjet = new JCarreAvecRond3();
		choisirCouleurBouton = new JButton("chosir couleur");
		hautBouton = new JButton("en haut");
		basBouton = new JButton("en bas");
		droiteBouton = new JButton("à droite");
		gaucheBouton = new JButton("à gauche");
	}

	private void mettreEnPage() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.add(choisirCouleurBouton);
		toolBar.add(droiteBouton);
		toolBar.add(gaucheBouton);
		toolBar.add(hautBouton);
		toolBar.add(basBouton);

		panel.add(new JScrollPane(this.monObjet), BorderLayout.CENTER);
		panel.add(new JScrollPane(this.copieMonObjet), BorderLayout.EAST);

		panel.add(toolBar, BorderLayout.WEST);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void activate() {
//		 ActionListener listener = new ActionListener() {
//		
//		 @Override
//		 public void actionPerformed(ActionEvent e) {
//		 // on obtient le bouton
//		 JButton bouton = (JButton) e.getSource();
//		 // en fonction de son texte on fait une action
//		 switch (bouton.getText()) {
//		 case "choisirCouleurBouton":
//		 choisirCouleur();
//		 break;
//		 case "droiteBouton":
//		 droite();
//		 break;
//		 case "gaucheBouton":
//		 gauche();
//		 break;
//		 case "en haut":
//		 haut();
//		 break;
//		 case "bas":
//		 bas();
//		 break;
//		 default:
//		 throw new RuntimeException();
//		 }
//		
//		 bouton.addActionListener(listener);
//		 
//		 }
//		 };
		choisirCouleurBouton.addActionListener(EventHandler.create(ActionListener.class, this, "choisirCouleur"));
		hautBouton.addActionListener(EventHandler.create(ActionListener.class, this, "haut"));
		basBouton.addActionListener(EventHandler.create(ActionListener.class, this, "bas"));
		gaucheBouton.addActionListener(EventHandler.create(ActionListener.class, this, "gauche"));
		droiteBouton.addActionListener(EventHandler.create(ActionListener.class, this, "droite"));
	}

	public void choisirCouleur() {
		Color newColor = JColorChooser.showDialog(frame, "Choisir la couleur", monObjet.getCouleurCercle());
		monObjet.setCouleur(newColor);
	}

	public void droite() {
		monObjet.setCenterX(monObjet.getCentreX() + 10);
	}

	public void gauche() {
		monObjet.setCenterX(monObjet.getCentreX() - 10);
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
