package exo1;

public class TesteComptes {

	public static void main(String[] args) {
		Compte c1 = new Compte(1, "A", 0);
		Compte c2 = new Compte(2, "B", 0);
		Compte c3;
		c1.depot(500);
		c2.depot(1000);
		c3 = c1;
		c1.affiche(); // point 1
		c2.affiche();

		c3.retrait(10);
		c3.affiche(); // point 2 : que se passe-t-il ici (vue variables)?

		c1.virerVers(75, c2);
		c3.affiche(); // point 3

		Compte[] tc = new Compte[3];
		// Création+initialisation comptes du tableau
		String s = "A"; // point 4
		for (int i = 0; i < tc.length; i++) {
			tc[i] = new Compte(i + 1, s + (i + 1), 200 + i * 100);
		}
		Compte.afficheTabComptes(tc); // point 5
	}
}
