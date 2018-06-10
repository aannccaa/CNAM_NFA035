/*
Question 3
Modifiez le programme pr ́ec ́edent en ajoutant un second bouton, qui lui, devra permettre 
de passer le texte en minuscules.
 */

package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class Q3_app {
	private Q3_ui ui; // view

	public Q3_app() {
		this.ui = new Q3_ui();
		activate();
	}

	public void activate() {

		ActionListener transfMajuscules = new ActionListener() {
			// classe interne anonyme qui écoute un ActionEvent pour déclancher une méthode
			@Override
			public void actionPerformed(ActionEvent e) {
				doUpperCase();
			}			
		};
		// associe un listener au boutton pour l'action d'apuyer
		this.ui.getButtonUppercase().addActionListener(transfMajuscules);
		
		ActionListener transfMinuscules = new ActionListener() {
			// classe interne anonyme qui écoute un ActionEvent pour déclancher une méthode
			@Override
			public void actionPerformed(ActionEvent e) {
				doLowerCase();
			}			
		};
		// associe un listener au boutton pour l'action d'apuyer
		this.ui.getButtonLowercase().addActionListener(transfMinuscules);
	
	}
	

	public void doChangeCase(boolean upperCase) {
		String text = this.ui.getTextField().getText();
		if (text != null) {
			if (upperCase) {
				text = text.toUpperCase();
			} else {
				text = text.toLowerCase();
			}
			this.ui.getTextField().setText(text);
		}
	}
	
	private void doUpperCase() {
		this.doChangeCase(true);	
	}
	
	private void doLowerCase() {
		this.doChangeCase(false);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Q3_app app = new Q3_app();
			}
		});
	}

}
