package exo1.question1;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class ProgramReader {
	StreamTokenizer tok;
	Program program;

	public Program readProgram(Reader r) throws IOException {
		tok = new StreamTokenizer(r);
		program = new Program();

		while (true) {
			Command command = lireCommand();
			if (command == null) {
				break;
			}
			program.add(command);
		}
		return program;
	}

	private Command lireCommand() throws IOException {
		this.tok.nextToken();
		// si on est à la fin du fichier on s'arrete
		if (this.tok.ttype == StreamTokenizer.TT_EOF) {
			return null;
		}
		// si le charactere lu est un mot
		if (tok.ttype == StreamTokenizer.TT_WORD) {
			Command command = getCommand(tok.sval);
			// en fonction de l'instruction, la commande sait lire les parametres (s'il y en
			// a)
			command.lireParametres(tok);
			return command;
		}

		throw new RuntimeException("charactère innatendu" + tok.toString());
	}

	private static Command getCommand(String cmd) {
		switch (cmd) {
		case "ADD":
			return new AddCommand();
		case "MULT":
			return new MultiplicationCommand();
		case "PRINT":
			return new PrintCommand();
		case "CLEAR":
			return new ClearCommand();
		case "SET":
			return new SetVarCommand();
		case "PRINTVAR":
			return new PrintVarCommand();
		default:
			throw new RuntimeException("Mot clef innatendu" + cmd);
		}
	}
}
