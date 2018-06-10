package Components;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

//JComponent (tous les components ont les mêmes propriétés)



public class DemoJFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTextField f = new JTextField();
		f.setForeground(Color.RED); // couleur du texte
		f.setBackground(Color.YELLOW); //couleur background
		f.setText("toto");
		//f.setEnabled(false);//desactivé, grisé
		//f.setEditable(false);//read only
		frame.add(f);
		
		// ajustement de la size du frame en fonction du contenu
		frame.pack();
		//Dimension dim = new Dimension(640, 480);
		//frame.setSize(dim);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}

}
