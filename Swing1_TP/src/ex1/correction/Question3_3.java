package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Version plus propre de la question 3, avec des actions listeners internes
 * (plus besoin de passer this).
 * @author rosmord
 *
 */
public class Question3_3 {

	JFrame frame = new JFrame();
	JTextField textField = new JTextField(10);
	JButton buttonMaj = new JButton("majuscules");
	JButton buttonMin = new JButton("minuscules");

	public Question3_3() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(buttonMaj);
		frame.add(buttonMin);
		frame.pack();
		// activation du bouton
		buttonMaj.addActionListener(new MajActionListener());
		buttonMin.addActionListener(new MinActionListener());
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

	class MajActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			majuscules();
		}

	}

	class MinActionListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			minuscules();
		}
	}

	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Question3_3();
			}
		});
	}
}
