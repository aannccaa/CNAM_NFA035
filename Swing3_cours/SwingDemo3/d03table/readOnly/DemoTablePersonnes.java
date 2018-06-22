/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.readOnly;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import d03table.data.Personne;
import d03table.data.Personnes;

/**
 *
 * @author rosmord
 */
public class DemoTablePersonnes {
	JFrame frame;
	JTable table;
	PersonnesTableModelReadOnly model;
	List<Personne> listPersonnes;

	public DemoTablePersonnes() {
		this.frame = new JFrame("Un tableau");
		this.table = new JTable();
		this.listPersonnes = Personnes.getList();
		this.model = new PersonnesTableModelReadOnly(listPersonnes);
		
		// on set le modèle
		this.table.setModel(model);
		
		this.frame.add(new JScrollPane(table));
		this.frame.setVisible(true);
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
