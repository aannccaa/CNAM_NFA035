package colectii.cartiJoc;

public final class Culoare { // final <=> nu se poate mosteni
	public static final int CARO = 1; // final <=> nu se poate modifica
	public static final int INIMA_ROSIE = 2;
	public static final int TREFLA = 3;
	public static final int INIMA_NEAGRA = 4;

	public static void validate(int culoare) {
		if (culoare < CARO || culoare > INIMA_NEAGRA) {
			throw new RuntimeException("Culoare invalida");
		}

	}

	public static String toString(int culoare) {
		validate(culoare);
		switch (culoare) {
		case CARO:
			return "caro";
		case INIMA_NEAGRA:
			return "inima neagra";
		case INIMA_ROSIE:
			return "inima rosie";
		// urmatoarele linii returneaza trefla, pentru ca "case trefla" nu are break
		case TREFLA:
		default:
			return "trefla";
		}

	}
}
