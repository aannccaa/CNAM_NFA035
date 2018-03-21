package devoir1;

import org.junit.Assert;

import org.junit.Test;

public class Devoir1Test {

	@Test(timeout = 1000)
	public void testSecondeValeur_01() {
		int[] tab = { 8, 8, 2, 6, 7, 7, 2, 2, 2 };
		int expected = 7;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_02() {
		int[] tab = { 8, 9 };
		int expected = 8;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_03() {
		int[] tab = { 9, 8 };
		int expected = 8;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_04() {
		int[] tab = { 15, 19, 1, 2, 3, 9, 8, 9, 8, 19, 19 };
		int expected = 15;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_05() {
		int[] tab = { 19, 19, 8, 9, 8, 1, 19, 15 };
		int expected = 15;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_06() {
		int[] tab = { 19, 8, 19, 15, 9, 8, 1, 19 };
		int expected = 15;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testSecondeValeur_07() {
		int[] tab = { -10, -2, -6, -9, -1 };
		int expected = -2;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}
	
	@Test(timeout = 1000)
	public void testSecondeValeur_08() {
		int[] tab = { -10, 0, };
		int expected = -10;
		int actual = Devoir1.secondeValeur(tab);

		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000, expected = RuntimeException.class)
	public void testSecondeValeur_09() {
		int[] tab = { 1, 1, 1, 1 };
		Devoir1.secondeValeur(tab);
	}
	
	@Test(timeout = 1000, expected = RuntimeException.class)
	public void testSecondeValeur_10() {
		int[] tab = { 1 };
		Devoir1.secondeValeur(tab);
	}
	
	@Test(timeout = 1000, expected = RuntimeException.class)
	public void testSecondeValeur_11() {
		int[] tab = null;
		Devoir1.secondeValeur(tab);
	}
}
