package d05MvpActions.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import d05MvpActions.PersonnesPresentateur;

public class SuivantAction extends AbstractAction {
	public static final String ID = "SUIVANT";
	PersonnesPresentateur presentateur;

	public SuivantAction(PersonnesPresentateur presentateur) {
		super("Suivant");
		this.presentateur= presentateur;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control n"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		presentateur.suivant();
	}

}