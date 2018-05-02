package exo1.question1;

public class MultiplicationCommand implements Command{
	double value;
	
	public MultiplicationCommand(double value) {
		this.value = value;
	}
	@Override
	public void executer(Context context) {
		double calculatedValue = this.value * context.getValue();
		context.setValue(calculatedValue);
		
	}

}
