package nfa035.tp2;

/**
 * On représente une date avec un tableau de 3 entiers.
 * <ul>
 * <li>case 0 : numéro du jour
 * <li>case 1 : numéro du mois
 * <li>case 2 : numéro de l'année
 * </ul>
 * 
 * @author rosmord
 * 
 */
public class Dates {

	/**
	 * Retourne le nom du mois numéro numero.
	 * 
	 * @param numero
	 *            le numéro du mois (commence à 1)
	 * @return le nom du mois.
	 * @throws IllegalArgumentException si mois n'est pas entre 1 et 12.
	 */
	public static String nomMois(int numero) {
		return null;
	}

	/**
	 * Renvoie vrai si une année est bissextile.
	 * @param annee
	 * @return
	 */
	public static boolean estBissextile(int annee) {
		return false;
	}

	/**
	 * retourne la représentation de la date sous forme de String.
	 * 
	 * @param date
	 * @return
	 * @throws IllegalArgumentException si la date n'est pas correcte.
	 */
	public static String commeString(int[] date) {
		return null;
	}
	
	
	/**
	 * Retourne vrai si une date est correcte (à vous de préciser ce que ça signifie).
	 * @param date
	 * @return vrai si les trois paramètres correspondent à une vraie date.
	 */
	public static boolean estDateCorrecte(int[] date) {
		return false;
	}
	
	/**
	 * Retourne le nombre de jour dans un mois pour une année donnée.
	 * @param mois
	 * @param annee
	 * @return
	 * @throws IllegalArgumentException si le numéro du mois n'est pas correct.
	 */
	public static int nombreDeJoursDansMois(int mois, int annee) {
		return -1;
	}
	
	/**
	 * Retourne la date du jour suivant une date donnée
	 * @param date une date
	 * @return la date du jour suivant.
	 * @throws IllegalArgumentException si la date n'est pas correcte.
	 */
	public static int [] dateSuivante(int [] date) {
		return null;
	}
}
