/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_correction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rosmord
 */
public class EtudiantTableModel extends AbstractTableModel {
	private final static String COLUMNS[] = { "NOM", "PRENOM", "PARTIEL", "EXAMEN", "MOYENNE" };

	private final static int NOM = 0;
	private final static int PRENOM = 1;
	private final static int PARTIEL = 2;
	private final static int EXAMEN = 3;
	private final static int MOYENNE = 4;

	private final static Class<?> COLUMN_CLASSES[] = { String.class, String.class, Double.class, Double.class,
			Double.class };

	private List<Etudiant> etudiants;

	public EtudiantTableModel(List<Etudiant> listeInitiale) {
		// "copie défensive". La liste manipulée par le modèle
		// lui appartient, et n'est pas une arraylist quelconque.
		// (sinon, risque : si on modifie par exemple l'arraylist
		// de départ, le modèle ne sera pas au courant.)
		this.etudiants = new ArrayList<>(listeInitiale);
	}

	@Override
	public int getRowCount() {
		return etudiants.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMNS[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (inRows(rowIndex) && inCols(columnIndex)) {
			Etudiant e = etudiants.get(rowIndex);
			switch (columnIndex) {
			case NOM:
				return e.getNom();
			case PRENOM:
				return e.getPrenom();
			case PARTIEL:
				return e.getPartiel();
			case EXAMEN:
				return e.getExamen();
			case MOYENNE:
				return e.getMoyenne();
			default:
				throw new RuntimeException("Index hors limite - impossible ? " + columnIndex);
			}
		} else {
			return null;
		}
	}

	private boolean inRows(int rowIndex) {
		return 0 <= rowIndex && rowIndex < etudiants.size();
	}

	private boolean inCols(int columnIndex) {
		return 0 <= columnIndex && columnIndex < COLUMNS.length;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (inRows(rowIndex)) {
			return (columnIndex == EXAMEN || columnIndex == PARTIEL);
		} else {
			return false;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_CLASSES[columnIndex];
	}
	
	public void ajouter(Etudiant e) {
		int taille= etudiants.size();
		etudiants.add(e);
		fireTableRowsInserted(taille, taille);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (inRows(rowIndex)) {
			Etudiant e = etudiants.get(rowIndex);
			switch (columnIndex) {
			case EXAMEN: {
				double d = (Double) aValue;
				e.setExamen(d);
				fireTableCellUpdated(rowIndex, columnIndex);
				fireTableCellUpdated(rowIndex, MOYENNE);
				break;
			}
			case PARTIEL: {
				double d = (Double) aValue;
				e.setPartiel(d);
				fireTableCellUpdated(rowIndex, columnIndex);
				fireTableCellUpdated(rowIndex, MOYENNE);
				break;
			}
			default:
				throw new RuntimeException("Edition de case non éditable ?");
			}
		}
	}

	public void supprimer(int rowIndex) {
		if (inRows(rowIndex)) {
			etudiants.remove(rowIndex);
			fireTableRowsDeleted(rowIndex, rowIndex);
		}
	}

}
