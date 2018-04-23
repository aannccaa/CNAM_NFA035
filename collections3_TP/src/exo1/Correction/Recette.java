package exo1.Correction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

/**
 * Une recette.
 * 
 * P.S. pour les ingrédients, j'ai fait très simple. Il serait sans doute plus intelligent
 * de représenter les quantités comme des objets (avec une représentation explicite de l'unité),
 * et de stocker dans la map des lignes avec l'ingrédient et sa quantité.
 * @author rosmord
 */
public class Recette implements Comparable<Recette> {
	private String titre;
	private double sommeNotes;
	private int nombreDeNotes;
	
	/**
	 * Associe les ingrédient à leurs quantités.
	 */
	private TreeMap<String, Integer> ingredientMap= new TreeMap<>();

	/**
	 * Crée une recette avec un titre (non vide !)
	 * 
	 * @param titre
	 *            le titre (non vide ou null)
	 * @throws IllegalArgumentException
	 *             si titre est null.
	 * @throws NullPointerException
	 *             si titre est vide.
	 */
	public Recette(String titre) {
		if (titre == null)
			throw new NullPointerException();
		if (titre.isEmpty())
			throw new IllegalArgumentException();
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	/**
	 * Ajoute une note.
	 * <p>
	 * condition: note doit être compris entre 1 et 5.
	 * <p>
	 * post condition: la moyenne des notes est à jour.
	 * 
	 * @param note
	 *            un entier entre 1 et 5.
	 * @throws IllegalArgumentException
	 *             si note est hors intervalle.
	 */
	public void ajouterNote(int note) {
		if (note < 1 || note > 5)
			throw new IllegalArgumentException("note hors limites");
		sommeNotes += note;
		nombreDeNotes++;
	}

	/**
	 * Retourne la moyenne des notes obtenues (ou 0 si aucune note). (noter le
	 * second cas !)
	 * 
	 * @return
	 */
	public double getMoyenneNotes() {
		if (nombreDeNotes == 0)
			return 0;
		else
			return sommeNotes / nombreDeNotes;
	}

	@Override
	public String toString() {
		return titre + " note moyenne: " + getMoyenneNotes();
	}

	/**
	 * Compare par titre, puis par note.
	 * <p>
	 * Note: il serait cohérent, comme on implémente Comparable, de redéfinir
	 * aussi equals et hashCode...
	 * <p>
	 * dans ce cas, il faudrait se demander si la recette n'est pas en fin de
	 * compte identifiée par son titre. Auquel cas, seule la comparaison par
	 * titre devrait être effectuée.
	 */
	@Override
	public int compareTo(Recette o) {
		int resultat = this.getTitre().compareTo(o.getTitre());
		if (resultat != 0)
			return resultat;
		resultat = Double.compare(this.getMoyenneNotes(), o.getMoyenneNotes());
		return resultat;
	}
	
	/**
	 * Fixe la quantité d'un ingrédient dans la recette.
	 * <p> Si l'ingrédient était déjà présent, la nouvelle quantité remplace l'ancienne.
	 * @param ingredient le nom de l'ingrédient.
	 * @param quantite la quantité.
	 */
	public void ajouterIngredient(String ingredient, int quantite) {
		ingredientMap.put(ingredient, quantite);
	}
	
	/**
	 * Retourne la liste des ingrédients de la recette.
	 * @return
	 */
	public Collection<String> getIngredients() {
		return new ArrayList<>(ingredientMap.keySet());
	}
	
	/**
	 * Retourne la quantité pour un ingrédient donné. 
	 * REMARQUE: on retourne 0 ici quand l'ingrédient n'est pas présent. On aurait
	 * pu lever une exception. Cependant, on a généralement intérêt à éviter d'introduire
	 * des cas d'erreur. Or, ici, 0 est une assez bonne valeur de retour. Si je veux calculer
	 * la quantité totale de sucre pour toutes mes recettes, je peux faire une boucle et demander
	 * <pre>
	 *   sucre+= recette.getQuantite("sucre");
	 * </pre>
	 * Les recettes sans sucre renverront 0, ce qui colle bien.
	 * @param nomIngredient
	 * @return la quantité pour l'ingrédient en question, ou 0 s'il est absent.
	 */
	public int getQuantite(String nomIngredient) {
		if (ingredientMap.containsKey(nomIngredient)) {
			return ingredientMap.get(nomIngredient);					
		} else {
			return 0;
		}
	}

	/**
	 * Enlève l'ingrédient de la recette.
	 * <p> On a donc: une méthode pour fixer un ingrédient, une pour le supprimer, et de quoi consulter 
	 * la liste des ingrédients. On peut donc tout faire.
	 * @param nomIngredient
	 */
	public void supprimerIngredient(String nomIngredient) {
		ingredientMap.remove(nomIngredient);
	}
}
