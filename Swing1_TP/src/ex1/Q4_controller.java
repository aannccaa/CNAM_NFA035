/*
Question 4
En n ́egligeant toutes les r`egles d’ergonomie, on d ́ecide d’avoir une combobox qui 
affichera “majuscules”, “minuscules”, et “effacer”, et un seul bouton “faire”.
Quand on presse le bouton, l’action s ́electionn ́ee dans le combobox doit ˆetre effectu ́ee.
 */
package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class Q4_controller {
	private Q4_model model;
	private Q4_view view;

	public Q4_controller() {
		this.model = new Q4_model();
		this.view = new Q4_view();
		this.activate();
	}

	private void activate() {
		ActionListener buttonFaireListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				synchroModelFromView();

				String comboValue = view.getTextCombo();
				// j'execute l'action en fonction de la val du combo
				switch (comboValue) {
				case "UpperCase":
					model.doUpperCase();
					break;
				case "Lowercase":
					model.doLowerCase();
					break;
				case "Effacer":
					model.effacer();
					break;
				}

				synchroViewFromModel();
			}
		};
		view.getButtonFaire().addActionListener(buttonFaireListener);
	}

	private void synchroModelFromView() {
		// je prend la val de l'écran et je la mets dans le modèle
		String text = view.getTextField().getText();// valeur de l'écran
		model.setTexte(text);
	}

	private void synchroViewFromModel() {
		String text;
		// je prend la val du modèle et je la mets dans l'écran
		text = model.getTexte(); // val du modèle
		view.getTextField().setText(text);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Q4_controller app = new Q4_controller();
			}
		});
	}

}
