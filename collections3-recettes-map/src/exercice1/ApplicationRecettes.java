package exercice1;

import java.util.*;

/**
 * L'application du livre de recette.
 * Notez comment le main ne fait presque rien...
 * @author rosmord
 *
 */
public class ApplicationRecettes {
	private LivreDeRecettes livre= new LivreDeRecettes();
	
	/**
	 * Lance le menu principal de l'application.
	 */
	public void run() {
		String oeufs="oeufs au plat";
		String poulet = "poulet-aux-herbes";
		String[] ti1={"oeufs", "CS huile", "pincee sel et poivre"};
		int[] tq1= {2, 1, 1};
		String[] ti2={"poulet fermier", "CS sel", "CS herbes de Provence"};
		int[] tq2= {1, 2, 4};
		String fondant = "fondant au chocolat";
		String[] ti3={"oeufs", "gr chocolat", "gr sucre", "gr beurre"};
		int[] tq3= {2, 200, 120, 150};
		livre.ajouterRecette(oeufs,ti1,tq1);
		livre.ajouterRecette(poulet,ti2,tq2);
		livre.ajouterRecette(fondant,ti3,tq3);
		livre.noterRecette(oeufs, 5);
		livre.noterRecette(oeufs, 3);
		livre.noterRecette(fondant, 4);
		for (Recette r: livre.getRecettes()) {
			System.out.println(r);
		}	
		List<Recette> l = livre.recettesAvecIngredient("oeufs");
		System.out.println("Recettes avec oeufs : ");
		for (Recette r: l) {
			System.out.println("- "+ r.getTitre());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ApplicationRecettes app= new ApplicationRecettes();
		app.run();
	}

}
