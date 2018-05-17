package Calculette;
// Fenêtre graphique

import java.awt.Container;
import javax.swing.*;

public class JPanneauCalculette extends JFrame{
	private JTextField nombre1Field; // champ dans lequel on introduit un nombre
	private JTextField resultatField; // champ readlonly dans lequel on calcule le résultat
	private JButton ajouterButton; // bouton pour faire des aditions
	private JButton effacerButton; // bouton pour remettre à 0 les champs
	
	public JPanneauCalculette() {
		this.nombre1Field = new JTextField(10); // champ de 10 charactères
		this.resultatField = new JTextField(10);
		this.resultatField.setEditable(false); // pas modifiable
		this.ajouterButton = new JButton("+"); // bouton nommé "+"
		this.effacerButton = new JButton("effacer"); // bouton nommé "effacer"
		mettreEnPage();
	}
	
	private void mettreEnPage() {
		// on récupère le conteneur interne de la frame
		Container panel = this.getContentPane();
		// on fixe le layout: on va empiler les composants sur la verticale de la page
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(boxLayout);
		panel.add(nombre1Field);
		panel.add(ajouterButton);
		panel.add(resultatField);
		panel.add(effacerButton);
		// on fixe la taille de la frame:
		this.pack();
	}

	public JTextField getNombre1Field() {
		return this.nombre1Field;
	}
	
	public JTextField getResultatField() {
		return this.resultatField;
	}
	
	
	public JButton getAjouterButton() {
		return this.ajouterButton;
	}
	
	public JButton getEffacerButton() {
		return this.effacerButton;
	}
}
