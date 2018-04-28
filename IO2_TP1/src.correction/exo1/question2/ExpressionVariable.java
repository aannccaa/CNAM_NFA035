package exo1.question2;

public class ExpressionVariable implements Expression{
	private String variable;

	public ExpressionVariable(String variable) {
		this.variable = variable;
	}
	
	@Override
	public double evaluer(Contexte c) {
		return c.getValeur(variable);
	}
}
