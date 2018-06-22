/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.readOnly;

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
public class PersonnesTableModelReadOnly extends AbstractTableModel {

	private List<Personne> personnes;

	public PersonnesTableModelReadOnly(Collection<Personne> personnes) {
		this.personnes = new ArrayList<>(personnes);
	}

	@Override
	public int getRowCount() {
		return personnes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Personne p = personnes.get(rowIndex);
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
}
