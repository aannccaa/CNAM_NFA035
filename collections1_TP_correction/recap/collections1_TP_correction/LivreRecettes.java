package collections1_TP_correction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivreRecettes {
	List<Recette> recettes;

	public LivreRecettes() {
		this.recettes = new ArrayList<>();
	}

	public void addRecette(Recette r) {
		if (r == null) {
			throw new RuntimeException();
		}
		this.recettes.add(r);
	}

	public void addRecette(Recette r, int note) {
		if (r == null) {
			throw new RuntimeException();
		}
		this.recettes.add(r);
		r.addNote(note);
	}

	public void addNote(Recette r, int note) {
		if (r == null) {
			throw new RuntimeException();
		}
		for (Recette recette : recettes) {
			if (recette.getNom().equals(r.getNom())) {
				recette.addNote(note);
			}
		}
	}

	public void afficherRecettes() {
		System.out.println("Recettes: ");
		for (Recette r : recettes) {
			r.afficher();
		}
	}

	public List<Recette> getRecettesParNoteDesc() {
		List<Recette> result = new ArrayList<>(this.recettes);
		CompareRecetteByNoteDesc comparateurParNote = new CompareRecetteByNoteDesc();
		Collections.sort(result, comparateurParNote);
		return result;
	}
	
	public List<Recette> getRecettesParNom(){
		List<Recette> result = new ArrayList<>(this.recettes);
		Collections.sort(result);
		return result;
	}

}
