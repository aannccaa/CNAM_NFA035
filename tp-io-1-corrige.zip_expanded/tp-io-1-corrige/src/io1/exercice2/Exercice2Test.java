package io1.exercice2;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;
import org.junit.Test;

public class Exercice2Test {
	
	@Test
	public void testEntreeVide() throws IOException{
		StringReader r= new StringReader("");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("", w.toString());
	}
	
	@Test
	public void testUnUnChar() throws IOException{
		StringReader r= new StringReader("a");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("a\n", w.toString());
	}
	
	@Test
	public void testUneLigne() throws IOException{
		StringReader r= new StringReader("aaa");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\n", w.toString());
	}
	
	@Test
	public void testUneLigneBis() throws IOException{
		StringReader r= new StringReader("aaa\n");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\n", w.toString());
	}
	
	
	@Test
	public void testDeuxLignes() throws IOException{
		StringReader r= new StringReader("aaa\nbb");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\n", w.toString());
	}
	
	@Test
	public void testDeuxLignesBis() throws IOException{
		StringReader r= new StringReader("aaa\nbb\n");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\n", w.toString());
	}
	
	@Test
	public void casPair() throws IOException{
		StringReader r= new StringReader("aaa\nbb\ncc\ndd");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\ncc\n", w.toString());
	}
	
	
	@Test
	public void casImpair() throws IOException{
		StringReader r= new StringReader("aaa\nbb\ncc\ndd\nee");
		StringWriter w= new StringWriter();
		Exercice2.copieUneSurDeux(r, w);
		assertEquals("aaa\ncc\nee\n", w.toString());
	}
	
}
