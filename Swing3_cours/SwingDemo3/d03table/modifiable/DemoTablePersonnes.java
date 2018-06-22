/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.modifiable;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import d03table.data.Personne;
import d03table.data.Personnes;

/**
 *
 * @author rosmord
 */
public class DemoTablePersonnes {
	JFrame frame = new JFrame("Un tableau");
	JTable table = new JTable();
	JButton addPersonneButton = new JButton("+");
	JButton removePersonneButton = new JButton("-");
	private final PersonnesTableModel model;

	public DemoTablePersonnes() {
		model = new PersonnesTableModel(Personnes.getList());
		// Cette ligne évite le bug en cas de suppression lors d'une
		// édition.
		// voir http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6349059
		// et http://bugs.java.com/bugdatabase/view_bug.do?bug_id=4709394
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		table.setModel(model);
		frame.setLayout(new BorderLayout());

		addPersonneButton.addActionListener(e -> addPersonne());
		removePersonneButton.addActionListener(e -> enleverPersonne());
		JToolBar outils = new JToolBar();
		outils.setFloatable(false);
		outils.add(addPersonneButton);
		outils.add(removePersonneButton);
		frame.add(new JScrollPane(table), BorderLayout.CENTER);
		frame.add(outils, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addPersonne() {
		Personne p = new Personne(100, "(nom)", "(prenom)");
		model.ajouterPersonne(p);
	}

	public void enleverPersonne() {
		// get the index of the first selected row, -1 if no row is selected:
		int ligne = table.getSelectedRow();
		// if a row is selected:
		if (ligne != -1) {
			// delete
			model.supprimerPersonne(ligne);
		}
	}

}
