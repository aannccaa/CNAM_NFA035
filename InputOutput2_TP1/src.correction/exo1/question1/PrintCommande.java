package exo1.question1;

public class PrintCommande implements Commande {
	@Override
	public void executer(Contexte contexte) {
		System.out.println(contexte.getValeur());
	}
}
