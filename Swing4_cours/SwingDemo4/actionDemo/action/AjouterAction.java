package actionDemo.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import actionDemo.PersonnesPresentateur;

@SuppressWarnings("serial")
public class AjouterAction extends AbstractAction {
	public static final String ID = "AJOUTER";
	PersonnesPresentateur presentateur;

	public AjouterAction(PersonnesPresentateur presentateur) {
		super("Ajouter");
		this.presentateur= presentateur;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control a"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		presentateur.ajouter();
	}

}
