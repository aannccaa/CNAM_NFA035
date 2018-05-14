package devoir2;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class CalcInterp implements CalcInterpInterface {

	@Override
	public double calcule(Reader f) throws IOException {
		StreamTokenizer tok = new StreamTokenizer(f);
		// par défault le char / est utilisé comme début de commentaire par le
		// StreamTokenizer
		// il faut le déclarer comme charactère ordinaire pour pouvoir faire des
		// divisions
		tok.ordinaryChar('/');

		Calculette calc = new Calculette();

		// la boule sera arrêtée à la fin du flux par l'instruction break
		while (true) {
			tok.nextToken();
			if (tok.ttype == StreamTokenizer.TT_EOF) {
				break; // le flux est lu jusqu'à la fin, on sort de la boucle
			}
			if (tok.ttype == StreamTokenizer.TT_NUMBER) {
				calc.empile(tok.nval);
			} else {
				switch (tok.ttype) {
				case (int) '+':
					calc.plus();
					break;
				case (int) '-':
					calc.moins();
					break;
				case (int) '*':
					calc.mult();
					break;
				case (int) '/':
					calc.div();
					break;
				default:
					// Les parties incorrectes du fichier sont ignorées
					break;
				}
			}
		}
		return calc.resultat();
	}

}
