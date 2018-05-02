package exo1.question1;

import java.io.IOException;
import java.io.StringReader;

public class Demo {
	public static void main(String[] args) throws IOException {
		LecteurProgramme lecteur = new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 3 ADD 5 \n MULT 2 PRINT"));
		Programme prog = lecteur.getProgramme();
		Contexte contexte = new Contexte();
		prog.evaluer(contexte);
	}
}
