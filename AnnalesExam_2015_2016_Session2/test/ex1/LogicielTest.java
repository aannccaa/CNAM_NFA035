package ex1;
/*
Question 1.4 (2 points)
Comple ́tez les 4 tests JUNIT suivants, qui doivent permetre de ve ́rifier le bon comportement de la
me ́thode installer. Vos tests doivent correspondre a` des cas diffe ́rents de cette me ́thode. Vous sup-
 
poserez que les de ́clarations suivantes figurent dans votre fichier de tests :
 */

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ex1.InstallMachine;
import ex1.Logiciel;

public class LogicielTest {
	public static Logiciel jdk6 = new Logiciel("JDK", 6);
	public static Logiciel jdk8 = new Logiciel("JDK", 8);
	public static Logiciel netbeans = new Logiciel("netbeans", 4);
	public static Logiciel x11 = new Logiciel("X11", 7);

	@BeforeClass // CECI s’execute avant de commencer l’ensemble des tests
	public static void avantTous() {
		netbeans.ajoutDependance(jdk6);
		netbeans.ajoutDependance(x11);
	}

	@Test
	public void test2() { // échoue car les méthodes "equals" et "hashcode" n'ont pas été réecrites dans
							// Logiciel. Actuellement b0 et b00 sont vus commes instances d'object
							// différentes (pas la même adresse)
		Logiciel a = new Logiciel("A", 0);
		Logiciel b0 = new Logiciel("B", 0);
		Logiciel b00 = new Logiciel("B", 0);
		Assert.assertTrue(a.ajoutDependance(b0));
		Assert.assertFalse(a.ajoutDependance(b00));
	}

	@Test
	public void test3() {
		Logiciel a = new Logiciel("A", 0);
		Logiciel b0 = new Logiciel("B", 0);
		Logiciel b1 = new Logiciel("B", 1);
		a.ajoutDependance(b0);
		a.ajoutDependance(b1);
		Assert.assertTrue(a.dependDe(b0));
		Assert.assertTrue(a.dependDe(b1));
	}

	@Test
	public void test4() {// échoue car la dépendance b00 n'a pas été ajouté au logiciel "Fa"
		Logiciel a = new Logiciel("A", 0);
		Logiciel b0 = new Logiciel("B", 0);
		Logiciel b00 = new Logiciel("B", 0);
		a.ajoutDependance(b0);
		Assert.assertTrue(a.dependDe(b00));
	}

	@Test
	public void test5() {
		InstallMachine ins = new InstallMachine();
		boolean res = ins.installer(x11);
		// completer ...
		Assert.assertTrue(res);
	}

	@Test
	public void test6() {
		InstallMachine ins = new InstallMachine();
		boolean res = ins.installer(netbeans);
		// completer ...
		// jdk6 et x11 pas installés, netbeans ne doit pas s'installer
		Assert.assertFalse(res);
	}

	@Test
	public void test7() {
		InstallMachine ins = new InstallMachine();
		Assert.assertTrue(ins.installer(jdk6));
		Assert.assertTrue(ins.installer(x11));
		boolean res = ins.installer(netbeans);
		// completer
		// jdk6 et x11 installés, netbeans doit s'installer
		Assert.assertTrue(res);
	}

	@Test
	public void test8() {
		InstallMachine ins = new InstallMachine();
		Assert.assertTrue(ins.installer(jdk6));
		Assert.assertTrue(ins.installer(x11));
		boolean res = ins.installer(netbeans);
		// completer
		// jdk6 et x11 installés, netbeans doit s'installer
		Assert.assertTrue(res);
		Assert.assertFalse(ins.installer(netbeans));
	}

	@Test
	public void test9() {
		InstallMachine ins = new InstallMachine();
		Assert.assertTrue(ins.installer(jdk8));
		Assert.assertTrue(ins.installer(x11));
		boolean res = ins.installer(netbeans);
		// completer
		// jdk8 et x11 installés, netbeans ne doit pas s'installer (besoin de jdk6)
		Assert.assertFalse(res);
	}
}
