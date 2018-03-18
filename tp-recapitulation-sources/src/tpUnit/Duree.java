package tpUnit;

public class Duree {
	int heures;
	int minutes;

	/**
	 * Initialise une durée.
	 * <p>
	 * Noter que c'est bien une durée ; des valeurs comme 48 heures sont donc
	 * possibles.
	 * 
	 * @param heures
	 *            les heure (entier positif)
	 * @param minutes
	 *            des minutes (entre 0 et 59)
	 * @throws IllegalArgumentException
	 *             si heures ou minutes sont hors limite.
	 */
	public Duree(int heures, int minutes) throws IllegalArgumentException {
		if (heures < 0 || minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException();
		}
		this.heures = heures;
		this.minutes = minutes;
	}

	/**
	 * Retourne le nombre d'heures correspondant à cette durée.
	 * 
	 * @return
	 */
	public int getHeures() {
		return this.heures;
	}

	/**
	 * Retourne le nombre de minutes correspondant à cette durée.
	 * 
	 * @return
	 */

	public int getMinutes() {
		return this.minutes;
	}

	/**
	 * Retourne une nouvelle durée, qui est la somme de this et autre.
	 * <p>
	 * pre-condition: autre est non null.
	 * 
	 * @return une durée (correctement créée) qui est la somme des deux durées
	 *         passées.
	 * @throws NullPointerException
	 *             si autre est null
	 */

	public Duree ajouter(Duree autre) throws NullPointerException {
		if (autre == null) {
			throw new NullPointerException("Le paramètre ne doit pas être null ne doit pas être null");
		}
		int totalHeures = this.getHeures() + autre.getHeures();
		int totalMinutes = this.getMinutes() + autre.getMinutes();
		if (totalMinutes > 59) {
			totalHeures = totalHeures + totalMinutes / 60;
			totalMinutes = totalMinutes % 60;
		}
		return new Duree(totalHeures, totalMinutes);
	}

	/**
	 * Compare this et autre.
	 * <p>
	 * pre-condition: autre est non null.
	 * 
	 * @return -1 si this est inférieur à autre, 0 s'ils sont égaux, et 1 si this
	 *         est plus grand que autre.
	 * @throws NullPointerException
	 *             si autre est null
	 */

	public int comparer(Duree autre) throws NullPointerException {
		int result;
		if (autre == null) {
			throw new NullPointerException("Le paramètre ne doit pas être null ne doit pas être null");
		}
		if (this.getHeures() > autre.getHeures()) {
			result = 1;
		} else if (this.getHeures() == autre.getHeures() && this.getMinutes() == autre.getMinutes()) {
			result = 0;
		} else {
			result = -1;
		}
		return result;
	}

	/**
	 * Soustrait autre à this, et retourne la durée correspondante.
	 * <p>
	 * pré condition: autre est non nul, et inférieur ou égal à this (pas de durée
	 * négative).
	 * <p>
	 * post-condition: retourne une durée qui est la différence des deux.
	 * 
	 * @return une durée
	 * @throws NullPointerException
	 *             si autre est null
	 * @throws IllegalArgumentException
	 *             si autre est plus grand que this.
	 */
	public Duree soustraire(Duree autre) throws NullPointerException, IllegalArgumentException{
		if (autre == null) {
			throw new NullPointerException();
		}
		if (this.comparer(autre) == -1) {
			throw new IllegalArgumentException();
		}
		int DifMinutes= this.getMinutes();
		int DifHeures = this.getHeures() - autre.getHeures();
		if (this.getMinutes() >= autre.getMinutes()) {
			DifMinutes = DifMinutes - autre.getMinutes();
		} else {
			DifHeures = DifHeures - 1;
			DifMinutes = DifMinutes + 60 - autre.getMinutes();
		}
		return new Duree(DifHeures, DifMinutes);
	}

}
