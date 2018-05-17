package CalculetteCata;
// Association d'une action au bouton Ajouter

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterActionListener implements ActionListener {
	private final CalculetteController calculetteController;

	public AjouterActionListener(CalculetteController calculetteApplication) {
		this.calculetteController = calculetteApplication;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.calculetteController.ajouter();
	}

}
