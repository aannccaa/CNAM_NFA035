package exercice1;

import java.util.*;


/**
 * Classe représentant le livre de recettes.
 * 
 * <p>Notez que cette classe n'est pas l'application elle-même. Elle
 * n'a aucune méthode d'entrées/sortie.
 * @author rosmord, aponte
 *
 */
public class LivreDeRecettes {

	private TreeMap<String,Recette> recettes= new TreeMap<String,Recette>();
	/**
	 * Ajoute une recette dont on donne le titre et les ingredients.
	 * @param titre
	 */
	
	public void ajouterRecette(String titre,String []ig, int[] q) {
		recettes.put(titre,new Recette(titre, ig, q));
	}

	/**
	 * Ajoute une recette dont on donne le titre.
	 * @param titre
	 */
	public void ajouterRecette(String titre) {
		recettes.put(titre,(new Recette(titre)));
	}
	
	/**
	 * Renvoie une copie de la liste des recettes.
	 * (intérêt: le programmeur ne peut pas la modifier directement 
	 * et changer notre liste de recette derrière notre dos).
	 * @return
	 */
	public List<Recette> getRecettes() {
		return new ArrayList<Recette>(recettes.values());
	}
	
	public int getNombreDeRecettes() {
		return recettes.size();
	}
	/**
	 * Supprime la recette de titre titre.
	 * @param titre
	 */
	public void supprimerRecette(String titre) {
		recettes.remove(titre);		
	}
	/**
	 * Retourne true si le titre titre est dans le livre.
	 * @param titre
	 * @return
	 */
	public boolean contiens(String titre){
		return recettes.containsKey(titre);
	}
	/**
	 * Retourne une recette à partir de son titre.
	 * @param numero
	 * @return
	 */
	public Recette getRecette(String titre) {
		return recettes.get(titre);				
	}
	/**
	 * Ajoute une liste d'ingreidents et quantites dans une rectte du livre.
	 * @param r
	 * @param ingre
	 * @param quant
	 * @throws IllegalArgumentException si la recette n'est pas dans le livre.
	 */
	public void ajouterIngredientsDansRecette(String r, String[] ingre, int[] quant){
		Recette rec= recettes.get(r);
		if(rec==null)
			throw new IllegalArgumentException();
		else
			rec.ajouterIngredients(ingre, quant);
	}
	/**
	 * Donne une note à la recette de titre titre.
	 * @param numero le numéro de la recette.
	 * @param note la note à donner.
	 */
	public void noterRecette(String titre, int note) {
		recettes.get(titre).ajouterNote(note);
	}
	
	public List<Recette> recettesTrieesParNote() {
		List<Recette> resultat= new ArrayList<Recette>(recettes.values());
		Collections.sort(resultat, new NoteComparator());
		return resultat;
	}
	
	public List<Recette> recettesTrieesParTitre() {
		List<Recette> resultat= new ArrayList<Recette>(recettes.values());
		Collections.sort(resultat);
		return resultat;
	}
	
	public List<Recette> recettesAvecIngredient(String ingr){
		List<Recette> res= new ArrayList<Recette>();
		for(Recette r : recettes.values()){
			if (r.contientIngredient(ingr))
				res.add(r);
		}
		return res;
	}
}
