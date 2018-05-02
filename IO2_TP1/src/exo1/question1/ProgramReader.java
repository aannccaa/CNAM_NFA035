package exo1.question1;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.stream.Stream;

public class ProgramReader {
	StreamTokenizer tok;
	Program program;

	public void readProgram(Reader r) throws IOException {
		tok = new StreamTokenizer(r);
		program = new Program();
		tok.nextToken();
		while (tok.ttype != StreamTokenizer.TT_EOF) {
			if (tok.ttype == StreamTokenizer.TT_WORD) {
				switch (tok.sval) {
				case "ADD":
					lireAdd();
					break;
				case ("MULT"):
					lireMultiplication();
					break;
				case "PRINT":
					lirePrint();
					break;
				default:
					error("Mot clef innatendu" + tok);
					break;
				}
			} else {
				error("charactère innatendu" + tok.toString());
				break;
			}
		}
	}

	private void lireMultiplication() throws IOException {
		tok.nextToken(); // on saute le MULT
		if(tok.ttype != StreamTokenizer.TT_NUMBER) {
			error("nombre attendu" + tok.toString());
		}
		double value = tok.nval;
		Command c = new MultiplicationCommand(value);
		program.add(c);
		tok.nextToken();
	}

	private void lirePrint() throws IOException {
		// on est sur qu'on est sur le mot PRINT
		Command c = new PrintCommand();
		program.add(c);
		tok.nextToken();
	}

	private void lireAdd() throws IOException {
		tok.nextToken(); // je saute le ADD et normalement j'arrive sur un chiffre
		if (tok.ttype != StreamTokenizer.TT_NUMBER) {
			error("numéro attendu" + tok.toString());
		}
		// stockage du nombre dans une variable
		double value = tok.nval;
		Command c = new AddCommand(value);
		program.add(c);

		tok.nextToken();
	}

	private void error(String message) {
		throw new RuntimeException(message);
	}

	public Program getProgram() {
		return program;
	}

}
