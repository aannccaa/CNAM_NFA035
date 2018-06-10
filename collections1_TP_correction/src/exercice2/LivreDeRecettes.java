package exercice2;

import java.util.*;


/**
 * Classe représentant le livre de recettes.
 * 
 * <p>Notez que cette classe n'est pas l'application elle-même. Elle
 * n'a aucune méthode d'entrées/sortie.
 * @author rosmord
 *
 */
public class LivreDeRecettes {
	private ArrayList<Recette> recettes= new ArrayList<Recette>();
	
	/**
	 * Ajoute une recette dont on donne le titre.
	 * @param titre
	 */
	public void ajouterRecette(String titre) {
		recettes.add(new Recette(titre));
	}
	
	/**
	 * Renvoie une copie de la liste des recettes.
	 * (intérêt: le programmeur ne peut pas la modifier directement 
	 * et changer notre liste de recette derrière notre dos).
	 * @return
	 */
	public List<Recette> getRecettes() {
		return new ArrayList<Recette>(recettes);
	}
	
	public int getNombreDeRecettes() {
		return recettes.size();
	}
	/**
	 * Supprime la recette numéro numero.
	 * @param numero un indice (compris entre 0 et le nombre de recettes).
	 */
	public void supprimerRecette(int numero) {
		recettes.remove(numero);		
	}
	
	/**
	 * Retourne une recette à partir de son numéro.
	 * @param numero
	 * @return
	 */
	public Recette getRecette(int numero) {
		return recettes.get(numero);				
	}
	
	/**
	 * Donne une note à la recette numéro numero.
	 * @param numero le numéro de la recette.
	 * @param note la note à donner.
	 */
	public void noterRecette(int numero, int note) {
		recettes.get(numero).ajouterNote(note);
	}
	
	public List<Recette> recettesTrieesParNote() {
		List<Recette> resultat= new ArrayList<Recette>(recettes);
		Collections.sort(resultat, new NoteComparator());
		return resultat;
	}
	
	public List<Recette> recettesTrieesParTitre() {
		List<Recette> resultat= new ArrayList<Recette>(recettes);
		Collections.sort(resultat);
		return resultat;
	}
}
