// Classes internes (pour les ActionListener)

package Calculette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Application

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculetteApplication2 {

	// on déclare des Listener comme classes internes pour avoir accès direct au
	// méthodes et variables d'instance de la
	// classe englobante (effacer, ajouter).
	// Un obj. de la classe interne a un lien implicite avec l'objet de la classe
	// englobante qui l'a créé
	class EffacerInterne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			effacer(); //Appelle la méthode effacer de CalculetteApplication2
		}
	}

	class AjouterInterne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ajouter(); //Appelle la méthode ajouter de CalculetteApplication2
		}
	}

	private JPanneauCalculette ui;
	private double somme; // modèle (les données sur lequelles on travaille)

	public CalculetteApplication2() {
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
		ui.getAjouterButton().addActionListener(new AjouterInterne());
		ui.getEffacerButton().addActionListener(new EffacerInterne());
	}
}
