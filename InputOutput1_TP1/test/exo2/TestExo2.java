package exo2;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

public class TestExo2 {

	// - un flux qui contient exactement ab\nc fait deux lignes ;
	@Test
	public void test_copyUneSurDeuxLignes_2lignes() {
		String[] lignes = { "Ligne 1", "Ligne 2" };
		String input = String.join("\n", lignes);
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "Ligne 1";
		Assert.assertEquals(expected, actual);
	}

	// - un flux qui contient exactement ab\nc\n fait deux lignes, on ne copie que la première;
	@Test
	public void test_copyUneSurDeuxLignes_2lignesEtRetourLigne() {
		String[] lignes = { "Ligne 1", "Ligne 2" };
		String input = String.join("\n", lignes) + "\n";
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "Ligne 1";
		Assert.assertEquals(expected, actual);
	}

	// plus de deux lignes, un cas impair.
	@Test
	public void test_copyUneSurDeuxLignes_3lignes() {
		String[] lignes = { "Ligne 1", "Ligne 2", "Ligne 3" };
		String input = String.join("\n", lignes);
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "Ligne 1\nLigne 3";
		Assert.assertEquals(expected, actual);
	}

	// plus de deux lignes, un cas pair
	@Test
	public void test_copyUneSurDeuxLignes_4lignes() {
		String[] lignes = { "Ligne 1", "Ligne 2", "Ligne 3", "Ligne 4" };
		String input = String.join("\n", lignes);
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "Ligne 1\nLigne 3";
		Assert.assertEquals(expected, actual);
	}

	// - un flux qui contient exactement ab fait une ligne ;
	@Test
	public void test_copyUneSurDeuxLignes_1ligne() {
		String[] lignes = { "Ligne 1" };
		String input = String.join("\n", lignes);
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "Ligne 1";
		Assert.assertEquals(expected, actual);
	}

	// l’entrée est vide ;
	@Test
	public void test_copyUneSurDeuxLignes_0lignes() {
		String[] lignes = { "" };
		String input = String.join("\n", lignes);
		StringReader sr = new StringReader(input);
		StringWriter sw = new StringWriter();
		try {
			exo2.ex2.copyUneSurDeuxLignes(sr, sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = sw.toString();
		String expected = "";
		Assert.assertEquals(expected, actual);
	}

}
