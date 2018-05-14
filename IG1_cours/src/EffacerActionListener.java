// Association d'une action à un bouton

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
