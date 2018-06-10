// Classes internes anonymes (pour les ActionListener). 
//Pas beau mais pratique quand la méthode à ajouter est très courte

package Calculette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Application

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculetteApplication3 {

	private JPanneauCalculette ui;
	private double somme; // modèle (les données sur lequelles on travaille)

	public CalculetteApplication3() {
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

	// on crée un nouveau objet ActionListener, sans le nommer, dirrectement dans la
	// méthode qui va l'appeller. Usage unique. Illisible. C'est une classe interne
	// (ajouter() = méthode la CalculetteApplication3
	private void activer() {
		ui.getAjouterButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ajouter();
			}
		});
		
		ui.getEffacerButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				effacer();
			}
		});
	}
}
