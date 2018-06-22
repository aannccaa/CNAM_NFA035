/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_correction;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author rosmord
 */
public class UI extends JFrame {
	JTable table = new JTable();
	JTextField nom = new JTextField(10);
	JTextField prenom = new JTextField(10);
	JButton ajouterButton = new JButton("nouveau");
	JButton supprimerButton = new JButton("supprimer");

	public UI() throws HeadlessException {
		mettreEnPage();
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getNom() {
		return nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public JButton getAjouterButton() {
		return ajouterButton;
	}

	public JButton getSupprimerButton() {
		return supprimerButton;
	}

	private void mettreEnPage() {
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(creerPanelEdition(), BorderLayout.SOUTH);
		pack();
	}

	private JPanel creerPanelEdition() {
		JPanel sud = new JPanel();
		sud.setLayout(new FlowLayout());
		sud.add(new JLabel("nom"));
		sud.add(nom);
		sud.add(new JLabel("prénom"));
		sud.add(prenom);
		sud.add(ajouterButton);
		sud.add(supprimerButton);
		return sud;
	}

}
