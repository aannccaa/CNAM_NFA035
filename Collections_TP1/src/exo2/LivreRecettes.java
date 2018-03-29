package exo2;

import java.util.ArrayList;
import java.util.Collections;

public class LivreRecettes {
	private String nom;
	private ArrayList<Recette> recettes;

	public LivreRecettes(String nom) {
		this.nom = nom;
		this.recettes = new ArrayList<Recette>();
	}

	public String getNom() {
		return this.nom;
	}

	public void addRecette(Recette r) {
		if (r == null) {
			throw new RecetteException("La recette ne peut pas être vide");
		}
		// vérif unicité
		int indexRecette = this.recettes.indexOf(r);
		if (indexRecette >= 0) {
			throw new RecetteException("La recette existe déjà");
		}
		this.recettes.add(r);
	}

	public Recette findById(int id) {
		for (Recette r : this.recettes) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

	public void removeRecette(Recette r) {
		if (!this.recettes.remove(r)) {
			throw new RecetteException("Recette inexistante");
		}
	}

	public void removeRecette(int id) {
		Recette r = this.findById(id);
		if (r == null) {
			throw new RecetteException("Recette inexistante");
		}
		this.recettes.remove(r);
	}

	public int getCountRecettes() {
		return this.recettes.size();
	}

	public String toString() {
		ArrayList<String> elements = new ArrayList<>();
		elements.add(this.getNom());
		for (Recette r : this.recettes) {
			elements.add(r.toString());
		}
		String result = String.join("\n", elements);
		return result;
	}

	public void sortByNoteDesc() {
		this.recettes.sort(new ComparatorRecettesByNote());
	}

	public void sortByNomEtNote() {
		Collections.sort(this.recettes);
	}

	public ArrayList<Recette> getRecettes() {
		return new ArrayList<Recette>(this.recettes);
	}

	public void afficherLivreTrie(OrdreRecettes ordre) {
		System.out.println("=============>");
		if (ordre == OrdreRecettes.PAR_NOTES) {
			this.sortByNoteDesc();
		} else if (ordre == OrdreRecettes.PAR_NOM) {
			this.sortByNomEtNote();
		} else {
			throw new RecetteException("Pas de bonne valeur donnée pour l'ordre");
		}
		System.out.println(this.toString());
		System.out.println("<=============");
	}

}
