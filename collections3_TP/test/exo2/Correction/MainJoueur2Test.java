package exo2.Correction;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MainJoueur2Test {

	@Test
	public void testNombreCouleurs0() {
		MainJoueur2 m= new MainJoueur2();
		assertEquals(0, m.getNombreCouleurs());
		assertEquals(0, m.getNombreCouleursBis());
	}

	@Test
	public void testNombreCouleurs1() {
		Carte cartes[]= {
				new Carte(1, Couleur.Carreau),
				new Carte(13,Couleur.Carreau),
				new Carte(12,Couleur.Carreau),
				new Carte(11,Couleur.Carreau),
				new Carte(10,Couleur.Carreau),
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertEquals(1, m.getNombreCouleurs());
		assertEquals(1, m.getNombreCouleursBis());
	}
	
	@Test
	public void testNombreCouleurs2() {
		Carte cartes[]= {
				new Carte(1, Couleur.Carreau),
				new Carte(7,Couleur.Carreau),
				new Carte(12,Couleur.Pique),
				new Carte(8,Couleur.Carreau),
				new Carte(1,Couleur.Pique),
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertEquals(2, m.getNombreCouleurs());
		assertEquals(2, m.getNombreCouleursBis());
	}
	
	@Test
	public void testNombreCouleurs3() {
		Carte cartes[]= {
				new Carte(1, Couleur.Coeur),
				new Carte(7,Couleur.Carreau),
				new Carte(12,Couleur.Pique),
				new Carte(8,Couleur.Carreau),
				new Carte(1,Couleur.Pique),
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertEquals(3, m.getNombreCouleurs());
		assertEquals(3, m.getNombreCouleursBis());
	}

	@Test
	public void testSuiteVide() {
		MainJoueur2 m= new MainJoueur2();
		assertTrue("une main vide est une suite", m.estSuite());
	}
	
	@Test
	public void testSuiteSingleton() {
		MainJoueur2 m= new MainJoueur2();
		m.addCarte(new Carte(12, Couleur.Coeur));
		assertTrue("une main avec une seule carte est une suite", m.estSuite());
	}
	
	@Test
	public void testSuiteDeux() {
		Carte cartes[]= {
				new Carte(7, Couleur.Pique),
				new Carte(8,Couleur.Carreau)
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertTrue("suite de deux cartes "+Arrays.toString(cartes), m.estSuite());
	}
	
	@Test
	public void testSuiteQuinte() {
		Carte cartes[]= {
				new Carte(1, Couleur.Pique),
				new Carte(13,Couleur.Carreau),
				new Carte(12,Couleur.Carreau),
				new Carte(11,Couleur.Coeur),
				new Carte(10,Couleur.Carreau),
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertTrue("quinte "+Arrays.toString(cartes), m.estSuite());
	}
	
	@Test
	public void testPasSuiteQuinte() {
		Carte cartes[]= {
				new Carte(1, Couleur.Pique),
				new Carte(13,Couleur.Carreau),
				new Carte(12,Couleur.Carreau),
				new Carte(3,Couleur.Coeur),
				new Carte(10,Couleur.Carreau),
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertFalse("main quelconque "+Arrays.toString(cartes), m.estSuite());
	}
	
	@Test
	public void testPasSuiteDeuxCartes() {
		Carte cartes[]= {				
				new Carte(12,Couleur.Carreau),
				new Carte(3,Couleur.Coeur),				
		};
		MainJoueur2 m= new MainJoueur2();
		for (Carte c: cartes)
			m.addCarte(c);
		assertFalse("main quelconque "+Arrays.toString(cartes), m.estSuite());
	}

}
