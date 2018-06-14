package colectii.map.strada;

public class Persoana {
	private String nume;

	public Persoana(String nume) {
		this.nume = nume;
	}

	public String getNume() {
		return this.nume;
	}

	public String toString() {
		return String.format("%s", this.getNume());
	}
}
