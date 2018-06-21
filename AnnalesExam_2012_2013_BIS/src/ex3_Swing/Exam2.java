package ex3_Swing;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
Question3.1 5 points 

Complétez la classe suivante en ajoutant le code nécessaire pour que, 
quand on sélectionne une UE dans la JComboBox, le nombre d’heures correspondantes 
s’afﬁche dans le champ texte heuresField. Vous pouvez écrire des méthodes et des 
classes supplémentaires si vous le désirez. Exemple de l’interface en 
fonctionnement:
Indications: 
– on peut être averti quand l’utilisateur sélectionne une entrée dans une JComboBox 
en utilisant un ActionListener. 
– Pour ﬁxer le modèle d’une JComboBox, on utilise la méthode 
setModel(ComboboxModel model) 
– La classe DefaultComboboxModel a les constructeurs suivants: 
– DefaultComboBoxModel() Construit un modèle vide; 
– DefaultComboBoxModel(Object[] items) construit un modèle à partir d’une liste 
de valeurs. 
– la méthode getSelectedItem() de JCombobox retourne l’objet sélectionné par 
l’utilisateur. 
– le code demandé n’est pas très long. 

public class Exam2 {
	private JComboBox ueListe = new JComboBox();
	private JTextField heuresChamp = new JTextField(10);
	private JFrame frame = new JFrame("formulaire");

	public Exam2() {
		placeComposants();
		activeComposants();
	}

	private void activeComposants() { // À ÉCRIRE

	}

	/**
	 * Place les composants (NE PAS ÉCRIRE !) 
	 //

	private void placeComposants() {
		// ...
	}

	public static void main(String[] args) {
		// Lance le programme:
		// À ÉCRIRE
	}
}
 */

public class Exam2 {
	private JComboBox ueListe = new JComboBox();
	private JTextField heuresChamp = new JTextField(10);
	private JFrame frame = new JFrame("formulaire");
	private JLabel ueLabel = new JLabel("Unité d'enseignement: ");
	private JLabel heuresLabel = new JLabel("Heures: ");

	public Exam2() {
		placeComposants();
		activeComposants();
	}

	public JComboBox getUeListe() {
		return this.ueListe;
	}

	public void setUeListe(JComboBox ueListe) {
		this.ueListe = ueListe;
	}

	public JTextField getHeuresChamp() {
		return this.heuresChamp;
	}

	public void setHeuresChamp(JTextField heuresChamp) {
		this.heuresChamp = heuresChamp;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private void activeComposants() { // À ÉCRIRE
		// set model
		ComboBoxModel<CoursCnam[]> comboBoxModel = new DefaultComboBoxModel(CoursCnam.creerLesCours());
		ueListe.setModel(comboBoxModel);

		// add action listener pour la selection de UE dans le combo:

		// // variante 1 add action listener (EventHandler)
		// this.ueListe.addActionListener(EventHandler.create(ActionListener.class,
		// this, "selectUE"));

		// variante 2 add action listener (lambda expression)
		ueListe.addActionListener((e -> selectUE()));

		// // variante 3 add action listener (classe interne annonime)
		// ueListe.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// selectUE();
		// }
		// });
	}

	/**
	 * Place les composants (NE PAS ÉCRIRE !) ∗/
	 */
	private void placeComposants() {
		// ...
		heuresChamp.setEditable(false);
		Container panel = frame.getContentPane();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		panel.add(this.ueLabel, c);
		panel.add(this.ueListe, c);
		c = new GridBagConstraints();
		c.gridy = 1;
		panel.add(this.heuresLabel, c);
		c.gridx = 1;
		panel.add(this.heuresChamp, c);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void selectUE() {
		CoursCnam ue = (CoursCnam) ueListe.getSelectedItem();
		this.heuresChamp.setText("" + ue.getNombreHeures());
	}

	public static void main(String[] args) {
		// Lance le programme:
		// À ÉCRIRE
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Exam2();
			}
		});

	}
}
