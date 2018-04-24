package test;

import myIO.SearchTexteInLine;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestSearchTexteInLine {

	
	/*demo.txt content
	un 2
	trois
	3 lignes
	 */
	@Test
	public void test_existeTexteInLine_Yes() throws IOException {
		String[] param = new String[2];
		param[0] = "trois";
		param[1] = "demo.txt";
		boolean actual = SearchTexteInLine.existeTexteInLine(param);
		boolean expected = true;

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_existeTexteInLine_No() throws IOException {
		String[] param = new String[2];
		param[0] = "n'existe pas";
		param[1] = "demo.txt";
		boolean actual = SearchTexteInLine.existeTexteInLine(param);
		boolean expected = false;

		Assert.assertEquals(expected, actual);
	}

}
