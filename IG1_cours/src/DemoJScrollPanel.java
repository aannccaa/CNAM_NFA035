//JScrollPanel (tous les components ont les mêmes propriétés)

import java.awt.*;
import javax.swing.*;

public class DemoJScrollPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTextArea f = new JTextArea();
		for(int i=0; i<1000; i++) {
			f.append("une ligne\n");
		}
		f.setForeground(Color.RED); // couleur du texte
		f.setBackground(Color.YELLOW); //couleur background
		JScrollPane scrollPane = new JScrollPane(f);
		frame.getContentPane().add(scrollPane);	
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}

}
