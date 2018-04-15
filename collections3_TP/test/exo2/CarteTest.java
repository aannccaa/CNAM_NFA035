package exo2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarteTest {
	Carte c1;
	Carte c2;
	Carte c3;
	Carte c4;

	@Before
	public void init() {
		c1 = new Carte(10, Couleur.PIQUE);
		c2 = new Carte(10, Couleur.PIQUE);
		c3 = new Carte(2, Couleur.PIQUE);
		c4 = c3;
	}

	@Test
	public void testGetCouleur() {
		Assert.assertEquals(Couleur.PIQUE, c1.getCouleur());
	}

	@Test
	public void testGetValeur() {
		Assert.assertEquals(10, c1.getValeur());
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("10 de PIQUE", c1.toString());
	}
	
	@Test
	public void testHashCode() {
		Assert.assertEquals(c1.hashCode(), c2.hashCode());
		Assert.assertEquals(c3.hashCode(), c4.hashCode());
		Assert.assertNotEquals(c1.hashCode(), c4.hashCode());
	   
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(true, c1.equals(c2));
		Assert.assertEquals(false, c1.equals(c3));
		Assert.assertEquals(true, c4.equals(c3));
	}
	
	
}
