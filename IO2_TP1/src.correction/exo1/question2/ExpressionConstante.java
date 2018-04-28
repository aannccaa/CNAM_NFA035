package exo1.question2;

public class ExpressionConstante implements Expression{
	private double valeur;
	
	public ExpressionConstante(double valeur) {
		this.valeur= valeur;
	}
	
	@Override
	public double evaluer(Contexte c) {
		return valeur;
	}
}
