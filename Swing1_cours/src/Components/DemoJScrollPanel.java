package Components;
//JScrollPanel (tous les components ont les mêmes propriétés)

import java.awt.*;
import javax.swing.*;

public class DemoJScrollPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		// champ text sur plusieurs lignes
		JTextArea textArea = new JTextArea();
		for(int i=0; i<1000; i++) {
			textArea.append("une ligne\n");// ecrit à la fin du textArea:
		}
		textArea.setForeground(Color.RED); // couleur du texte
		textArea.setBackground(Color.YELLOW); //couleur background
		
		// on place le composant désiré (textArea) dans le JScrollPane 
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane);	
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}

}
