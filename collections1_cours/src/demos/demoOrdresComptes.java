package demos;

public class demoOrdresComptes {

	public static void main(String[] args) {
		Compte c1 = new Compte(1, 2500);
		Compte c2 = new Compte(7, 200);
		Compte c3 = new Compte(3, 45);
		Client lucie = new Client("Lucie");
		lucie.affiche();
		lucie.ajout(c2);
		lucie.ajout(c1);
		lucie.ajout(c3);
		lucie.ajout(c2); // doublon
		lucie.afficheParSolde();
		lucie.affiche();
	}

}
