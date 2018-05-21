package ex1.correction;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// On implémente de manière pas fine ActionListener. 
public class Question2 implements ActionListener{

	JFrame frame= new JFrame();
	JTextField textField= new JTextField(10);
	JButton button= new JButton("cliquez-moi");
	
	public Question2() {
		// Mise en page
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(button);
		frame.pack();		
		// activation du bouton
		button.addActionListener(this);
		// affichage de la frame.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s= textField.getText();
		textField.setText(s.toUpperCase());
	}


	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new Question2();	
			}
		});	
	}
}
