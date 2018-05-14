package exo1.question1;

public class ConstantExpression implements Expression{
	public final double value;
	
	public ConstantExpression(double value) {
		this.value = value;
	}

	@Override
	public double evaluer(Context context) {
		return this.value;
	}
}
