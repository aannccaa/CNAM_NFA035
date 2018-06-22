package actionDemo.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import actionDemo.PersonnesPresentateur;

public class PrecedentAction extends AbstractAction {
	public static final String ID = "PRECEDENT";
	PersonnesPresentateur presentateur;

	public PrecedentAction(PersonnesPresentateur presentateur) {
		super("Precedent");
		this.presentateur= presentateur;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control p"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		presentateur.precedent();
	}

}