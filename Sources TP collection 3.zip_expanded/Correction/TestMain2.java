
package solutioncartes;

/**
 *
 */
public class TestMain2 {
    public static void main(String[] args) {
		MainJoueur2 m = new MainJoueur2();

		m.add(new Carte(5, Couleur.Carreau));
                m.add(new Carte(4, Couleur.Carreau));
                m.add(new Carte(3, Couleur.Carreau));
		m.add(new Carte(1, Couleur.Coeur));
                //m.add(new Carte(7, Couleur.Trefle));

		if (m.contient(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
                for( Carte c: m){
                    System.out.println(c.toString());
                }
                System.out.println("Il y a "+ m.getNombreCouleurs()+""
                        + " couleurs dans la main.");
                if (m.estSuite()){
                    System.out.println("La main est une suite");

                } else 
                    System.out.println("La main n'est pas une suite");
	}
    
}
