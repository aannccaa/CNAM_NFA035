package exo1.question2;

public class AddCommande implements Commande{
	private Expression expression;
	
	public AddCommande(Expression expression) {
		super();
		this.expression = expression;
	}

	@Override
	public void executer(Contexte contexte) {
		double nouvelleValeur =
				expression.evaluer(contexte) 
				+ contexte.getValeur();
		contexte.setValeur(nouvelleValeur);
	}
	
	
	
}
