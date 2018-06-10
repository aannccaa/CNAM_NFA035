package exo1.question2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class Question2Test {
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
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new AddCommande(new ExpressionConstante(2)));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(5.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testMult() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new MultCommande(new ExpressionConstante(2)));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(6.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testVar1() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new AddCommande(new ExpressionVariable("x")));
		Contexte c= new Contexte();
		c.setValeur("x",7);
		p.evaluer(c);
		assertEquals(10.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testSetVar1() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new SetCommande("x"));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(6.0, c.getValeur("x"), 1.0e-10);
	}
	
	@Test
	public void testSetVar2() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new SetCommande("y"));
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new SetCommande("x"));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(3.0, c.getValeur("y"), 1.0e-10);
		assertEquals(6.0, c.getValeur("x"), 1.0e-10);
	}
	
	@Test
	public void testSetVar3() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new SetCommande("y"));
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new SetCommande("x"));
		p.ajouter(new ClearCommande());
		p.ajouter(new AddCommande(new ExpressionVariable("x")));
		p.ajouter(new MultCommande(new ExpressionVariable("y")));
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(18.0, c.getValeur(), 1.0e-10);
		assertEquals(6.0, c.getValeur("x"), 1.0e-10);
	}
	
	
	@Test
	public void testClear() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new AddCommande(new ExpressionConstante(2)));
		p.ajouter(new ClearCommande());
		Contexte c= new Contexte();
		p.evaluer(c);
		assertEquals(0.0, c.getValeur(), 1.0e-10);
	}
	@Test
	public void testLong() {
		Programme p= new Programme();
		p.ajouter(new AddCommande(new ExpressionConstante(3)));
		p.ajouter(new AddCommande(new ExpressionConstante(2)));
		p.ajouter(new MultCommande(new ExpressionConstante(3)));
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
	

	@Test
	public void testLecteurVar0() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD xx"));
		Contexte c= new Contexte();
		lecteur.getProgramme().evaluer(c);
		assertEquals(2.0, c.getValeur(), 1.0e-10);
	}

	@Test
	public void testLecteurVar1() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD xx"));
		Contexte c= new Contexte();
		c.setValeur("xx", 4);
		lecteur.getProgramme().evaluer(c);
		assertEquals(6.0, c.getValeur(), 1.0e-10);
	}
	
	@Test
	public void testLecteurSet() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD x SET y MULT y"));
		Contexte c= new Contexte();
		c.setValeur("x", 5);
		lecteur.getProgramme().evaluer(c);
		assertEquals(49.0, c.getValeur(), 1.0e-10);
	}

	
	@Test(expected=RuntimeException.class)
	public void testLecteurErreur() throws IOException{
		LecteurProgramme lecteur= new LecteurProgramme();
		lecteur.lireProgramme(new StringReader("ADD 2 ADD !"));
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
