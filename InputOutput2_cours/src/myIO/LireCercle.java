package myIO;
/*
StreamTockenizer pour lire un fichier decrivant une image. Grammaire :
fichier ::= cercle*
cercle ::=  ’CERCLE’ ’(’ INT INT INT ’)’

ex input: CERCLE (2 3 10)
=> lu cercle 2.0,3.0,10.0

 */

import java.io.*;

public class LireCercle {
	public static void error(String e) {
		throw new RuntimeException("erreur de syntaxe " + e);
	}

	public static void main(String[] args) throws IOException {
		double cx, cy, r; // pour stocker les données
		InputStreamReader input = new InputStreamReader(System.in);
		StreamTokenizer t = new StreamTokenizer(input);
		t.nextToken(); // On lit le premier token!!!
		while (t.ttype != StreamTokenizer.TT_EOF) {
			if (t.ttype != StreamTokenizer.TT_WORD || !"CERCLE".equals(t.sval)) {
				error(" ’CERCLE’ attendu"); // On veut voir
			}
			t.nextToken();
			if (t.ttype != '(')
				error("’(’ attendue");
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				error("nombre attendu");
			cx = t.nval;
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				error("nombre attendu");
			cy = t.nval;
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				error("nombre attendu");
			r = t.nval;
			t.nextToken();
			System.out.println("lu cercle " + cx + "," + cy + "," + r);
			if (t.ttype != ')')
				error("’)’ attendue");
			t.nextToken();
		}
	}
}
