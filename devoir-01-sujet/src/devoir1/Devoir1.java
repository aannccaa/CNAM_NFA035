package devoir1;

/**
 * Une classe utilitaire avec diverses méthodes concernant les tableaux.
 * 
 * @author rosmord
 *
 */
public class Devoir1 {

	/**
	 * Prend en argument un tableau, et renvoie la seconde plus grande valeur dans
	 * ce tableau.
	 * <p>
	 * Formellement, si max(tab) est la plus grande valeur dans le tableau, renvoie
	 * une valeur du tableau inférieure à max(tab), mais supérieure à toutes les
	 * autres.
	 * <p>
	 * Dans tous les cas où il n'y a pas de seconde valeur définie dans le tableau,
	 * on <em>doit</em> renvoyer une RuntimeException.
	 * <p>
	 * Quelques exemples :
	 * <ul>
	 * <li>pour {8,2,5,7}, renverra 7
	 * <li>pour {8,8, 2, 6, 7,7, 2,2,2} renverra 7
	 * </ul>
	 * 
	 * @param tab
	 * @return la seconde plus grande valeur du tableau.
	 * @throws RuntimeException
	 *             en cas de problème de définition.
	 */
	public static int secondeValeur(int tab[]) throws RuntimeException {
		if (tab == null) {
			throw new RuntimeException("Le tableau ne peut pas être null");
		}
		if (tab.length < 2) {
			throw new RuntimeException("Le tableau doit avoir au moins 2 valeurs");
		}
		int[] max = new int[2];
		max[0] = tab[0];
		int idxTab = 1;
		while (idxTab < tab.length && tab[idxTab] == tab[0]) {
			idxTab++;
		}
		if (idxTab == tab.length) {
			throw new RuntimeException("Le tableau doit avoir au moins 2 valeurs differentes");
		}
		max[1] = tab[idxTab];
		idxTab++;
		
		
		if (max[1] > max[0]) {
			swap(max);
		}
		
		for (int i = idxTab; i < tab.length; i++) {
			int currentValue = tab[i];
			
			if ((currentValue == max[0]) || (currentValue == max[1])) {
				continue;
			}
			
			if (currentValue > max[1]) {
				max[1] = currentValue;
			}
			if (max[1] > max[0]) {
				swap(max);
			}
		}
		return max[1];
	}

	private static void swap(int[] tab) {
		int tmp;
		tmp = tab[0];
		tab[0] = tab[1];
		tab[1] = tmp;
	}

	public static void afficherTab(int[] tab) {
		String sep = "";
		System.out.print("{");
		for (int i = 0; i < tab.length; i++) {
			System.out.print(sep + tab[i]);
			sep = ";";
		}
		System.out.println("}");
	}
}
