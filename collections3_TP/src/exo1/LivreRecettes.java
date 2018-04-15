package exo1;
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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LivreRecettes {
	private String nom;
	private Map<String, Recette> recettes;

	public LivreRecettes(String nom) {
		this.nom = nom;
		this.recettes = new TreeMap<String, Recette>();
	}

	public String getNom() {
		return this.nom;
	}

	public void addRecette(Recette r) {
		if (r == null) {
			throw new RecetteException("La recette ne peut pas être vide");
		}
		if (this.recettes.containsKey(r.getNom())) {
			throw new RecetteException("La recette existe déjà");
		}
		this.recettes.put(r.getNom(), r);
	}

	public boolean existeRecette(String nom) {
		return this.recettes.containsKey(nom);
	}

	public Recette findByNom(String nom) {
		return this.recettes.get(nom);
	}

	public void removeRecette(Recette r) {
		this.removeRecette(r.getNom());
	}

	public void removeRecette(String nom) {
		if (!this.recettes.containsKey(nom)) {
			throw new RecetteException("Recette inexistante");
		}
		this.recettes.remove(nom);
	}

	public int getCountRecettes() {
		return this.recettes.size();
	}

	public List<Recette> sort(OrdreRecettes ordre) {
		ArrayList<Recette> result = new ArrayList<>(this.recettes.values());
		if (ordre == OrdreRecettes.PAR_NOTES) {
			result.sort(new ComparatorRecettesByNote());
		}
		return result;
	}

	public Collection<Recette> getRecettes() {
		return this.recettes.values();

	}
	
	public List<Recette> recettesAvecIngredient(String ingredient){
		List<Recette> result = new ArrayList<Recette>(recettes.values());
		for (Recette r : recettes.values()) {
			if (r.contientIngredient(ingredient)) {
				result.add(r);
			}
		}
		return result;
	}

	public String toString(OrdreRecettes ordre) {
		ArrayList<String> elements = new ArrayList<>();
		elements.add(this.getNom());
		for (Recette r : this.sort(ordre)) {
			elements.add(r.toString());
		}
		String result = String.join("\n", elements);
		return result;
	}

	public String toString() {
		return this.toString(OrdreRecettes.PAR_NOM);
	}

	public void afficherLivreTrie(OrdreRecettes ordre) {
		System.out.println("=============>");

		System.out.println(this.toString(ordre));
		System.out.println("<=============");
	}

}
