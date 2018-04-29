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

public class MyStreamTokenizer {

	public static void lireCercle() throws IOException {
		//x, y: coord centre cercle
		double x;
		double y; 
		// r: rayon cercle
		double r;
		//StreamTokenizer t = new StreamTokenizer(new InputStreamReader(System.in));
		StreamTokenizer t = new StreamTokenizer(new FileReader("cercle.txt"));
		// on lit le premier token
		t.nextToken();
		// tant que je ne suis pas à la fin du fichier...
		while(t.ttype != StreamTokenizer.TT_EOF) {
			// si on n'a pas lu un mot ou si le mot "CERCLE" n'a pas été trouvé
			if (t.ttype != StreamTokenizer.TT_WORD || !t.sval.equals("CERCLE")) {
				Exception.myError("'CERCLE' attendu");
			}
			
			t.nextToken();
			if(t.ttype != '(') {
				Exception.myError("'(' attendue");
				}
			
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			// stoque la valeur numérique dans x
			x = t.nval;
			
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			// stoque la valeur numérique dans y
			y = t.nval;
			
			t.nextToken();
			if(t.ttype != StreamTokenizer.TT_NUMBER) {
				Exception.myError("nombre attendu");
			}
			// stoque la valeur numérique dans r
			r = t.nval;
			
			t.nextToken();
			if(t.ttype != ')') {
				Exception.myError("')' attendue");
			}
			t.nextToken();
			String s = String.format("lu cercle de coordonnées x= %.2f , y=%.2f et rayon r=%.2f", x, y, r); 
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
