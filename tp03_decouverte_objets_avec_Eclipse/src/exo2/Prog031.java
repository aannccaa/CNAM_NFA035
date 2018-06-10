package exo2;

public class Prog031 implements AvecNote, Affichable {
	private double session1;
	private double session2;
	private String code = "NFA031";

	public Prog031(double session1, double session2) {
		this.session1 = session1;
		this.session2 = session2;
	}

	public double getSession1() {
		return this.session1;
	}

	public double getSession2() {
		return this.session2;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public double calculeNote() {
		return session1 > session2 ? session1 : session2;
	}

	public String toString() {
		return this.getCode() + " Notes: session 1: " + this.getSession1() + " , session 2: " + this.getSession2();
	}
	
	public void afficher() {
		System.out.println(this.toString());
	}

}
