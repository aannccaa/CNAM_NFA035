package exercice2;


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
		livre.ajouterRecette("oeufs au plat");
		livre.ajouterRecette("poulet-frites");
		livre.noterRecette(0, 5);
		livre.noterRecette(0, 3);
		for (Recette r: livre.getRecettes()) {
			System.out.println(r);
		}		
	}
	
	public static void main(String[] args) {
		ApplicationRecettes app= new ApplicationRecettes();
		app.run();
	}

}
