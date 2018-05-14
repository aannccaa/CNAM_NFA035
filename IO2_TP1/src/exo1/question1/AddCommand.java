package exo1.question1;

public class AddCommand extends CommandAvecUneExpression{
	public void executer(Context context) {
		double var = this.expression.evaluer(context);
		double calculatedVal = var + context.getValue();
		context.setValue(calculatedVal);
	}
}
