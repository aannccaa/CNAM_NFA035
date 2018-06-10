package exo1;

public class TesteClient {

	public static void main(String[] args) {
		Compte c = new Compte(1, "Alice et Bob", 0);
		Client alice = new Client("Alice", c);
		Client bob = new Client("Bob", c);
		alice.affiche(); // 1
		alice.depot(1000);
		alice.affiche(); // 2
		bob.retrait(550);
		alice.affiche(); // 3
		Client[] tcc = new Client[2];
		tcc[0] = alice; // 4
		tcc[1] = bob;
		tcc[1].depot(20);
		tcc[0].affiche(); // 5
		tcc[1].affiche();
	}
}
