package tpUnit;

import org.junit.Assert;
import org.junit.Test;

public class TableauHelperTest {

	@Test(timeout = 1000)
	public void testInverser_01() {
		char[] orig = { 'a', '1', 'R' };
		char[] expected = { 'R', '1', 'a' };
		char[] current = TableauHelper.inverser(orig);

		Assert.assertArrayEquals("cas nominal", expected, current);
	}

	// Exception si orig==null
	@Test(expected = NullPointerException.class, timeout = 1000)
	public void testInverser_02() {
		char[] orig = null;
		TableauHelper.inverser(orig);
	}

	@Test(timeout = 1000)
	public void testConcatenner_01() {
		int[] t1 = { 1, 2, 3 };
		int[] t2 = {4, 5};
		int[] expected = {  1, 2, 3, 4, 5 };
		int[] current = TableauHelper.concatener(t1, t2);

		Assert.assertArrayEquals("cas nominal", expected, current);
	}
	
	// Exception si t1==null
	@Test(expected = NullPointerException.class, timeout = 1000)
	public void testConcatenner_02() {
		int[] t1 = null;
		int[] t2 = {4, 5};
		TableauHelper.concatener(t1, t2);
	}
	
	// Exception si t2==null
	@Test(expected = NullPointerException.class, timeout = 1000)
	public void testConcatenner_03() {
		int[] t1 = { 1, 2, 3 };
		int[] t2 = null;
		TableauHelper.concatener(t1, t2);
	}

	// indiceDebut = 0; indiceFin<t.length
	@Test(timeout = 1000)
	public void testSousTableau_01() {
		char[] t = {  '0', '1', '2', '3', '4', '5', '6', '7' };
		int indiceDebut = 0;
		int indiceFin = 3;
		char[] expected = {  '0', '1', '2' };
		char[] current = TableauHelper.sousTableau(t, indiceDebut, indiceFin);

		Assert.assertArrayEquals("indice debut = 0", expected, current);
	}
	
	// indiceDebut > 0; indiceFin<t.length
	@Test(timeout = 1000)
	public void testSousTableau_02() {
		char[] t = {  '1', '2', '3', '4', '5', '6', '7' };
		int indiceDebut = 2;
		int indiceFin = 4;
		char[] expected = { '3', '4' };
		char[] current = TableauHelper.sousTableau(t, indiceDebut, indiceFin);

		Assert.assertArrayEquals("indice debut > 0", expected, current);
	}
	
	//indiceDebut > indiceFin"
	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void testSousTableau_03() {
		char[] t = {  '1', '2', '3', '4', '5', '6', '7' };
		int indiceDebut = 3;
		int indiceFin = 1;
		TableauHelper.sousTableau(t, indiceDebut, indiceFin);
	}
	
	//t == null
	@Test(expected = NullPointerException.class, timeout = 1000)
	public void testSousTableau_04() {
		char[] t = null;
		int indiceDebut = 1;
		int indiceFin = 3;
		TableauHelper.sousTableau(t, indiceDebut, indiceFin);
	}
	
	//indiceFin > t.lenght;
	@Test(timeout = 1000)
	public void testSousTableau_05() {
		char[] t = {  '1', '2', '3', '4', '5', '6', '7' };
		int indiceDebut = 0;
		int indiceFin = 100;
		char[] expected = { '1', '2', '3', '4', '5', '6', '7' };
		char[] current = TableauHelper.sousTableau(t, indiceDebut, indiceFin);

		Assert.assertArrayEquals(expected, current);
	}
	
	// indiceDebut < 0; indiceFin > t.length
	@Test(timeout = 1000)
	public void testSousTableau_06() {
		char[] t = {  '1', '2', '3', '4', '5', '6', '7' };
		int indiceDebut = -10;
		int indiceFin = 100;
		char[] expected = { '1', '2', '3', '4', '5', '6', '7' };
		char[] current = TableauHelper.sousTableau(t, indiceDebut, indiceFin);

		Assert.assertArrayEquals(expected, current);
	}
}
