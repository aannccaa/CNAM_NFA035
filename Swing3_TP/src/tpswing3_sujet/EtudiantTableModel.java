/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_sujet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rosmord
 */
public class EtudiantTableModel extends AbstractTableModel {

	private List<Etudiant> etudiants;
	int nbColonnes;

	public EtudiantTableModel(List<Etudiant> listeInitiale) {
		// throw new RuntimeException("écrivez ce constructeur");
		this.etudiants = new ArrayList<>(listeInitiale);
		nbColonnes = 5;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] columnClasses = { String.class, String.class, Double.class, Double.class, Double.class };
		return columnClasses[columnIndex];

	}

	@Override
	public String getColumnName(int column) {
		String[] titres = { "Nom", "Prénom", "Note partiel", "Note examen", "Moyenne" };
		return titres[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 2 && columnIndex < 4;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Etudiant e = this.etudiants.get(rowIndex);
		switch (columnIndex) {
		case 2:
			e.setPartiel((double) aValue);
			break;
		case 3:
			e.setExamen((double) aValue);
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		return this.etudiants.size();
	}

	@Override
	public int getColumnCount() {
		return this.nbColonnes;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Etudiant e = this.etudiants.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return e.nom;
		case 1:
			return e.prenom;
		case 2:
			return e.partiel;
		case 3:
			return e.examen;
		case 4:
			return e.getMoyenne();
		default:
			return "";
		}
	}

	public void ajouterEtudiant(Etudiant e) {
		int position = this.etudiants.size();
		this.etudiants.add(e);
		fireTableRowsInserted(position, position);
	}

	public void supprimerEtudiant(int ligne) {
		this.etudiants.remove(ligne);
		fireTableRowsDeleted(ligne, ligne);
	}
}
