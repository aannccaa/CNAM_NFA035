package colectii.map.elev;

public class Nota implements Comparable<Nota> {
	public final double nota;
	public final String numeElev;
	public final String materie;

	public Nota(double nota, String numeElev, String materie) {
		this.nota = nota;
		this.numeElev = numeElev;
		this.materie = materie;
	}

	public String toString() {
		return toString(true, true);
	}

	public String toString(boolean numeElev, boolean materie) {
		String n = numeElev ? this.numeElev + " " : "";
		String m = materie ? this.materie + " " : "";
		return String.format("%s%s%.2f", n, m, this.nota);
	}

	@Override
	public int compareTo(Nota o) {
		if (o == null) {
			return 1;
		}
		int result = this.numeElev.compareTo(o.numeElev);
		if (result == 0) {
			result = this.materie.compareTo(o.materie);
		}
		if (result == 0) {
			result = new Double(this.nota).compareTo(o.nota);
		}
		return result;
	}

}
