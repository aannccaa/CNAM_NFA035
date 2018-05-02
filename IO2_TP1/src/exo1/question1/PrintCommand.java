package exo1.question1;

public class PrintCommand implements Command{

	@Override
	public void executer(Context context) {
		System.out.println(context.getValue());
	}
}
