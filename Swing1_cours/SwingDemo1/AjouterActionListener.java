

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterActionListener implements ActionListener {
	
	private final CalculetteApplication calculetteApplication;

	/**
	 * @param calculetteApplication
	 */
	public AjouterActionListener(CalculetteApplication calculetteApplication) {
		this.calculetteApplication = calculetteApplication;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.calculetteApplication.ajouter();
	}
}