package exo1.question1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

public class Question1Test {
	@Test
	public void testDepart() {
		Programme p= new Programme();
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(0.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testADD() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(3));
		p.ajouter(new AddCommande(2));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(5.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testMult() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(3));
		p.ajouter(new MultCommande(2));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(6.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testClear() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(3));
		p.ajouter(new AddCommande(2));
		p.ajouter(new ClearCommande());
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(0.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testLong() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(3));
		p.ajouter(new AddCommande(2));
		p.ajouter(new MultCommande(3));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(15.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testLecteur() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD 3 CLEAR ADD 5 MULT 2 PRINT"));
		Contexte c= new Contexte();
		lecteur.getProgramme().evaluer(c);
		assertEquals(10.0, c.getValeur(), 1.0e-10);
	}
	
	@Test(expected=RuntimeException.class)
	public void testLecteurErreur() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD CLEAR"));
	}

	@Test(expected=RuntimeException.class)
	public void testLecteurErreurFin() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD"));
	}

	@Test(expected=RuntimeException.class)
	public void testLecteurErreurInconnu() throws IOException{
		// Note: ce test échouait dans la première version de mon
		// programme car j'avais oublié de traiter les mots inconnus... (default dans 
		// l'algo de lecture)... 
		// l'erreur a donc été anticipée et détectée grâce au test
		// (en fait, il n'échouait pas exactement, mais rentrait dans une boucle infinie).
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 TOTO"));
	}

}
