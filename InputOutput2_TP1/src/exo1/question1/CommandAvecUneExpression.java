package exo1.question1;

import java.io.IOException;
import java.io.StreamTokenizer;

public abstract class CommandAvecUneExpression implements Command {
	protected Expression expression;

	@Override
	public void lireParametres(StreamTokenizer tok) throws IOException {
		tok.nextToken(); // on saute la commande et normalement on tombe sur un chiffre
		if (tok.ttype == StreamTokenizer.TT_NUMBER) {
			// stockage du nombre dans une variable
			this.expression = new ConstantExpression(tok.nval);
		} else if (tok.ttype == StreamTokenizer.TT_WORD) {
			this.expression = new VariableExpression(tok.sval);
		} else {
			throw new RuntimeException("numéro ou nom de variable attendu" + tok.toString());
		}
	}
}
