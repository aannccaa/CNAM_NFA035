package nfa035.tp2;
/*
 Exercice 2
On vous donne une me ́thode (fausse) pour calculer le maximum d’un tableau : 
Exo2Maximum.maximum. E ́crivez les jeux de tests qui vous paraˆıtront raisonnables 
pour tester cette me ́thode. Corrigez la me ́thode.
 */

public class Exo2Maximum {
	/**
	 * Renvoie le maximum d'un tableau.
	 * 
	 * @param tab
	 *            un tableau non vide
	 * @return le maximum d'un tableau
	 * @throws IllegalArgumentException
	 *             si le tableau est vide
	 * @throws NullPointerException
	 *             si le tab vaut null
	 */
	public static double maximum(double[] tab) throws IllegalArgumentException, NullPointerException{
		if (tab.length == 0) {
			throw new IllegalArgumentException();
		}
		if (tab == null) {
			throw new NullPointerException();
		}
		
		double m = Integer.MIN_VALUE;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > m)
				m = tab[i];
		}
		return m;
	}
}
