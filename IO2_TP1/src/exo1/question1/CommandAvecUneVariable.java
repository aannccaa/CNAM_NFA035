package exo1.question1;

import java.io.IOException;
import java.io.StreamTokenizer;

public abstract class CommandAvecUneVariable implements Command {
	protected String nomVariable;

	@Override
	public void lireParametres(StreamTokenizer tok) throws IOException {
		tok.nextToken(); // on saute la commande et normalement on tombe sur un chiffre
		if (tok.ttype == StreamTokenizer.TT_WORD) {
			this.nomVariable = tok.sval;
		} else {
			throw new RuntimeException("nom de variable attendu " + tok.toString());
		}
	}
}