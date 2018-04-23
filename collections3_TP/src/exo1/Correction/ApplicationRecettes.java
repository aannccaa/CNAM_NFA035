package exo1.Correction;


/**
 * L'application du livre de recette.
 * Notez comment le main ne fait presque rien...
 * @author rosmord
 *
 */
public class ApplicationRecettes {
	private static final String POULET_FRITES = "poulet-frites";
	private static final String OEUFS_AU_PLAT = "oeufs au plat";
	private LivreDeRecettes livre= new LivreDeRecettes();
	
	/**
	 * Lance le menu principal de l'application.
	 */
	public void run() {
		livre.ajouterRecette(OEUFS_AU_PLAT);
		livre.ajouterRecette(POULET_FRITES);
		livre.noterRecette(OEUFS_AU_PLAT, 5);
		livre.noterRecette(POULET_FRITES, 3);
		for (Recette r: livre.getRecettes()) {
			System.out.println(r);
		}		
	}
	
	public static void main(String[] args) {
		ApplicationRecettes app= new ApplicationRecettes();
		app.run();
	}

}
