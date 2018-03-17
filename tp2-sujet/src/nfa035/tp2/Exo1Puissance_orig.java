package nfa035.tp2;
/*
Exercice 1
NFA035 : TP 2 JUnit

Te ́le ́chargez et ouvrez le projet du tp2. La classe Exo1Puissance contient une me ́thode qui doit 
calculer a^n, pour n entier. Les spe ́cifications sont les suivantes
— a est un re ́el, et n un entier quelconque ;
— Le calcul de 0^n doit lever une exception si n est strictement ne ́gatif.

Questions
1. Faites tourner le test Exo1PuissanceTest ;
2. comple ́tez la me ́thode puissance pour qu’elle fonctionne ;
3. testez votre me ́thode avec Exo1puissanceTest, et corrigez-la si ne ́cessaire.
 */

public class Exo1Puissance_orig {
	/**
	 * Calcule a puissance n.
	 * Si a est 0 et n est négatif, doit lancer une {@link ArithmeticException}
	 * @param a un réel 
	 * @param n un entier quelconque
	 * @return a puissance n
	 * @throws ArithmeticException si a == 0 et n est strictement négatif.
	 */
	public static double puissance(double a, int n) {
		return 0;
	}
}
