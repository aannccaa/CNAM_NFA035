/*
Exercice 1 Question 1
Cr ́eez une application Swing, qui, quand on la lance, ouvre une fenˆetre affichant 
≪ salut tout le monde ! ≫. Vous utiliserez un JLabel pour faire cet affichage.
 */

package ex1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Q1 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JLabel label = new JLabel(" salut tout le monde ");
		f.add(label);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
