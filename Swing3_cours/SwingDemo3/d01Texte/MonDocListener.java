package d01Texte;
/*
La classe demo a deux champs textes, dont l’un sert à saisir un
mot de passe («secret»). On veut afficher «correct» dès que celui-ci est bon.
 */

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author rosmord
 */
class MonDocListener implements DocumentListener {

	private JFormulaireSecret demo;

	public MonDocListener(JFormulaireSecret demo) {
		this.demo = demo;
	}

	@Override
	// Gives notification that there was an insert into the document.
	public void insertUpdate(DocumentEvent e) {
		verifierMotDePasse();
	}

	@Override
	// Gives notification that a portion of the document has been removed.
	public void removeUpdate(DocumentEvent e) {
		verifierMotDePasse();
	}

	@Override
	// Gives notification that an attribute or set of attributes changed.
	public void changedUpdate(DocumentEvent e) {
		// Jamais appelée
	}

	private void verifierMotDePasse() {
		// si on a tappé "secret" dans MonChampText
		if ("secret".equals(demo.getMonChampTexte().getText())) {
			// on affiche "correct" dans AffichageField
			demo.getAffichageField().setText("correct");
		} else {
			// on affiche "incorrect" dans AffichageField
			demo.getAffichageField().setText("incorrect");
		}
	}
}
