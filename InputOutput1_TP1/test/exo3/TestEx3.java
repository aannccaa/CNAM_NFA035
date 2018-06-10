package exo3;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

public class TestEx3 {
	private void test_calculerSomme(String s, int expected) {
		Reader r = new StringReader(s);
		try {

			int actual = 0;
			try {
				actual = exo3.ex3.calculerSomme(r);
			} catch (Exception e) {
				Assert.fail("normalement on n'arrive pas dans cas");
			}
			Assert.assertEquals(s, expected, actual);
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test_calculerSomme1() {
		test_calculerSomme("3 a22,34", 3 + 22 + 34);
	}

	@Test
	public void test_calculerSomme2() {
		test_calculerSomme("", 0);
	}

	@Test
	public void test_calculerSomme3() {
		test_calculerSomme("a-1b1", 0);
	}

	@Test
	public void test_calculerSomme4() {
		test_calculerSomme("a--1b1", 0);
	}

	@Test
	public void test_calculerSomme5() {
		test_calculerSomme("a-x-1b1", 0);
	}

	@Test
	public void test_calculerSomme6() {
		test_calculerSomme("abc", 0);
	}

	@Test
	public void test_calculerSomme7() {
		test_calculerSomme("a--a1", 1);
	}

	@Test
	public void test_calculerSomme8() {
		test_calculerSomme("a---1", -1);
	}
}
