package exo1.question2;

import java.util.HashMap;
import java.util.Map;

/**
 * Contexte d'évaluation des commandes.
 * On a le résultat du calcul, d'une part, 
 * et les variables d'autre part.
 * 
 * <p> Note: on pourrait aussi avoir ici un miroir des commandes (une
 * méthode par commande).
 * @author rosmord
 *
 */
public class Contexte {
	private double valeur= 0;
	private Map<String, Double> variables= new HashMap<>();
	
	/**
	 * @return the valeur
	 */
	public double getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Fixe la valeur d'une variable.
	 * @param variable
	 * @param valeur
	 */
	public void setValeur(String variable, double valeur) {
		variables.put(variable, valeur);
	}
	
	/**
	 * Récupère la valeur d'une variable.
	 * Une variable non initialisée a par défaut la valeur 0.
	 */
	public double getValeur(String variable) {
		if (variables.containsKey(variable)) {
			return variables.get(variable);
		} else {
			return 0;
		}
	}
	
}
