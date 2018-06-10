

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculetteApplication {

	private JPanneauCalculette ui;
	// modèle ! (impressionnant, non ?)
	private double somme;

	public CalculetteApplication() {
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
		ui.getAjouterButton()
				.addActionListener(
						new AjouterActionListener(this));
		ui.getEffacerButton()
				.addActionListener(new EffacerActionListener(this));
	}

	void setSomme(double somme) {
		this.somme = somme;
		ui.getResultatField().setText("" + somme);
	}

	public void ajouter() {
		JTextField champ = ui.getNombre1Field();
		String texte = champ.getText();
		double val = Double.parseDouble(texte);
		setSomme(somme + val);
	}

	public void effacer() {
		JTextField champTexte = ui.getNombre1Field();
		champTexte.setText("0");
		setSomme(0.0);
	}
}
