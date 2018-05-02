package exo1.question1;

public class AddCommand implements Command{
	double value;
	
	public AddCommand(double value) {
		this.value = value;
	}

	@Override
	public void executer(Context context) {
		double calculatedVal = this.value + context.getValue();
		context.setValue(calculatedVal);
	}

}
