package myIO;

import java.io.*;

public class LireCercles {
	public static void syntaxError(String e) {
		throw new RuntimeException("erreur de syntaxe " + e);
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer t = new StreamTokenizer(new InputStreamReader(System.in));
		t.nextToken();
		while (t.ttype != StreamTokenizer.TT_EOF) {
			double cx, cy, r;
			if (t.ttype != StreamTokenizer.TT_WORD && !"CERCLE".equals(t.sval))
				syntaxError(" 'CERCLE' attendu");
			t.nextToken();
			if (t.ttype != '(')
				syntaxError("'(' attendue");
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				syntaxError("nombre attendu");
			cx = t.nval;
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				syntaxError("nombre attendu");
			cy = t.nval;
			t.nextToken();
			if (t.ttype != StreamTokenizer.TT_NUMBER)
				syntaxError("nombre attendu");
			r = t.nval;
			t.nextToken();
			System.out.println("lu cercle " + cx + "," + cy + "," + r);
			if (t.ttype != ')')
				syntaxError("'(' attendue");
			t.nextToken();
		}
	}
}
