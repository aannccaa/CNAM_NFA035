package CalculetteCata;
// Association d'une action au bouton Effacer

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EffacerActionListener implements ActionListener{
	private final CalculetteController calculetteController;
	
	public EffacerActionListener(CalculetteController calculetteApplication) {
		this.calculetteController = calculetteApplication;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.calculetteController.effacer();		
	}

}
