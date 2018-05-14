package exo1.question1;

public class PrintCommand extends CommandSansParametres{
	public void executer(Context context) {
		System.out.println(context.getValue());
	}
}
