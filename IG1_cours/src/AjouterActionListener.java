// Association d'une action au bouton Ajouter

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterActionListener implements ActionListener {
	private final CalculetteApplication calculetteApplication;

	public AjouterActionListener(CalculetteApplication calculetteApplication) {
		this.calculetteApplication = calculetteApplication;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.calculetteApplication.ajouter();
	}

}
