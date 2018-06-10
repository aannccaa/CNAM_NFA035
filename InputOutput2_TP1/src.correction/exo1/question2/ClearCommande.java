package exo1.question2;

public class ClearCommande implements Commande {

	@Override
	public void executer(Contexte contexte) {
		contexte.setValeur(0);
	}
	
}
