package myIO;

/*
Lire des cercles à partir d'un fichier decrivant une image. Grammaire :
fichier ::= cercle* 
cercle ::=  ’CERCLE’ ’(’ INT INT INT ’)’

 */
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MyStreamTokenizer2 {

	public static void lireCercle() throws IOException {
		//x, y: coord centre cercle
		double x;
		double y; 
		// r: rayon cercle
		double r;
		
		StreamTokenizer t = new StreamTokenizer(new FileReader("cercle.txt"));
		t.nextToken();
		while(t.ttype != StreamTokenizer.TT_EOF) {
			if(!"CERCLE".equals(t.sval)) {
			//if(t.ttype != StreamTokenizer.TT_WORD || !t.sval.equals("CERCLE")) {
				Exception.myError("'CERCLE' attendu");
			}
			t.nextToken();
			if(t.ttype != '('){
				Exception.myError("'(' attendue");
			}
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			x=t.nval;
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			y=t.nval;
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			r=t.nval;
			t.nextToken();
			if(t.ttype != ')') {
				Exception.myError("')' attendue");
			}
			t.nextToken();
			String s = String.format("lu cercle, coordonnées centre x=%.2f, y=%.2f, rayon r=%.2f", x, y, r);
			System.out.println(s);
		}
		
	}

	public static void main(String[] args) {
		try {
			lireCercle();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
