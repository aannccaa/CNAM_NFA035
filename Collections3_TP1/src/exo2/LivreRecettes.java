package exo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LivreRecettes {
	private String nom;
	private ArrayList<Recette> recettes;
	private OrdreRecettes ordreRecettes;
	private HashMap<Integer,Recette> hm_recettes = new HashMap<>();
	
	public HashMap<Integer, Recette> getHm_recettes() {
		return hm_recettes;
	}


	public LivreRecettes(String nom) {
		this.nom = nom;
		this.recettes = new ArrayList<Recette>();
		this.ordreRecettes = OrdreRecettes.NON_TRIE;
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
		this.ordreRecettes = OrdreRecettes.NON_TRIE;
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

	public void sort(OrdreRecettes ordre) {
		// si déjà trié on ne fait rien
		if (ordre == this.ordreRecettes) {
			return;
		}
		switch (ordre) {
		case PAR_NOTES:
			this.sortByNoteDesc();
			return;
		case PAR_NOM:
			this.sortByNomEtNote();
			return;
		default:
			return;
		}
	}

	public void sortByNoteDesc() {
		this.ordreRecettes = OrdreRecettes.PAR_NOTES;
		this.recettes.sort(new ComparatorRecettesByNote());
	}

	public void sortByNomEtNote() {
		this.ordreRecettes = OrdreRecettes.PAR_NOM;
		Collections.sort(this.recettes);
	}

	public ArrayList<Recette> getRecettes() {
		return new ArrayList<Recette>(this.recettes);
	}

	public void afficherLivreTrie(OrdreRecettes ordre) {
		System.out.println("=============>");
		sort(ordre);
		System.out.println(this.toString());
		System.out.println("<=============");
	}

}
