package exo1.question1;

public class PrintVarCommand extends CommandAvecUneVariable {

	@Override
	public void executer(Context context) {
		System.out.println(context.getVariable(this.nomVariable));
	}

}
