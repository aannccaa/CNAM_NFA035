/*
Question 2
E ́crire un petit programme avec :
— un champ texte ;
— un bouton;
Quand on presse le bouton, le texte dans le champ texte doit passer en majuscules. 
(ne vous fatiguez pas
`a essayer de s ́eparer le mod`ele de l’application).
 */

package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;


public class Q2_app {
	private Q2_ui ui; // view
	
	public Q2_app() {
		this.ui = new Q2_ui();
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
		//associe un listener au boutton pour l'action d'apuyer
		this.ui.getButtonUppercase().addActionListener(transfMajuscules);
	}

	public void doUpperCase() {
		String text = this.ui.getTextField().getText();
		if (text != null) {
			text = text.toUpperCase();
			this.ui.getTextField().setText(text);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Q2_app app = new Q2_app();
			}
		});
	}

}
