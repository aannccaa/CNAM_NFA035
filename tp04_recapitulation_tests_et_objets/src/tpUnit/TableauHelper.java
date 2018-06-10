package tpUnit;

public class TableauHelper {

	/**
	 * Retourne l'inverse d'un tableau t.
	 * <p>
	 * pré-condition: t est non nul
	 * <p>
	 * post-condition: t est inchangé, et le résultat est l'inverse de t.
	 * 
	 * @param t
	 *            un tableau non nul, éventuellement vide.
	 * @return un tableau inverse de t (la première case est la première, etc...)
	 * @throws NullPointerException
	 *             si t est nul.
	 */
	public static char[] inverser(char[] t) throws NullPointerException {
		if (t == null) {
			throw new NullPointerException();
		}
		char[] result = new char[t.length];
		int j = 0;
		for (int i = t.length - 1; i >= 0; i--) {
			result[j] = t[i];
			j++;
		}
		return result;
	}

	/**
	 * Concatène les tableaux t1 et t2 (qui sont éventuellement vides)
	 * <p>
	 * pré-condition: t1 et t2 sont non nuls
	 * <p>
	 * post-condition: t1 et t2 sont inchangés, et le résultat contient, d'abord et
	 * dans l'ordre, les éléments de t1, puis les éléments de t2.
	 * 
	 * @param t1
	 * @param t2
	 * @return un tableau qui est la concaténation de t1 et t2.
	 * @throws NullPointerException
	 *             si t1 ou t2 sont nuls
	 */
	public static int[] concatener(int t1[], int t2[]) throws NullPointerException {
		if (t1 == null || t2 == null) {
			throw new NullPointerException();
		}
		int[] result = new int[t1.length + t2.length];
		int j = 0;
		for (int i = 0; i < t1.length; i++) {
			result[j] = t1[i];
			j++;
		}
		for (int i = 0; i < t2.length; i++) {
			result[j] = t2[i];
			j++;
		}
		return result;
	}

	/**
	 * Retourne un sous tableau de t.
	 * <p>
	 * précondition: t est non nul, et debut est inférieur ou égal à fin.
	 * <p>
	 * post condition: retourne un tableau contenant toutes les cases de t dont
	 * l'indice est compris dans l'intervale [début,fin[ (fin exclu).
	 * <p>
	 * post-condition: le tableau retourné aura une adresse différente de celle de
	 * t.
	 * <p>
	 * Note: si début et fin sont égaux, le tableau retourné doit être vide.
	 * <p>
	 * Note: la manière dont la post-condition est écrite autorise debut et fin à
	 * être en dehors des limites de la taille du tableau t. Par exemple, si début=0
	 * et fin=1000, et que t est de taille 10, le tableau retourné sera une copie de
	 * t.
	 * 
	 * @return un tableau.
	 * @throws NullPointerException
	 *             si t est nul
	 * @throws IllegalArgumentException
	 *             si debut est supérieur à fin.
	 */
	public static char[] sousTableau(char t[], int debut, int fin)
			throws NullPointerException, IllegalArgumentException {
		if (t == null) {
			throw new NullPointerException();
		}
		if (debut > fin) {
			throw new IllegalArgumentException();
		}
		if (fin > t.length - 1) {
			fin = t.length;
		}
		if (debut < 0) {
			debut = 0;
		}

		char[] result = new char[fin - debut];
		for (int i = debut; i < fin; i++) {
			result[i - debut] = t[i];
		}
		return result;
	}

	public static void afficherTableau(char[] t) {
		String sep = "";
		System.out.print("{");
		for (int i = 0; i < t.length; i++) {
			System.out.print(sep + t[i]);
			sep = "; ";
		}
		System.out.println("}");
	}
}
