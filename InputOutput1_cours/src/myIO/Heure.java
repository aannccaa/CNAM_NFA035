package myIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Heure {

	public static String getHeure(Reader r) throws IOException {
		String result = "";
		int c;
		int h; // heures
		int m; // minutes
		char ch = (char) 0;
		boolean estChiffre;

		// lire le premier charactère
		c = r.read();
		ch = (char) c;

		// si on est à la fin du fichier
		if (c == -1) {// fin du flux lu par le reader
			estChiffre = false;
		} else {
			estChiffre = Character.isDigit(ch);
		}

		if (!estChiffre) {
			throw new RuntimeException("'" + ch + "' trouvé à la place d'un chiffre");
		}

		h = Character.getNumericValue(ch); // echivalent cu:
		// h = ch - '0';

		c = r.read();
		ch = (char) c;
		estChiffre = Character.isDigit(ch);
		m = Character.getNumericValue(ch);

		if (estChiffre) {
			h = h * 10 + m;
			result = result + h;
			c = r.read();
			ch = (char) c;
		}

		while (ch == ' ') {
			c = r.read();
			ch = (char) c;
			estChiffre = Character.isDigit(ch);
		}
		if (c != 'h') {
			throw new RuntimeException("'" + ch + "' trouvé à la place de 'h'");
		} else {
			result = result + "h";
		}

		c = r.read();
		ch = (char) c;

		while (ch == ' ') {
			c = r.read();
			ch = (char) c;
		}

		estChiffre = Character.isDigit(ch);

		if (!estChiffre) {
			throw new RuntimeException("'" + ch + "' trouvé à la place d'un chiffre");
		}

		m = ch - '0';
		c = r.read();
		ch = (char) c;
		estChiffre = Character.isDigit(ch);

		if (estChiffre) {
			m = m * 10 + Character.getNumericValue(c);
			result = result + m;
			c = r.read();
			ch = (char) c;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		try {
			fr = new FileReader("Heure.txt");
			System.out.println(getHeure(fr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
