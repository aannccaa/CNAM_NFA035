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
		String s="";
		while (scan.hasNext()) {
			s = scan.next();
			System.out.print(s);
			if (!"CERCLE".equals(s)) {
				Exception.myError("'CERCLE' attendu");
			}
			s = scan.next();
			System.out.print(s);
			if(!"(".equals(s)) {
				Exception.myError("'(' attendue");
			}
			s = scan.next();
			System.out.print(s);
			if(!"1".equals(s)) {
				Exception.myError("'1' attendu");
			}
			s = scan.next();
			System.out.print(s);
			if(!"4".equals(s)) {
				Exception.myError("'4' attendu");
			}
			
			s = scan.next();
			System.out.print(s);
			if(!"5".equals(s)) {
				Exception.myError("'5' attendu");
			}
			
			s = scan.next();
			System.out.print(s);
			if(!")".equals(s)) {
				Exception.myError("')' attendue");
			}
		}
		System.out.println("gata");
	}

	public static void main(String[] args) throws IOException {
		//Reader r = new StringReader("CERCLE (1 4 5)\nCERCLE (6 2 3) CERCLE (0 0 5)");
		Reader r = new StringReader("CERCLE ( 1 4 5 )");
		lireCercle(r);
		r.close();
	}

}
