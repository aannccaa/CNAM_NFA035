package Layout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoGridbagLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		panel.setLayout(gridBagLayout);
		JTextField nomField = new JTextField(30);
		JTextField prenomField = new JTextField(30);
		JLabel nomLabel = new JLabel("Nom");
		JLabel prenomLabel = new JLabel("Prénom");
		GridBagConstraints gridBagContraints = new GridBagConstraints();
		/* 
		initiallement, la position de l'object à ajouter:
		gridBagContraints.gridx = 0 <=> colonne 0
		gridBagContraints.gridy = 0 <=> ligne 0
		*/
		panel.add(nomLabel, gridBagContraints); // ajoute sur ligne 0, colonne 0
		gridBagContraints.gridx = 1; // colonne 1
		panel.add(nomField, gridBagContraints); // ajoute sur ligne 0, colonne 1
		gridBagContraints.gridx = 0; // colonne 0
		gridBagContraints.gridy = 1; // ligne 1
		panel.add(prenomLabel, gridBagContraints); // ajoute sur ligne 1, colonne 0
		gridBagContraints.gridx = 1; // colonne 1
		panel.add(prenomField, gridBagContraints); // ajoute sur ligne 1, colonne 1
		gridBagContraints.gridx=0;
		gridBagContraints.gridy=2; // ligne 2
		gridBagContraints.gridwidth=2; // occupe 2 colonnes
		panel.add(new JButton("demo"), gridBagContraints);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
