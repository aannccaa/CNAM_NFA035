package exo1.question1;

public class AddCommande implements Commande{
	double val;

	public AddCommande(double val) {
		this.val = val;
	}

	@Override
	public void executer(Contexte contexte) {
		contexte.setValeur(this.val + contexte.getValeur());
	}
	
	
	
}
