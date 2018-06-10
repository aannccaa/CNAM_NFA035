package CalculetteCata;

/**
 * Model
 *
 */
public class Calculette {

	private double resultat;
	private double input;

	public double getResultat() {
		return this.resultat;
	}

	public double getInput() {
		return this.input;
	}

	public void setInput(double value) {
		this.input = value;
	}

	public void effacer() {
		this.resultat = 0;
		this.input = 0;
	}

	public void ajouter() {
		this.resultat = this.resultat + this.input;
	}
}
