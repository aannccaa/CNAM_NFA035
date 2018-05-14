package devoir2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;
/*
Quelques essais que nous ferons sur votre implémentation de CalcInterp :
"\n\n\n\n" (des retours chariots) doit donner 0
"\n \n \nsdfdsf%%\n" (des retours chariots, des espaces, et des lettres) doit donner 0 
" 42\n " doit donner 42
" 42 +" doit donner 42
"42 8 -" doit donner34
"32 8 /" doit donner 4
"42\n8\n+" doit donner 50
"32 8 8 8 - - -" doit donner 24
"1 1 + + + + + + +" doit donner 2
 */

public class TestCalcInterp {
	
	private void tester(String expr, double expected) {
		CalcInterp calc = new CalcInterp();
		Reader r = new StringReader(expr);
		double actual=0;
		try {
			actual = calc.calcule(r);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(expected, actual, 1e-15);
	}

	@Test
	public void test_calcule_01() {
		tester("2 3 4 * +", 14);
	}
	
	@Test
	public void test_calcule_02() {
		tester("\n\n\n\n", 0);
	}
	
	@Test
	public void test_calcule_03() {
		tester("\n \n \nsdfdsf%%\n", 0);
	}
	
	@Test
	public void test_calcule_04() {
		tester("42\n", 42);
	}
	
	@Test
	public void test_calcule_05() {
		tester("42 +", 42);
	}
	
	@Test
	public void test_calcule_06() {
		tester("42 8 -", 34);
	}
	
	@Test
	public void test_calcule_07() {
		tester("32 8 /", 4);
	}
	
	@Test
	public void test_calcule_08() {
		tester("42\n8\n+", 50);
	}
	@Test
	public void test_calcule_09() {
		tester("32 8 8 8 - - -", 24);
	}
	
	@Test
	public void test_calcule_10() {
		tester("1 1 + + + + + + +", 2);
	}

}
