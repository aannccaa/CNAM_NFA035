package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// On implémente de manière pas fine ActionListener.
// et on a deux boutons... ça n'est pas beau du tout 
// (et ça commencerait à être peu pratique si le nombre de boutons augmentait).
public class Question3_1 implements ActionListener {

	JFrame frame = new JFrame();
	JTextField textField = new JTextField(10);
	JButton buttonMaj = new JButton("majuscules");
	JButton buttonMin = new JButton("minuscules");

	public Question3_1() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(buttonMaj);
		frame.add(buttonMin);
		frame.pack();
		// activation du bouton
		buttonMaj.addActionListener(this);
		buttonMin.addActionListener(this);
		// affichage de la frame.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// NE PAS FAIRE COMME CA !!!
		String s = textField.getText();
		// On regarde quel bouton a été cliqué:
		if (e.getSource() == buttonMaj) {
			textField.setText(s.toUpperCase());
		} else {
			// pas besoin de else if, vu qu'on n'a que deux boutons...
			textField.setText(s.toLowerCase());
		}
	}

	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Question3_1();
			}
		});
	}
}
