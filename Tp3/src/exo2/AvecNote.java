package exo2;

/**
 * Modélise une évaluation avec un code et une note finale.
 * 
 * @author aponte
 *
 */

public interface AvecNote {
	/**
	 * Code du module évalué.
	 * 
	 * @return
	 */
	String getCode();

	/**
	 * Note du module évalué.
	 * 
	 * @return
	 */
	double calculeNote();
}
