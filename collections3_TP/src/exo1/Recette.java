package exo1;

/*
 Question 2 (s’il vous reste du temps)
On souhaite enrichir la definition d’une recette avec la liste de ses ingredients 
(sans doublons) et la quantité nécessaire pour chaque ingredient. Un ingrédient 
sera représenté par un String et une quantité par un nombre d’unite ́s (Integer). 
Comment representer les ingredients et quantités d’une recette ? 
Modifiez la classe Recette afin d’y stocker les ingrédients et quantites et 
ajoutez les méthodes appropriées dans cette classe et dans LivreRecettes. 
Ajoutez des tests et testez.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Recette implements Comparable<Recette> {

	private final String nom;
	private ArrayList<Integer> notes;
	private Map<String, Integer> ingredients;
	

	public Recette(String nom) {
		this.nom = nom;
		this.notes = new ArrayList<>();
		this.ingredients = new HashMap<>();
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
	
	public boolean contientIngredient(String ingredient) {
		return ingredients.containsKey(ingredient);
	}

	public String toString_old() {
		String formatStr = this.notes.size() > 0 ? "%s (%.1f)" : "%s, \n  ingredients: %s %s";
		return String.format(formatStr, this.getNom(), this.getMoyenneNotes(), this.getIngredients().keySet(),
				this.getIngredients().values());
	}

	@Override
	public String toString() {
		String igs = "";
		for (Map.Entry<String, Integer> i : ingredients.entrySet()) {
			igs = igs + i.getValue() + " " + i.getKey() + "\n ";
		}
		return this.nom + " - note moyenne: " + this.getMoyenneNotes() + "\n Ingredients: \n " + igs;
	}

	public void afficher() {
		this.toString();
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
		return result;
	}

	/**
	 * @return the ingredients
	 */
	public Map<String, Integer> getIngredients() {
		return this.ingredients;
	}

	/**
	 * @param ingredients
	 *            the ingredients to set
	 */
	public void setIngredients(Map<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}
}
