package exo2;

import java.util.ArrayList;

public class Recette {
	private String nom;
	private ArrayList<Integer> notes;

	public Recette(String nom) {
		this.nom = nom;
		this.notes = new ArrayList<>();
	}

	public String getNom() {
		return this.nom;
	}

	public void addNote(int n) throws RecetteException{
		if (n<1 || n> 5) {
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
		return String.format("%s (%.2f)", this.getNom(), this.getMoyenneNotes());
	}

	/**
	 * crée une copie de la liste des notes
	 * @return
	 */
	public int[] getNotes() {
		int[] result = new int[this.notes.size()];
		for(int i = 0; i< notes.size(); i++) {
			result[i] = this.notes.get(i);
		}
		return result;
	}

}
