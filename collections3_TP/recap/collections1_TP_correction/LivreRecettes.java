package collections1_TP_correction;
/*
Question 1 : le livre de recettes
On veut s’assurer qu’un livre de recettes ne contienne pas de recette en double 
(meme nom de recette). Vous utiliserez une structure Map pour garder sans doublons 
les titres (String) des recettes. Das votre Map les clés seront les titres des 
recettes, chacune associee a un objet Recette. Attention : la logique de 
l’application change avec cet implantation. Lors du Tp5 on identifiait une recette 
(p.e., pour la noter) en donnant son rang dans le livre. Cela n’a pas de sens dans 
une Map (pourquoi ?). Quelles sont les opérations qui changent et comment? 
Modifiez votre classe de maniere a faire fonctionner votre application avec 
cette nouvelle implantation.
Par ailleurs, on voudrait que les recettes du livre soient classe ́s en ordre 
alphabétique. A cette fin, les clés de recherche de votre Map doivent implanter 
Comparable. Mais cela ne suffit pas : vous devez utiliser un TreeMap pour stocker 
les recettes du livre. A ce stade, utilisez a nouveau les tests mis en place 
lors du tp précédent afin de vous assurer que tout fonctionne comme prévu : 
ce sont des tests de non regression !
1. Votre programme main devrait bien fonctionner avec peu de modifications 
(lesquelles ?) 
2. Vos test Junit devraient réussir avec peu de modifications.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LivreRecettes {
	Map<String, Recette> recettes;

	public LivreRecettes() {
		this.recettes = new HashMap<>();
	}

	public void addRecette(Recette r) {
		if (r == null) {
			throw new RuntimeException();
		}
		String key = r.getNom();
		this.recettes.put(key, r);
	}

	public void addRecette(String titre) {
		if (titre == null) {
			throw new RuntimeException();
		}
		Recette r = new Recette(titre);
		String key = titre;
		this.recettes.put(key, r);
	}

	public void addRecette(Recette r, int note) {
		if (r == null) {
			throw new RuntimeException();
		}
		String key = r.getNom();
		this.recettes.put(key, r);
		r.addNote(note);
	}

	public void addNote(Recette r, int note) {
		if (r == null) {
			throw new RuntimeException();
		}
		for (Recette recette : this.recettes.values()) {
			if (recette.getNom().equals(r.getNom())) {
				recette.addNote(note);
			}
		}
	}

	public void addNote(String nom, int note) {
		if (nom == null) {
			throw new RuntimeException();
		}
		Recette r = recettes.get(nom);
		r.addNote(note);
	}

	public void afficherRecettes() {
		System.out.println("Recettes: ");
		for (Recette r : this.recettes.values()) {
			r.afficher();
		}
	}

	public List<Recette> getRecettes() {
		List<Recette> livreRecette = new ArrayList<>(this.recettes.values());
		return livreRecette;
	}

	public void supprimerRecette(String titre) {
		this.recettes.remove(titre);
	}

	public Recette getRecette(String nom) {
		return this.recettes.get(nom);
	}

	public List<Recette> getRecettesParNoteDesc() {
		List<Recette> result = this.getRecettes();
		CompareRecetteByNoteDesc comparateurParNote = new CompareRecetteByNoteDesc();
		Collections.sort(result, comparateurParNote);
		return result;
	}

	public List<Recette> getRecettesParNom() {
		List<Recette> result = this.getRecettes();
		Collections.sort(result);
		return result;
	}

}
