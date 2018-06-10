package exo1.question2;

public class MultCommande implements Commande {
	private Expression expression;

	public MultCommande(Expression expression) {
		this.expression = expression;
	}

	@Override
	public void executer(Contexte contexte) {
		double nouvelleValeur =
				expression.evaluer(contexte) 
				* contexte.getValeur();
		contexte.setValeur(nouvelleValeur);
	}

}
