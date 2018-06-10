package exo2;

public class Prog035 implements AvecNote, Affichable {
	private double devoir1;
	private double devoir2;
	private double exam;
	private String code = "NFA035";

	public Prog035(double p1, double p2, double e) {
		devoir1 = p1;
		devoir2 = p2;
		exam = e;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public double calculeNote() {
		return (devoir1 + devoir2)/2 * 0.4 + exam * 0.6;
	}
	
	public String toString() {
		return this.getCode() + " Notes: devoir1=" + devoir1 + ", devoir2=" + devoir2 + ", exam=" + exam;
	}
	
	public void afficher() {
		System.out.println(this.toString());
	}
}
