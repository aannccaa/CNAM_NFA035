package exo1.question1;

import java.util.HashMap;
import java.util.Map;

public class Context {
	double value = 0;
	Map<String, Double> variables = new HashMap<>();

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setVariable(String nomVariable, double value) {
		this.variables.put(nomVariable, value);
	}

	public double getVariable(String nomVariable) {
		return this.variables.get(nomVariable);
	}
}
