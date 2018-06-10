
package collections2.exercice2;


/**
 *
 * Test pour la question 7
 */
public class TestIteratorMain1 {
	public static void main(String[] args) {
		MainJoueur1 m = new MainJoueur1();

		m.add(new Carte(10, Couleur.CARREAU));
		m.add(new Carte(1, Couleur.COEUR));
		m.add(new Carte(10, Couleur.TREFLE));

		if (m.contient(new Carte(10, Couleur.CARREAU))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		// Test pour la question 5: itération sur une MinJoeur1
		for(Carte c: m){
			System.out.println(c.toString());
		}
	}
}
