

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Version avec classes internes anonymes
 * 
 * @author rosmord
 * 
 */
public class CalculetteApplication3 {

	private JPanneauCalculette ui;
	// modèle ! (impressionnant, non ?)
	private double somme;

	public CalculetteApplication3() {
		ui = new JPanneauCalculette();
		activer();
		// Comportement à la fermeture de la fenêtre :
		// l'application s'arrête...
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// On rend la fenêtre visible.
		ui.setVisible(true);
	}

	/**
	 * Assigne un fonctionnement aux méthodes...
	 */
	private void activer() {
		ui.getAjouterButton().addActionListener(
				new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						ajouter();
					};
				} 
				);
				
		ui.getEffacerButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				effacer();
			}
		});
	}

	void setSomme(double somme) {
		this.somme = somme;
		ui.getResultatField().setText("" + somme);
	}

	public void ajouter() {
		double val = Double.parseDouble(ui.getNombre1Field().getText());
		setSomme(somme + val);
	}

	public void effacer() {
		ui.getNombre1Field().setText("0");
		setSomme(0.0);
	}
}
