package exo1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Exercice 2: livre de recettes (partie 1)
Dans cet exercice nous allons demarrer la programmation d’une application simplifiee 
de gestion d’un livre de recettes. Nous reprendrons ce code pendant plusieurs Tps afin de 
le compléter. N’oubliez pas de commenter votre code au format javadoc afin de pouvoir 
tester ces classes. Cet exercice doit être réalisé dans sa totalité au fil des Tps: 
si vous ne terminez pas aujourd’hui, continuez le avant d’entamer la suite au prochain tp.

Contraintes d’impléméntation
Pour ce Tp vous utiliserez un ArrayList afin de maintenir la liste des recettes courantes 
du livre. Lors des Tps suivants il vous sera demandé de changer la structure de donnees 
qui permet de stocker les recettes du livre. Faites donc particulierement attention à 
écrire votre code de maniere à ce qu’il soit facile à faire évoluer.

Question 1
Dans un premier temps, l’application doit offrir des operations pour ajouter et supprimer 
des recettes du livre, pour donner une nouvelle note (de 1 à 5) à une recette, pour obtenir 
la moyenne courante des notes, ainsi que les nombres courant de votes et de recettes. 
Vous definirez au moins deux classes: Recette et LivreRecettes. Dans la classe Recette 
demandez à Eclipse de générer et d’ajouter la méthode String toString();, afin de renvoyer 
une chaîne contenant le nom de la recette et la moyenne courante de ses notes.

Question 2
1. Ecrivez un programme main qui utilise vos classes. Lors du prochain tp vous écrirez la 
boucle qui propose un menu d’operations et vous ajouterez egalement les traitements 
d’exceptions necéssaires pour gérer les erreurs.
2. Testez avec Junit la classe Recette et la classe LivreRecettes. Attention: les méthodes 
qui font des entrées/sorties ne se pretent pas aux tests unitaires. Si vous en avez dejà 
ajouté, ne les testez pas!
3. Ajoutez dans vos classes les méthodes necessaires à l’affichage du livre des recettes.

Question 3
Vous devez maintenant faire en sorte que l’on puisse trier les recettes du livre:
1. par ordre des notes via un Comparator. Testez votre solution avec Junit.
2. Modifiez maintenant la classe Recette de sorte qu’elle implémente Comparable pour l’ordre 
alphabetique des recettes. Testez cet ordre.
3. Ajoutez des méthodes dans la classe LivreRecettes permettant d’afficher les recettes 
selon les deux ordres implementées.
 */
public class Main {

	public static void main(String[] args) {
		LivreRecettes livre;
		Recette glaceVanille;
		Recette brownie;
		Recette tarteCitron;
		Map<String, Integer> ingredients_glaceVanille = new HashMap<>();
		Set<Map.Entry<String, Integer>> gv = ingredients_glaceVanille.entrySet();

		livre = new LivreRecettes("Desserts inoubliables");
	
		//glaceVanille.setIngredients(ingredients_glaceVanille);
		
		glaceVanille = new Recette("Glace à la vanille");
		ingredients_glaceVanille.put("cl. lait", 500);
		ingredients_glaceVanille.put("g. sucre", 150);
		ingredients_glaceVanille.put("sachet vanille", 1);
		System.out.println(gv.toString());
		
		brownie = new Recette("Brownie");
		
		tarteCitron = new Recette("Tarte au citron");
		livre.addRecette(glaceVanille);
		livre.addRecette(brownie);
		livre.addRecette(tarteCitron);
		glaceVanille.addNote(5);
		glaceVanille.addNote(2);
		brownie.addNote(2);

		OrdreRecettes ordreParNom = OrdreRecettes.PAR_NOM;
		livre.afficherLivreTrie(ordreParNom);
		
		OrdreRecettes ordreParNotes = OrdreRecettes.PAR_NOTES;
		livre.afficherLivreTrie(ordreParNotes);

		String ingredient = "lait";
		System.out.println("recettes avec '" + ingredient + "': ");
		List<Recette> l = livre.recettesAvecIngredient(ingredient);
		for(Recette r : l) {
			System.out.println(" - " + r.getNom());
		}
	}

}
