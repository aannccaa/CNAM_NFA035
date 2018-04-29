package myIO;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class MyScanner {

	public static void lireCercle(Readable input) throws IOException {
		// x, y: coord centre cercle
		double x;
		double y;
		// r: rayon cercle
		double r;

		Scanner scan = new Scanner(input);
		
		while (scan.hasNext()) {
			String s = scan.next();
			System.out.println(s);
			if (!"CERCLE".equals(s)) {
				Exception.myError("'CERCLE' attendu");
			}
			
		}
	}

	/*
	 double val= 0;while(scan.hasNext())
	{
	
	 if (scan.hasNextDouble()) { val= val+ scan.nextDouble ( ) ;
	 } else {
	 String texte= s.next();
	 if ("print".equals(texte)) {
	 System.out.println("somme" + val);
	  } else {
	 System.out.println("Texte inattendu " + texte);
	  }
	  */

	public static void main(String[] args) throws IOException {
		Reader r = new StringReader("CERCLE(1 4 5)\nCERCLE(6 2 3) CERCLE(0 0 5)");
		lireCercle(r);
		r.close();
	}

}
