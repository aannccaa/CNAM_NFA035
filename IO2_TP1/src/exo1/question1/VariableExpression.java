package exo1.question1;

public class VariableExpression implements Expression {
	public final String nomVariable;

	public VariableExpression(String nomVariable) {
		this.nomVariable = nomVariable;
	}

	public double evaluer(Context context) {
		return context.getVariable(this.nomVariable);
	}

}
