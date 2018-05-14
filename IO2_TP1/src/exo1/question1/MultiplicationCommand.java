package exo1.question1;

public class MultiplicationCommand extends CommandAvecUneExpression {
	public void executer(Context context) {
		double var = this.expression.evaluer(context);
		double calculatedValue = var * context.getValue();
		context.setValue(calculatedValue);
	}
}
