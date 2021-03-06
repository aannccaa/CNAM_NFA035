package myIO;
/*
programme qui lit, soit des nombres, soit le mot "print"  , auquel cas il affiche la somme des nombres lus. Toute autre entre ́e donne lieu a` un message d’erreur.

 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MyStreamTokenizer0 {

	public static void main(String[] args) throws IOException {
		System.out.println("Introduire des nombres puis écrire 'print' pour afficher leur somme: ");
		double total = 0.0;
		// stocker dans input ce qu'il est introduit à la console
		InputStreamReader input = new InputStreamReader(System.in);
		StreamTokenizer st = new StreamTokenizer(input);
		st.lowerCaseMode(true);
		
		int token = st.nextToken();
		while (st.ttype != StreamTokenizer.TT_EOF) {
			switch (st.ttype) {
			// si un nombre a été lu (TT_NUMBER), sa valeur est dans nval;
			case StreamTokenizer.TT_NUMBER:
				total += st.nval;
				break;
			// si un mot a été lu (TT WORD), sa valeur est dans sval
			case StreamTokenizer.TT_WORD:
				// si on lit le mot print, on affiche la somme des nombres déjà introduits
				if (st.sval.equals("print"))
					System.out.println("total= " + total);
				else
					System.out.println("inconnu " + st.sval);
				break;
			default:
				char ch = (char) st.ttype;
				// Character charInnatendu = new Character(ch);
				System.out.println("Charactère inattendu: " + ch);
				//System.out.println("chaîne inattendue: " + (new Character((char)s.ttype)));
			}
			token = st.nextToken();
		}
	}
}
