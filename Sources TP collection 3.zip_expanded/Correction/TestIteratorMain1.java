
package solutioncartes;


/**
 *
 * Test pour la question 7
 */
public class TestIteratorMain1 {
	public static void main(String[] args) {
		MainJoueur1 m = new MainJoueur1();

		m.add(new Carte(10, Couleur.Carreau));
		m.add(new Carte(1, Couleur.Coeur));
		m.add(new Carte(10, Couleur.Trefle));

		if (m.contient(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		// Test pour la question 7: itération sur une MinJoeur1
		for( Carte c: m){
			System.out.println(c.toString());
		}
	}
}
