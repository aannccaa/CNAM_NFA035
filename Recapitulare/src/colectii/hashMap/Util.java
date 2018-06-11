package colectii.hashMap;

import java.util.Collection;

public class Util {

	public static double getMedie(Collection<Double> valori) {
		int nbValori = 0;
		double suma = 0;
		for (Double c : valori) {
			nbValori++;
			suma = suma + c;
		}
		if (nbValori == 0) {
			return 0;
		}
		return suma / nbValori;
	}

	public static double getMin(Collection<Double> valori) {
		double min = Double.MAX_VALUE;
		boolean hasValues = false;
		for (Double c : valori) {
			if (c < min) {
				min = c;
				hasValues = true;
			}
		}

		if (hasValues) {
			return min;
		}
		// daca nu are valori returneaza 0
		return 0;
	}
}
