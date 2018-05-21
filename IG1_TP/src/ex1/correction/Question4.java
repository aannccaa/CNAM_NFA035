package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Le but de cet exercice est de vous faire lire de la documentation.
 * @author rosmord
 *
 */
public class Question4  {

	private static final String MAJUSCULES = "majuscules";
	private static final String MINUSCULES = "minuscules";
	private static final String EFFACER = "effacer";
	
	JFrame frame = new JFrame();
	JTextField textField = new JTextField(10);
	JComboBox<String> choixAction= new JComboBox<String>(
			new String[] {MAJUSCULES, MINUSCULES, EFFACER});
	JButton button = new JButton("action !");

	public Question4() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(choixAction);
		frame.add(button);
		frame.pack();
		// activation du bouton
		button.addActionListener(EventHandler.create(ActionListener.class, this, "faireAction"));
		// affichage de la frame.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void faireAction() {
		String selectedItem = (String)choixAction.getSelectedItem();
		String s = textField.getText();
		switch (selectedItem) {
		case MAJUSCULES :
			textField.setText(s.toUpperCase());
			break;
		case MINUSCULES:
			textField.setText(s.toLowerCase());
			break;
		case EFFACER:
			textField.setText("");
			break;
		}
	}
	

	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Question4();
			}
		});
	}
}
