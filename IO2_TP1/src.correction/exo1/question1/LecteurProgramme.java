package exo1.question1;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class LecteurProgramme {

	private Programme programme;
	private StreamTokenizer tok;
	
	public void lireProgramme(Reader r) throws IOException {
		tok= new StreamTokenizer(r);
		programme= new Programme();
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
				default:
					error("Mot clef inattendu "+ tok);
					break;
				}
			} else {				
				error("caractère inattendu "+ tok.toString());
			}
		}		
	}
	
	private void lireClear()  throws IOException {
		// On est sûr que le mot-clef est CLEAR...
		tok.nextToken();
		programme.ajouter(new ClearCommande());		
	}

	private void lireMult() throws IOException{
		tok.nextToken(); // on saute le add
		if (tok.ttype != StreamTokenizer.TT_NUMBER) {
			error("nombre attendu "+ tok.toString());
		}
		double param= tok.nval;
		Commande multCommande= new MultCommande(param);
		programme.ajouter(multCommande);
		tok.nextToken();		
	}

	private void lirePrint() throws IOException {
		// On est sûr que le mot-clef est PRINT...
		tok.nextToken();
		programme.ajouter(new PrintCommande());
	}

	private void lireAdd() throws IOException {
		tok.nextToken(); // on saute le add
		if (tok.ttype != StreamTokenizer.TT_NUMBER) {
			error("nombre attendu "+ tok.toString());
		}
		double param= tok.nval;
		Commande addCommande= new AddCommande(param);
		programme.ajouter(addCommande);
		tok.nextToken();
		
	}

	private void error(String message) {
		throw new RuntimeException(message);
	}
	
	public Programme getProgramme() {
		return programme;
	}
}
