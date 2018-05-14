package devoir2;

import java.util.ArrayList;

public class Calculette implements CalculetteInterface {
	private ArrayList<Double> pile;

	public Calculette() {
		this.pile = new ArrayList<Double>();
	}

	@Override
	public void plus() {
		// dans la pile on a d'abord empilé n2, puis n1,
		// pour faire une opération on garde l'odre des opérandes (n2 à gauche de
		// l'opérateur, n1 à droite)
		double n1 = this.depile();
		double n2 = this.depile();
		double somme = n2 + n1;
		this.empile(somme);
	}

	@Override
	public void mult() {
		double n1 = this.depile();
		double n2 = this.depile();
		double multiplication = n2 * n1;
		this.empile(multiplication);
	}

	@Override
	public void moins() {
		double n1 = this.depile();
		double n2 = this.depile();
		double difference = n2 - n1;
		this.empile(difference);

	}

	@Override
	public void div() {
		double n1 = this.depile();
		double n2 = this.depile();
		double division;
		if (n1 == 0) {
			division = n2 > 0 ? Double.MAX_VALUE : Double.MIN_VALUE;
		} else {
			division = n2 / n1;
		}
		this.empile(division);

	}

	@Override
	public void empile(double n) {
		this.pile.add(n);
	}

	@Override
	public double resultat() {
		return this.getDernier(false);
	}

	@Override
	public String toString() {
		return this.pile.toString();
	}
	
	/** Obtient le dernier nombre de la pile. Si la pile est vide, le résultat retourne zéro.
	 * @param depile indique si le nombre doit être retiré de la pile
	 * @return le dernier nombre de la pile, où 0 si la pile est vide
	 */
	private double getDernier(boolean depile) {
		int nbElementsPile = pile.size();
		if (nbElementsPile == 0) {
			return 0;
		}
		int indexDernierNombrePile = nbElementsPile - 1;
		double result = this.pile.get(indexDernierNombrePile);
		if (depile) {
			this.pile.remove(indexDernierNombrePile);
		}
		return result;
	}

	/** Obtient le dernier nombre de la pile, en l'enlevant aussi de la pile
	 * @return le dernier nombre de la pile
	 */
	private double depile() {
		// on eleve le dernier nombre de la pile en passant le parametre (depile = true)
		return this.getDernier(true);
	}

}
