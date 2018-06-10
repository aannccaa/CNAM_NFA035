package Calculette;
// Association d'une action au bouton Effacer

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EffacerActionListener implements ActionListener{
	private final CalculetteApplication calculetteApplication;
	
	public EffacerActionListener(CalculetteApplication calculetteApplication) {
		this.calculetteApplication = calculetteApplication;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.calculetteApplication.effacer();		
	}

}
