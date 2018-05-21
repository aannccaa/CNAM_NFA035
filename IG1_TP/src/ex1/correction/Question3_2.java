package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Version plus propre de la question 3, avec des actions listeners externes
 * <p> Je les ai mis en classes non publiques dans ce fichier, 
 * ce qui n'est pas forcément une très bonne idée, 
 * mais c'est plus pratique pour vous si vous voulez lire le code.
 * @author rosmord
 *
 */
public class Question3_2 {

	JFrame frame = new JFrame();
	JTextField textField = new JTextField(10);
	JButton buttonMaj = new JButton("majuscules");
	JButton buttonMin = new JButton("minuscules");

	public Question3_2() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(buttonMaj);
		frame.add(buttonMin);
		frame.pack();
		// activation du bouton
		buttonMaj.addActionListener(new MajActionListener(this));
		buttonMin.addActionListener(new MinActionListener(this));
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
				new Question3_2();
			}
		});
	}
}

class MajActionListener implements ActionListener {
	private Question3_2 question3Bis;

	public MajActionListener(Question3_2 question3Bis) {
		this.question3Bis = question3Bis;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		question3Bis.majuscules();
	}
	
	
}


class MinActionListener implements ActionListener {
	private Question3_2 question3Bis;

	public MinActionListener(Question3_2 question3Bis) {
		this.question3Bis = question3Bis;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		question3Bis.minuscules();
	}
}
