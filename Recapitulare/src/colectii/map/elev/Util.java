package colectii.map.elev;

import java.util.Collection;

public final class Util {
	public static double getMedia(Collection<Double> valori) {
		double result = 0;
		if (valori != null && valori.size() != 0) {
			for (Double valoare : valori) {
				result = result + valoare;
			}
			result = result / valori.size();
		}
		return result;
	}
}
