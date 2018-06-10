package exo1.question2;

public class SetCommande implements Commande{
	private String variable;

	public SetCommande(String variable) {
		super();
		this.variable = variable;
	}
	
	@Override
	public void executer(Contexte contexte) {
		contexte.setValeur(variable, contexte.getValeur());
	}
}
