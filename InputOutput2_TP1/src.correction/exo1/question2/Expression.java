package exo1.question2;

/**
 * Représentation d'une variable ou d'une constante 
 * dans une instruction (après ADD, MULT, etc.).
 * @author rosmord
 */
public interface Expression {
	double evaluer(Contexte c);
}
