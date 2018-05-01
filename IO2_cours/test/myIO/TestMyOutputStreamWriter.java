package test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Assert;
import org.junit.Test;


public class TestMyOutputStreamWriter {

	@Test
	public void test_writeIntoFile_01() throws FileNotFoundException, IOException {
		String expected = "J'écris une ligne et je passe déjà sur\nla deuxième.";
		String fileName = "streamOutputWriter1.txt";
		myIO.MyOutputStreamWriter.writeIntoFile(fileName, expected);
		Reader r = new FileReader(fileName);
		String actual = myIO.MyOutputStreamWriter.afficherToString(r);
		Assert.assertEquals("Test positif, cas nominal", expected, actual);
	}
	
	@Test
	public void test_writeIntoFile_02() throws FileNotFoundException, IOException {
		String expected = "";
		String fileName = "streamOutputWriter2.txt";
		myIO.MyOutputStreamWriter.writeIntoFile(fileName, expected);
		Reader r = new FileReader(fileName);
		String actual = myIO.MyOutputStreamWriter.afficherToString(r);
		Assert.assertEquals("Test negatif, fichier vide", expected, actual);
	}
	
	@Test (expected = NullPointerException.class)
	public void test_writeIntoFile_03() throws FileNotFoundException, IOException {
		String expected = null;
		String fileName = "streamOutputWriter3.txt";
		myIO.MyOutputStreamWriter.writeIntoFile(fileName, expected);
		Reader r = new FileReader(fileName);
		String actual = myIO.MyOutputStreamWriter.afficherToString(r);
		Assert.assertEquals("Test negatif, String a introduire null", expected, actual);
	}
	
	@Test (expected = FileNotFoundException.class)
	public void test_writeIntoFile_04() throws FileNotFoundException, IOException {
		String expected = null;
		String fileName = null;
		myIO.MyOutputStreamWriter.writeIntoFile(fileName, expected);
		Reader r = new FileReader(fileName);
		String actual = myIO.MyOutputStreamWriter.afficherToString(r);
		Assert.assertEquals("Test negatif, nom de fichier null", expected, actual);
	}
}
