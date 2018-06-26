package collections1_TP_correction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Exercice 2: livre de recettes (partie 1)
Dans cet exercice nous allons de ́marrer la programmation d’une application simplifie ́e de 
gestion d’un livre de recettes. 
Contraintes d’implantation
Pour ce Tp vous utiliserez un ArrayList afin de maintenir la liste des recettes courantes du livre. 
Lors des Tps suivants il vous sera demande ́ de changer la structure de donne ́es qui permet de 
stocker les recettes du livre. Faites donc particulie`rement attention a` e ́crire votre code 
de manie`re a` ce qu’il soit facile a` faire e ́voluer.

Question 1
Dans un premier temps, l’application doit offrir des ope ́rations pour ajouter et supprimer 
des recettes du livre, pour donner une nouvelle note (de 1 a` 5) a` une recette, pour obtenir 
la moyenne courante des notes, ainsi que les nombres courant de votes et de recettes. 
Vous de ́finirez au moins deux classes: Recette et LivreRecettes. Dans la classe Recette demandez 
a` Eclipse de ge ́ne ́rer et d’ajouter la me ́thode String toString();, afin de renvoyer une chaˆıne 
contenant le nom de la recette et la moyenne courante de ses notes.

Question 2
1. Ecrivez un programme main qui utilise vos classes. Lors du prochain tp vos e ́crirez la boucle 
qui propose un menu d’ope ́rations et vous ajouterez e ́galement les traitements d’exceptions 
ne ́ce ́ssaires pour ge ́rer les erreurs.
2. Testez avec Junit la classe Recette et la classe LivreRecettes. Attention: les me ́thodes qui 
font des entre ́es/sorties ne se preˆtent pas aux tests unitaires. Si vous en avez de ́ja` ajouté, 
ne les testez pas!
3. Ajoutez dans vos classes les me ́thodes ne ́cessaires a` l’affichage du livre des recettes.

Question 3
Vous devez maintenant faire en sorte que l’on puisse trier les recettes du livre:
1. par ordre des notes via un Comparator. Testez votre solution avec Junit.
2. Modifiez maintenant la classe Recette de sorte qu’elle implante Comparable pour l’ordre 
alphabe ́tique des re- cettes. Testez cet ordre.
3. Ajoutez des me ́thodes dans la classe LivreRecettes permettant d’afficher les recettes selon 
les deux ordres im- plante ́s.
 */

public class Recette implements Comparable<Recette> {
	private String nom;
	private List<Integer> notes;
	Map<String, Integer> ingredients; 

	public Recette(String nom) {
		this.nom = nom;
		this.notes = new ArrayList<>();
		this.ingredients = new TreeMap<>();
	}

	public String getNom() {
		return this.nom;
	}

	public void addNote(int note) {
		if (note > 5 || note < 0) {
			String message = "La note doite être comprise entre 1 et 5";
			throw new RuntimeException(message);
		}
		this.notes.add(note);
	}

	public int getNbNotes() {
		return this.notes.size();
	}

	public double getMoyenneNotes() {
		int somme = 0;
		for (int n : this.notes) {
			somme = somme + n;
		}
		if (this.getNbNotes() == 0) {
			return 0;
		}
		double moyenne = (1.0 * somme) / this.getNbNotes();
		return moyenne;
	}

	public String toString() {
		return String.format("   '%s', (note moyenne: %.1f sur %d notes)", this.getNom(), this.getMoyenneNotes(),
				this.getNbNotes());
	}

	public void afficher() {
		System.out.println(toString());
	}

	// compara dupa nume reteta
	@Override
	public int compareTo(Recette o) {
		if (o == null) {
			return this.getNom().compareTo(null);
		}
		return this.getNom().compareTo(o.getNom());
	}
	
	public void addIngredient(String ingredient, int qte) {
		this.ingredients.put(ingredient, qte);
	}
	
	public List<String> getIngredients(){
		List<String> result = new ArrayList<>(this.ingredients.keySet());
		return result; 
	}
	
	public int getQuantite(String ingredient) {
		if(this.ingredients.containsKey(ingredient)) {
			return this.ingredients.get(ingredient);
		}
		return 0;
	}

}
