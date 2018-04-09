
public class Main {
	
	
	public static void main(String[] args) {
	Banque bnp = new Banque("BNP");
	Titulaire t1 = new Titulaire("Toto");
	Titulaire t2 = new Titulaire("Titi");
	Titulaire[] titulaires = {t1, t2};

	bnp.creerCompte(titulaires, 100);
	bnp.afficher();
	}
}
