package CalculetteCata;

// Application

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculetteController {

	private JPanneauCalculette ui;
	private Calculette model; // modèle (les données sur lequelles on travaille)

	public CalculetteController() {
		this.model = new Calculette();
		this.ui = new JPanneauCalculette(this);
	}
	
	public Calculette getModel() {
		return this.model;
	}
	
	public void modelChanged() {
		this.ui.actualiser();
	}
	
	// actions utilisateur
	public void ajouter() {
		this.model.ajouter();
		this.modelChanged();
	}

	public void effacer() {
		this.model.effacer();
		this.modelChanged();
	}

	public void setInput(String texte) {
		// on parse le string pour retourner un Double
		double value = Double.parseDouble(texte);
		this.model.setInput(value);
		this.modelChanged();
	}
}
