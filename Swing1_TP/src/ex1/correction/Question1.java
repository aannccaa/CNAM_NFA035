package ex1.correction;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Question1 {
	JFrame frame;
	JLabel label;
	
	public Question1() {
		frame= new JFrame("Ma première fenêtre swing");
		label= new JLabel("Salut tout le monde !");
		frame.add(label);
		// On prend pile poil la bonne taille pour contenir le label.
		frame.pack();
		// On devient visible
		frame.setVisible(true);
		// On demande à ce que le programme se termine quand la fenêtre se ferme.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		// Formule magique expliquée plus tard dans le cours...
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new Question1();	
			}
		});	
	}
}
