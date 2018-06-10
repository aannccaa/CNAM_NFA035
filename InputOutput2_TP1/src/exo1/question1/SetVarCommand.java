package exo1.question1;

public class SetVarCommand extends CommandAvecUneVariable {

	public void executer(Context context) {
		double value = context.getValue();
		context.setVariable(this.nomVariable, value);
	}
}
