import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// Fenêtre graphique

import java.awt.Container;

import javax.swing.*;

public class JPanneauCalculette extends JFrame{
	private JTextField nombre1Field;
	private JTextField resultatField;
	private JButton ajouterButton;
	private JButton effacerButton;
	
	public JPanneauCalculette() {
		this.nombre1Field = new JTextField(10);
		this.resultatField = new JTextField(10);
		this.resultatField.setEditable(false); // pas modifiable
		this.ajouterButton = new JButton("+");
		this.effacerButton = new JButton("effacer");
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
