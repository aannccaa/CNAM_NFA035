/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d01Texte;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Application de démonstration pour la manipulation des modèles de texte.
 *
 * @author rosmord
 */
public class Main {

	JFormulaireSecret demo;

	public Main() {
		// Création des objets
		demo = new JFormulaireSecret();
		// Configuration des champs
		demo.getAffichageField().setEditable(false);
		// Mise en place du DocumentListener (par getDocument().addDocumentListener)
		demo.getMonChampTexte().getDocument().addDocumentListener(new MonDocListener(demo));
		// On rend le tout visible.
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main());
	}
}
