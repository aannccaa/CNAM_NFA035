package devoir2;

import java.io.IOException;
import java.io.Reader;

/**
 * Interface de lecture d'un fichier contenant des opérations de la calculatrice
 * en notation polonaise inverse. Cette classe contient une unique méthode
 * permettant de lire les opérations à exécuter dans un fichier.
 * 
 * Vous devez écrire une classe CalcInterp implantant cette interface. Pour cela
 * vous devez bien entendu utiliser la classe {@code Calculette} implantant
 * l'interface {@link CalcInterpInterface} que vous aurez écrit au préalable.
 * 
 * @author Pierre courtieu
 * 
 */
public interface CalcInterpInterface {

	/**
	 * {@code calcule(f)} exécute les commandes contenues dans le {@link Reader}
	 * {@code f} et retourne le résultat final.
	 * <p>
	 * Le résultat final est le contenu du sommet de la pile après avoir
	 * effectué toutes les opérations contenues dans {@code f}.
	 * <p>
	 * Les commandes (nombres et opérateurs) sont séparées par un ou plusieurs
	 * espaces et/ou des sauts de ligne.
	 * <p>
	 * Les parties incorrectes du fichier sont ignorées.
	 * <p>
	 * Exemple de contenu de {@code f}:
	 * <p>
	 * <pre>
	 * "
	 * 234    45
	 * 
	 * +   11   31  + /
	 * "
	 * </pre>
	 * <p>
	 * 
	 * Résultat rendu par la méthode: 6,64 (c'est-à-dire: (234 + 45) / (11
	 * + 31)
	 * 
	 * 
	 * 
	 * 
	 * @param f
	 *            Le reader à lire (par exemple un FileReader).
	 * @return le sommet de la pile de la calculette après interprétation de
	 *         tout le fichier
	 * @throws IOException
	 *             Si une erreur d'entrée sortie a lieu.
	 */
	public abstract double calcule(Reader f) throws IOException;

}