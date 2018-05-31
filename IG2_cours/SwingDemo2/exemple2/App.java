package exemple2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class App {
	private JFrame frame;
	private CarreAvecRond2 monObjet;
	private JButton choisirCouleurBouton;
	private JButton droiteBouton;
	private JButton gaucheBouton;
	private JButton hautButton;
	private JButton basButton;
	private JButton xButton;
	private JButton yButton;


	public App() {
		createControls();
		activer();
		mettreEnPage();
	}

	private void createControls() {
		frame = new JFrame("Carré avec rond 2, le retour de la vengeance");
		monObjet = new CarreAvecRond2();
		choisirCouleurBouton = new JButton("couleur");
		droiteBouton = new JButton("droite");
		gaucheBouton = new JButton("gauche");
		hautButton = new JButton("haut");
		basButton = new JButton("bas");
		xButton = new JButton("x");
		yButton = new JButton("y");		
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
		toolBar.add(xButton);
		toolBar.add(yButton);


		panel.add(monObjet, BorderLayout.CENTER);
		panel.add(toolBar, BorderLayout.WEST);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void activer() {
		ActionListener xyActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton)e.getSource();
				executeXYAction(button);
				
			}
		};
		xButton.addActionListener(xyActionListener);
		ActionListener yListener = EventHandler.create(ActionListener.class, this, "executeXYAction", "source");
		yButton.addActionListener(yListener);
		choisirCouleurBouton.addActionListener(EventHandler.create(ActionListener.class, this, "choisirCouleur"));
		droiteBouton.addActionListener(EventHandler.create(ActionListener.class, this, "droite"));
		gaucheBouton.addActionListener(EventHandler.create(ActionListener.class, this, "gauche"));
		hautButton.addActionListener(EventHandler.create(ActionListener.class, this, "haut"));
		basButton.addActionListener(EventHandler.create(ActionListener.class, this, "bas"));

	}
	public void executeXYAction(Object button) {
		JOptionPane.showMessageDialog(frame, ((JButton) button).getText());
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
