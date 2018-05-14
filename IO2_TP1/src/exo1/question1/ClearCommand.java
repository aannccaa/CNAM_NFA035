package exo1.question1;

public class ClearCommand extends CommandSansParametres{
	public void executer(Context context) {
		context.setValue(0);
	}
}
