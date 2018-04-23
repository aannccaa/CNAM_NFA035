package exo1.Correction;


import java.util.*;


/**
 * Classe représentant le livre de recettes.
 * 
 * <p>Notez que cette classe n'est pas l'application elle-même. Elle
 * n'a aucune méthode d'entrées/sortie.
 * 
 * @author rosmord
 *
 */
public class LivreDeRecettes {
	// On utilise une TreeMap pour avoir les recettes dans l'ordre alphabétique.
	private Map<String,Recette> recettes= new TreeMap<>();
	
	/**
	 * Ajoute une recette dont on donne le titre.
	 * @param titre
	 */
	public void ajouterRecette(String titre) {
		recettes.put(titre,new Recette(titre));
	}
	
	/**
	 * Renvoie une copie de la liste des recettes.
	 * (intérêt: le programmeur ne peut pas la modifier directement 
	 * et changer notre liste de recette derrière notre dos).
	 * @return
	 */
	public List<Recette> getRecettes() {
		return new ArrayList<>(recettes.values());
	}
	
	public int getNombreDeRecettes() {
		return recettes.size();
	}
	/**
	 * Supprime une recette dont on donne le nom.
	 * MODIFICATION PAR RAPPORT A LA CLASSE D'ORIGINE!!
	 * <p>Ne fait rien si la recette n'existe pas.
	 * @param nom le nom d'une recette.
	 * 
	 */
	public void supprimerRecette(String nom) {
		recettes.remove(nom);		
	}
	
	/**
	 * Retourne une recette à partir de son nom.
	 * MODIFICATION PAR RAPPORT A LA CLASSE D'ORIGINE!!
	 * @param nom
	 * @return
	 */
	public Recette getRecette(String nom) {
		return recettes.get(nom);				
	}
	
	/**
	 * Donne une note à la recette de nom nom.
	 * MODIFICATION PAR RAPPORT A LA CLASSE D'ORIGINE!!
	 * Lève une NullPointerException si la recette n'existe pas.
	 * On pourrait sans doute faire plus parlant.
	 * @param nom le nom de la recette.
	 * @param note la note à donner.
	 */
	public void noterRecette(String nom, int note) {
		recettes.get(nom).ajouterNote(note);
	}
	
	public void ajouterIngredient(String nomRecette, String ingredient, int quantite) {
		recettes.get(nomRecette).ajouterIngredient(ingredient, quantite);
	}
	
	
	
	public List<Recette> recettesTrieesParNote() {
		List<Recette> resultat= new ArrayList<>(recettes.values());
		Collections.sort(resultat, new NoteComparator());
		return resultat;
	}
	
	public List<Recette> recettesTrieesParTitre() {
		List<Recette> resultat= new ArrayList<>(recettes.values());
		// Pas besoin de tri: on est déjà triés !
		return resultat;
	}
}
