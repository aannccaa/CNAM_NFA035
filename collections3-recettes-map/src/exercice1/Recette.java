package exercice1;

import java.util.*;


/**
 * Une recette.
 * 
 * @author rosmord, aponte
 */
public class Recette implements Comparable<Recette> {
	private String titre;
	private double sommeNotes;
	private int nombreDeNotes;
	private HashMap<String,Integer> ingredients;

	/**
	 * Crée une recette avec un titre (non vide !).
	 * Les tableaux ingre et quant doivent être de même taille.
	 * 
	 * @param titre
	 *            le titre (non vide ou null)
	 * @throws IllegalArgumentException
	 *             si titre est null ou 
	 *             si ingre et quant ont des tailles différentes ou
	 *             si un ingredient est en double
	 * @throws NullPointerException
	 *             si titre est vide.
	 * @throws NullPointerException 
	 *             si ingre ou quant null.
	 */
	
	public Recette(String titre, String[] ingre, int[] quant) {
		if (titre == null)
			throw new NullPointerException();
		if (titre.isEmpty())
			throw new IllegalArgumentException();
		if (ingre.length != quant.length)
			throw new IllegalArgumentException();
		this.titre = titre;
		ingredients = new HashMap<String,Integer>();
		this.ajouterIngredients(ingre,quant);
	}
	
	/**
	 * Crée une recette avec un titre (non vide !) et une liste d'ingerdients vide.
	 * Les tableaux ingre et quant doivent être de même taille.
	 * 
	 * @param titre
	 *            le titre (non vide ou null)
	 * @throws IllegalArgumentException
	 *             si titre est null ou 
	 * @throws NullPointerException
	 *             si titre est vide.
	 * @throws NullPointerException 
	 */
	public Recette(String titre) {
		if (titre == null)
			throw new NullPointerException();
		if (titre.isEmpty())
			throw new IllegalArgumentException();
		this.titre = titre;
		ingredients = new HashMap<String,Integer>();
	}

	public String getTitre() {
		return titre;
	}
	/*
	/**
	 * Ajoute un ingrédient dans la liste des ingredients, sauf s'il est
	 * déjà dedans.
	 * @param i
	 * @param q
	 * @return
	 */	
	/*
	public boolean ajouterIngredient(String i, int q){
		if (ingredients.containsKey(i))
			return false;
		ingredients.put(i, q);
		return true;
	}
	*/
	public void ajouterIngredients(String[] ingre, int[] quant){
		int i=0;
		for(String s: ingre){
			ingredients.put(s, quant[i]);
			i++;
		}
	}
	
	public boolean contientIngredient(String i){
		return ingredients.containsKey(i);
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
		String igs="";
		for (Map.Entry<String,Integer> i: ingredients.entrySet()) {
			igs= igs+i.getValue()+" "+ i.getKey()+ "\n ";
		}
		return titre +" - note moyenne: " + getMoyenneNotes() + "\n Ingredients: \n "+ igs ;
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
}
