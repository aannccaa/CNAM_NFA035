/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.colonnes;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rosmord
 */
public class DemoTableModel extends AbstractTableModel {

	Object[][] contenu;
	int nbColonnes;

	public DemoTableModel(int nbLignes) {
		nbColonnes = 4;
		contenu = new Object[nbLignes][nbColonnes];
		for (int i = 0; i < nbLignes; i++) {
			contenu[i][0] = 0;
			contenu[i][1] = "du texte";
			contenu[i][2] = false;
			contenu[i][3] = Color.RED;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] columnClasses = { Integer.class, String.class, Boolean.class, Color.class };
		return columnClasses[columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		String[] titres = { "entier", "String", "Booléen", "Couleur" };
		return titres[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.contenu[rowIndex][columnIndex] = aValue;

		// Notifies all listeners that the value of the cell at [row, column] has been
		// updated.
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		return this.contenu.length;
	}

	@Override
	public int getColumnCount() {
		return this.nbColonnes;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.contenu[rowIndex][columnIndex];
	}

}
