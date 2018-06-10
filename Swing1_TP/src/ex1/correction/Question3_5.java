package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Version de la question 3, en utilisant des EventHandler.
 * @author rosmord
 *
 */
public class Question3_5 {

	JFrame frame = new JFrame();
	JTextField textField = new JTextField(10);
	JButton buttonMaj = new JButton("majuscules");
	JButton buttonMin = new JButton("minuscules");

	public Question3_5() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(buttonMaj);
		frame.add(buttonMin);
		frame.pack();
		// activation du bouton
		buttonMaj.addActionListener(EventHandler.create(ActionListener.class, this, "majuscules"));
		buttonMin.addActionListener(EventHandler.create(ActionListener.class, this, "minuscules"));
		// affichage de la frame.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majuscules() {
		String s = textField.getText();
		textField.setText(s.toUpperCase());

	}

	public void minuscules() {
		String s = textField.getText();
		textField.setText(s.toLowerCase());
	}

	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Question3_5();
			}
		});
	}
}
