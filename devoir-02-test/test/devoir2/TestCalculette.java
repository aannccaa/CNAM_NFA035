package devoir2;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculette {

	@Test
	public void test_empile_01() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		String actual = calc.toString();
		String expected = "[1.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_empile_02() {
		Calculette calc = new Calculette();
		String actual = calc.toString();
		String expected = "[]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_resultat_01() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		double actual = calc.resultat();
		double expected = 1.0;
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_resultat_02() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.empile(2);
		double actual = calc.resultat();
		double expected = 2.0;
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_resultat_03() {
		Calculette calc = new Calculette();
		double actual = calc.resultat();
		double expected = 0;
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_plus_01() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.empile(2);
		calc.empile(4);
		calc.plus();
		String actual = calc.toString();
		String expected = "[1.0, 6.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_plus_02() {
		Calculette calc = new Calculette();
		calc.empile(-1.0);
		calc.plus();
		String actual = calc.toString();
		String expected = "[-1.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_mult_01() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.empile(2);
		calc.empile(-4);
		calc.mult();
		String actual = calc.toString();
		String expected = "[1.0, -8.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_mult_02() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.mult();
		String actual = calc.toString();
		String expected = "[0.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_moins_01() {
		Calculette calc = new Calculette();
		calc.empile(10);
		calc.empile(4);
		calc.moins();
		String actual = calc.toString();
		String expected = "[6.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_moins_02() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.empile(2);
		calc.empile(-4);
		calc.moins();
		String actual = calc.toString();
		String expected = "[1.0, 6.0]";
		Assert.assertEquals("expected 6 = 2-(-4)", expected, actual);
	}

	@Test
	public void test_div_01() {
		Calculette calc = new Calculette();
		calc.empile(1.0);
		calc.empile(6);
		calc.empile(2);
		calc.div();
		String actual = calc.toString();
		String expected = "[1.0, 3.0]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_div_02() {
		Calculette calc = new Calculette();
		calc.empile(-6);
		calc.empile(0);
		calc.div();
		double actual = calc.resultat();
		double expected = Double.MIN_VALUE;
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_div_03() {
		Calculette calc = new Calculette();
		calc.empile(6);
		calc.empile(0);
		calc.div();
		double actual = calc.resultat();
		double expected = Double.MAX_VALUE;
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_div_04() {
		Calculette calc = new Calculette();
		calc.empile(6);
		calc.div();
		double actual = calc.resultat();
		double expected = 0.0;
		Assert.assertEquals(expected, actual, 1e-15);
	}

}
