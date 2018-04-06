package exo2;

import java.util.ArrayList;

public class Recette implements Comparable<Recette> {
	private static int lastId;
	private final int id;
	private String nom;
	private ArrayList<Integer> notes;

	public int getId() {
		return this.id;
	}

	public Recette(String nom) {
		// on incremente lastId puis on l'attribue à id
		this.id = ++lastId;
		this.nom = nom;
		this.notes = new ArrayList<>();
	}

	public String getNom() {
		return this.nom;
	}

	public void addNote(int n) throws RecetteException {
		if (n < 1 || n > 5) {
			throw new RecetteException("La note doit être entre 1 et 5");
		}
		notes.add(n);
	}

	public double getMoyenneNotes() {
		if (this.notes.size() == 0) {
			return 0;
		}
		double somme = 0;
		for (int note : this.notes) {
			somme = somme + note;
		}
		return somme / this.notes.size();
	}

	public String toString() {
		String formatStr = this.notes.size() > 0 ? "%s (%.1f)" : "%s";
		return String.format(formatStr, this.getNom(), this.getMoyenneNotes());
	}

	/**
	 * crée une copie de la liste des notes
	 * 
	 * @return
	 */
	public int[] getNotes() {
		int[] result = new int[this.notes.size()];
		for (int i = 0; i < notes.size(); i++) {
			result[i] = this.notes.get(i);
		}
		return result;
	}

	@Override
	// comparaison alphabétique,
	public int compareTo(Recette r) {
		// null < n'importe quelle recette
		if (r == null) {
			return 1;
		}
		if (r == this) {
			return 0;
		}
		int result = this.nom.toLowerCase().compareTo(r.nom.toLowerCase());
		if (result == 0) {
			ComparatorRecettesByNote comp = new ComparatorRecettesByNote();
			result = comp.compare(this, r);
		}
		if (result == 0) {
			result = this.id - r.id;
		}
		return result;
	}

}
