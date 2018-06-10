

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanneauCalculette extends JFrame {
	private JTextField nombre1Field, resultatField;
	private JButton ajouterButton;
	private JButton effacerButton;
	
	public JPanneauCalculette() {
		nombre1Field= new JTextField(10);
		resultatField= new JTextField(10);
		resultatField.setEditable(false); // pas modifiable.
		ajouterButton= new JButton("+");
		effacerButton= new JButton("effacer");
		mettreEnPage();
	}

	
	public JTextField getNombre1Field() {
		return nombre1Field;
	}


	public JButton getEffacerButton() {
		return effacerButton;
	}

	public JTextField getResultatField() {
		return resultatField;
	}


	public JButton getAjouterButton() {
		return ajouterButton;
	}


	private void mettreEnPage() {
		// On récupère le conteneur interne de la frame.
		Container panel = this.getContentPane();
		// On fixe son "layout" : on va empiler les composants
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(nombre1Field);
		panel.add(ajouterButton);
		panel.add(resultatField);
		panel.add(effacerButton);
		// On fixe la taille de la frame : 
		this.pack();
	}
}
