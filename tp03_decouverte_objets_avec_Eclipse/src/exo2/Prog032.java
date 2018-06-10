package exo2;

public class Prog032 implements AvecNote, Affichable {
	private double session1; // note session 1
	private double session2; // note session 2
	private String code = "NFA032";

	public Prog032(double s1, double s2) {
		session1 = s1;
		session2 = s2;
	}

	public double getSession1() {
		return session1;
	}

	public double getSession2() {
		return session2;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public double calculeNote() {
		if (session1 >= 10 || session2 == 0)
			return session1;
		else
			return session2;
	}

	public String toString() {
		return (getCode() + " Notes: session1=" + session1 + ", session2=" + session2);
	}
	
	public void afficher() {
		System.out.println(this.toString());
	}
}
