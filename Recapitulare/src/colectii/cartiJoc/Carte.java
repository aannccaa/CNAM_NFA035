package colectii.cartiJoc;

public class Carte implements Comparable<Carte> {
	int numar;
	int culoare;

	public Carte(int numar, int culoare) {
		valideazaNumar(numar);
		Culoare.validate(culoare);
		this.numar = numar;
		this.culoare = culoare;
	}

	public int getCuloare() {
		return this.culoare;
	}

	public int getNumar() {
		return this.numar;
	}

	// vezi metoda "compareTo_Cata(Carte c)" mai compacta
	// ordine de putere in fc de culoare: INIMA_NEAGRA > TREFLA > INIMA_ROSIE > CARO
	@Override
	public int compareTo(Carte c) {
		if (c == null) {
			return 1; // orice carte e mai mare ca o carte nulla
		}
		int numar1 = getValoareCarte(this.getNumar());
		int numar2 = getValoareCarte(c.getNumar());
		
		// compar dupa numar
		if (numar1 > numar2) {
			return 1;
		}
		if (numar1 < numar2) {
			return -1;
		}
		// aici numerele sunt egale

		// le compar dupa culoare
		if (this.getCuloare() > c.getCuloare()) {
			return 1;
		}
		if (this.getCuloare() < c.getCuloare()) {
			return -1;
		} else {
			return 0;
		}
	}

	// daca cartea e 1 (o consider As, cu valoarea cea mai mare = 15)
	public static int getValoareCarte(int numarCarte) {
		if (numarCarte == 1) {
			return 15;
		} else {
			return numarCarte;
		}
	}

	public int compareTo_Cata(Carte c) {
		if (c == null) {
			return 1;
		}
		int result = this.getNumar() - c.getNumar();// daca e pozitiv, this>c
		if (result == 0) {
			result = this.getCuloare() - c.getCuloare();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();

		// inlocuieste liniile urmatoare, generate de eclipse, care sunt mai eficiente

		// final int prime = 31;
		// int result = 1;
		// result = prime * result + culoare;
		// result = prime * result + numar;
		// return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return this.compareTo(other) == 0;
	}

	public String toString() {
		String str = String.format("%d de %s", this.getNumar(), Culoare.toString(this.getCuloare()));
		return str;
	}

	public static void valideazaNumar(int numarCarte) {
		if (numarCarte < 1 || numarCarte > 14 || numarCarte == 11) {
			throw new RuntimeException("Numar carte invalid");
		}
	}
}
