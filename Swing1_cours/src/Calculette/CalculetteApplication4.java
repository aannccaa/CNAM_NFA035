// EventHandler crée dynamiquement un ActionListener dans la méthode appelée

package Calculette;

// Application

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JTextField;

public class CalculetteApplication4 {

	private JPanneauCalculette ui;
	private double somme; // modèle (les données sur lequelles on travaille)
	public CalculetteApplication4() {
		ui = new JPanneauCalculette();
		// assigner un comportement au boutons
		activer();
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setVisible(true);
	}

	void setSomme(double somme) {
		this.somme = somme;
		JTextField champResultatSomme = ui.getResultatField();
		champResultatSomme.setText("" + somme);
	}

	public void ajouter() {
		JTextField champTexte = ui.getNombre1Field();
		String texte = champTexte.getText();
		// on parse le string pour retourner un Double
		double val = Double.parseDouble(texte);
		setSomme(this.somme + val);
	}

	public void effacer() {
		JTextField champTexte = ui.getNombre1Field();
		champTexte.setText("0");
		setSomme(0.0);
	}

	private void activer() {
		ActionListener ajouterActionListener = EventHandler.create(ActionListener.class, this, "ajouter");
		ui.getAjouterButton().addActionListener(ajouterActionListener);

		ActionListener effacerActionListener = EventHandler.create(ActionListener.class, this, "effacer");
		ui.getEffacerButton().addActionListener(effacerActionListener);
	}
}
