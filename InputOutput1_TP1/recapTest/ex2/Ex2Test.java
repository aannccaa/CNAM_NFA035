package ex2;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Test;

public class Ex2Test {

	@Test
	public void test_estPair() {
		boolean actual = Ex2.estPair(1);
		boolean expected = false;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_copierUneSurDeuxLignes_impair() throws IOException{
		String[] lignes = {"0", "1", "2", "3", "4", "5"};
		String s = String.join("\n", lignes);
		StringReader sr = new StringReader(s);
		StringWriter sw = new StringWriter();
		
		Ex2.copierUneLigneSurDeux(sr, sw);
		String actual = sw.toString();
		Assert.assertEquals("0\n2\n4\n", actual);
		sr.close();
		sw.close();
	}

}
