

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class EffacerActionListener implements ActionListener {
	/**
	 * 
	 */
	private final CalculetteApplication calculetteApplication;

	/**
	 * @param calculetteApplication
	 */
	EffacerActionListener(CalculetteApplication calculetteApplication) {
		this.calculetteApplication = calculetteApplication;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		calculetteApplication.effacer();
	}
}

