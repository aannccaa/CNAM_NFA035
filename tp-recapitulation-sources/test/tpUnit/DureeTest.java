package tpUnit;

import org.junit.Assert;
import org.junit.Test;

public class DureeTest {

	@Test(expected = IllegalArgumentException.class, timeout=1000)
	public void testDureeHeuresInfZero() {
		new Duree(-10, 50);
	}

	@Test(expected = IllegalArgumentException.class, timeout=1000)
	public void testDureeMinutesInfZero() {
		new Duree(10, -1);
	}

	@Test(expected = IllegalArgumentException.class, timeout=1000)
	public void testDureeMinutesSup59() {
		new Duree(10, 60);
	}

	@Test (timeout=1000)
	public void testgetHeures_01() {
		Duree d = new Duree(10, 50);
		int current = d.getHeures();
		Assert.assertEquals(10, current, 1e-5);
	}

	@Test (timeout=1000)
	public void testgetMinutes_01() {
		Duree d = new Duree(10, 50);
		int current = d.getMinutes();
		Assert.assertEquals(50, current, 1e-5);
	}
	
	@Test (timeout=1000)
	public void testAjouter_01() {
		Duree d1 = new Duree(10, 50);
		Duree d2 = new Duree(1, 2);
		Duree current = d1.ajouter(d2);
		Duree expected = new Duree(11, 52);
		Assert.assertEquals(expected.getHeures(), current.getHeures());
		Assert.assertEquals(expected.getMinutes(), current.getMinutes());
	}

	@Test (timeout=1000)
	public void testAjouter_02() {
		Duree d1 = new Duree(100, 59);
		Duree d2 = new Duree(1, 2);
		Duree current = d1.ajouter(d2);
		Duree expected = new Duree(102, 1);
		Assert.assertEquals(expected.getHeures(), current.getHeures());
		Assert.assertEquals(expected.getMinutes(), current.getMinutes());
	}
	
	@Test (expected = NullPointerException.class, timeout=1000)
	public void testAjouter_03() {
		Duree d1 = new Duree(1, 2);
		Duree d2 = null;
		d1.ajouter(d2);
	}
	
	@Test (timeout=1000)
	public void testCompare_01() {
		Duree d1 = new Duree(100, 1);
		Duree d2 = new Duree(1, 59);
		int current = d1.comparer(d2);
		Assert.assertEquals(1, current);
	}
	
	@Test (timeout=1000)
	public void testCompare_02() {
		Duree d1 = new Duree(10, 1);
		Duree d2 = new Duree(10, 1);
		int current = d1.comparer(d2);
		Assert.assertEquals(0, current);
	}
	
	@Test (timeout=1000)
	public void testCompare_03() {
		Duree d1 = new Duree(1, 59);
		Duree d2 = new Duree(2, 0);
		int current = d1.comparer(d2);
		Assert.assertEquals(-1, current);
	}
	
	@Test (expected = NullPointerException.class, timeout=1000)
	public void testCompare_04() {
		Duree d1 = new Duree(1, 59);
		Duree d2 = null;
		d1.comparer(d2);
	}
	
	@Test (timeout = 1000)
	public void testSoustraire_01() {
		Duree d1 = new Duree(100, 10);
		Duree d2 = new Duree(1, 9);
		Duree current = d1.soustraire(d2);
		Duree expected = new Duree(99, 1);
		Assert.assertEquals(expected.getHeures(), current.getHeures());
		Assert.assertEquals(expected.getMinutes(), current.getMinutes());
	}
	
	@Test (timeout = 1000)
	public void testSoustraire_02() {
		Duree d1 = new Duree(10, 1);
		Duree d2 = new Duree(1, 9);
		Duree current = d1.soustraire(d2);
		Duree expected = new Duree(8, 52);
		Assert.assertEquals(expected.getHeures(), current.getHeures());
		Assert.assertEquals(expected.getMinutes(), current.getMinutes());
	}
	
	@Test (expected = NullPointerException.class, timeout = 1000)
	public void testSoustraire_03() {
		Duree d1 = new Duree(10, 1);
		Duree d2 = null;
		d1.soustraire(d2);
	}
	
	@Test (expected = IllegalArgumentException.class, timeout = 1000)
	public void testSoustraire_04() {
		Duree d1 = new Duree(10, 10);
		Duree d2 = new Duree(100, 9);
		d1.soustraire(d2);
	}
}
