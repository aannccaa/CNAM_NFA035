package CalculetteCata;
// Association d'une action au bouton Ajouter

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class SyncInputActionListener implements FocusListener {
	private final CalculetteController calculetteController;

	public SyncInputActionListener(CalculetteController calculetteApplication) {
		this.calculetteController = calculetteApplication;
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() instanceof JTextField) {
			JTextField input = (JTextField) e.getSource();
			String texte = input.getText();
			this.calculetteController.setInput(texte);
		}
	}
}
