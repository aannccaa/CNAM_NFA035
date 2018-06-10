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
		boolean actual = SearchTexteInLine.existeTexteInLine("trois", "demo.txt");
		boolean expected = true;

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_existeTexteInLine_No() throws IOException {
		boolean actual = SearchTexteInLine.existeTexteInLine("n'existe pas", "demo.txt");
		boolean expected = false;

		Assert.assertEquals(expected, actual);
	}

}
