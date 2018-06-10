package myIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Heure {

	public static String getHeure(FileReader fr) throws IOException {
		String result = "";
		int c;
		int h;
		int m;
		char ch = (char) 0;
		boolean estChiffre;

		// lire le premier charactère
		c = fr.read();
		ch = (char) c;
		
		// si on est à la fin du fichier
		if (c == -1) {// fin du flux lu par le reader
			estChiffre = false;
		} else {
			ch = (char) c;
			estChiffre = Character.isDigit(ch);
		}
		
		if (!estChiffre) {
			throw new RuntimeException("'"+ ch + "' trouvé à la place d'un chiffre");
		}
		
		h = Character.getNumericValue(ch);
		//h = ch - '0';
		c = fr.read();
		ch = (char) c;
		estChiffre = Character.isDigit(ch);

		if (estChiffre) {
			h = h * 10 + Character.getNumericValue(c);
			result = result + h;
			c = fr.read();
			ch = (char) c;
		}

		while (ch == ' ') {
			c = fr.read();
			ch = (char) c;
			estChiffre = Character.isDigit(ch);
		}
		if (c != 'h') {
			throw new RuntimeException("'"+ ch + "' trouvé à la place de 'h'");
		} else {
			result = result + "h";
		}

		c = fr.read();
		ch = (char) c;

		while (ch == ' ') {
			c = fr.read();
			ch = (char) c;
		}

		estChiffre = Character.isDigit(ch);

		if (!estChiffre) {
			throw new RuntimeException("'"+ ch + "' trouvé à la place d'un chiffre");
		}

		m = ch -'0';
		c = fr.read();
		ch = (char) c;
		estChiffre = Character.isDigit(ch);


		if (estChiffre) {
			m = m * 10 + Character.getNumericValue(c);
			result = result + m;
			c = fr.read();
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
