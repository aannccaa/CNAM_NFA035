import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class Reader {

	public static void main(String[] args) throws IOException {
		// FileReader
		System.out.println("FileReader ==>");
		FileReader fr = new FileReader("demo.txt");
		// on recupere la valeur int du charactère
		int c = fr.read();
		int nbChar = 0;
		// si on est à la fin du fichier read() renvoie -1
		while (c != -1) {
			char ch = (char) c;
			System.out.print(ch);
			c = fr.read();
			nbChar++;
		}
		fr.close();

		System.out.println();
		System.out.println("Nb charactères lus: " + nbChar);
		
		System.out.println("<========");

		// BufferedReader
		System.out.println("BufferedReader  ==>");
		FileReader fr2 = new FileReader("demo.txt");
		BufferedReader br = new BufferedReader(fr2);
		String s = br.readLine();
		int nbLignes = 0;
		// tant qu'il y a de ligne à lire
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
			nbLignes++;
		}

		System.out.println();
		System.out.println("Nb lignes lus: " + nbLignes);
		// br.close ferme aussi le FileReader
		br.close();
		//fr2.close();
		System.out.println("<========");
		
		//StringReader
		System.out.println("StringReader  ==>");
		StringReader sr = new StringReader("hello");
		int c2 = sr.read();
		while(c2 != -1) {
			char ch2 = (char) c2;
			System.out.print(ch2);
			c2 = sr.read();
		}
		sr.close();
		System.out.println("<========");
	}
}
