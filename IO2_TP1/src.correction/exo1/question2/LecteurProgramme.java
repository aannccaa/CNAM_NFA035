package exo1.question2;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class LecteurProgramme {

	private Programme programme;
	private StreamTokenizer tok;

	public void lireProgramme(Reader r) throws IOException {
		tok = new StreamTokenizer(r);
		programme = new Programme();
		tok.nextToken();
		while (tok.ttype != StreamTokenizer.TT_EOF) {
			if (tok.ttype == StreamTokenizer.TT_WORD) {
				switch (tok.sval) {
				case "ADD":
					lireAdd();
					break;
				case "MULT":
					lireMult();
					break;
				case "CLEAR":
					lireClear();
					break;
				case "PRINT":
					lirePrint();
					break;
				case "SET":
					lireSet();
					break;
				default:
					error("Mot clef inattendu " + tok);
					break;
				}
			} else {
				error("caractère inattendu " + tok.toString());
			}
		}
	}

	private void lireSet() throws IOException {
		tok.nextToken();
		if (tok.ttype != StreamTokenizer.TT_WORD)
			error("Identifiant attendu " + tok);
		String variable = tok.sval;		
		programme.ajouter(new SetCommande(variable));
		tok.nextToken();
	}

	/**
	 * Lecture d'une expression. appelée par ADD et MULT.
	 * 
	 * @return
	 */
	private Expression lireExpression() throws IOException{
		// initialisation à null nécessaire, car
		// le compilateur ne sais pas que error() lève une
		// exception dans tous les cas.
		// algorithmiquement, ce n'est pas utile.
		Expression resultat= null; 
		
		// On est sur le premier (et unique) token de l'expression !
		switch (tok.ttype) {
		case StreamTokenizer.TT_NUMBER:
			resultat= new ExpressionConstante(tok.nval);
			tok.nextToken();
			break;
		case StreamTokenizer.TT_WORD:
			resultat= new ExpressionVariable(tok.sval);
			tok.nextToken();
			break;
		default:
			error("Erreur dans expression " + tok);
		}
		return resultat;
	}

	private void lireClear() throws IOException {
		// On est sûr que le mot-clef est CLEAR...
		tok.nextToken();
		programme.ajouter(new ClearCommande());
	}

	private void lireMult() throws IOException {
		tok.nextToken(); // on saute le add
		Expression e= lireExpression();
		Commande multCommande = new MultCommande(e);
		programme.ajouter(multCommande);
	}

	private void lirePrint() throws IOException {
		// On est sûr que le mot-clef est PRINT...
		tok.nextToken();
		programme.ajouter(new PrintCommande());
	}

	private void lireAdd() throws IOException {
		tok.nextToken(); // on saute le add
		Expression e= lireExpression();
		Commande addCommande = new AddCommande(e);
		programme.ajouter(addCommande);
	}

	private void error(String message) {
		throw new RuntimeException(message);
	}

	public Programme getProgramme() {
		return programme;
	}
}
