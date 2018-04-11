
public class Main {
	
	
	public static void main(String[] args) {
	Banque bnp = new Banque("BNP");
	Titulaire toto = new Titulaire("Toto");
	Titulaire titi = new Titulaire("Titi");
	Titulaire[] toto_titi = {toto, titi};
	
	Titulaire mimi = new Titulaire("Mimi");
	Titulaire[] mimiT = {mimi};
	Titulaire coco = new Titulaire("Coco");
	Titulaire[] cocoT = {coco};
	
	bnp.creerCompte(toto_titi, 100);
	bnp.creerCompte(cocoT, 300);
	bnp.creerCompte(mimiT, 0);
	
	System.out.println("======== afficher");
	bnp.afficher();
	System.out.println("======== afficher par solde");
	bnp.afficheParSolde();
	bnp.suprimerComptesSoldeNull();
	System.out.println("======== afficher par solde");
	bnp.afficheParSolde();
	
	}
}
