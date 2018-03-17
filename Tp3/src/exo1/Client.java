package exo1;

public class Client {
	private String nom;
	private Compte c;

	public Client(String n, Compte mc) {
		nom = n;
		c = mc;
	}

	public void depot(double m) {
		c.depot(m);
	}

	public void retrait(double m) {
		c.retrait(m);
	}

	public void affiche() {
		System.out.println("Client " + nom + " avec compte: ");
		c.affiche();
	}
}
