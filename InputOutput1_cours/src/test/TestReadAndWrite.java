package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

import myIO.ReadAndWrite;

public class TestReadAndWrite {

	@Test
	public void test_copyStringFromReader() {
		StringReader sr = new StringReader("un texte ");
		StringWriter sw = new StringWriter();
		String actual = "";
		try {
			actual = ReadAndWrite.copyStringFromReader(sr, sw);
		} catch (IOException e) {
			Assert.fail("exception");
		} finally {
			sr.close();
			try {
				sw.close();
			} catch (IOException e) {
				Assert.fail("StringWriter not closed");
			}
		}
		String expected = "un texte ";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_copyFileContentInOtherFile() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("demo.txt");
			fw = new FileWriter("toto.txt");
		} catch (IOException e) {
			Assert.fail("not existing file");
		}
		String actual = "";
		try {
			actual = ReadAndWrite.copyFileContentInOtherFile(fr, fw);
		} catch (IOException e) {
			Assert.fail("exception");
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				Assert.fail("FileReader not closed");
			}
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				Assert.fail("FileWriter not closed");
			}
		}
		String expected = "un 2\n" + "trois\n" + "3 lignes";
		Assert.assertEquals(expected, actual);
	}
}
