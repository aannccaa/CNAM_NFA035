/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.modifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import d03table.data.Personne;

/**
 *
 * @author rosmord
 */
public class PersonnesTableModel extends AbstractTableModel {

	private List<Personne> personnes;

	public PersonnesTableModel(Collection<Personne> personnes) {
		this.personnes = new ArrayList<>(personnes);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] columnClasses = { Integer.class, String.class, String.class };
		return columnClasses[columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		String[] titres = { "id", "nom", "prénom" };
		return titres[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 1; // dans notre exemple, col. 0 non éditable
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Personne p = this.personnes.get(rowIndex);
		switch (columnIndex) {
		case 1:
			p.setNom((String) aValue);
			break;
		case 2:
			p.setPrenom((String) aValue);
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		return this.personnes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Personne p = this.personnes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getId();
		case 1:
			return p.getNom();
		case 2:
			return p.getPrenom();
		default:
			return "";
		}
	}

	public void ajouterPersonne(Personne p) {
		int position = this.personnes.size();
		this.personnes.add(p);
		fireTableRowsInserted(position, position);
	}

	public void supprimerPersonne(int ligne) {
		this.personnes.remove(ligne);
		fireTableRowsDeleted(ligne, ligne);
	}
}
