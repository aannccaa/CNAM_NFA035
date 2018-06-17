package myIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Heure2 {

	public static char readChar(FileReader fr) throws IOException {
		int c;
		char ch;
		c = fr.read();
		ch = (char) c;
		return ch;
	}
	
	public static String getHeure(FileReader fr) throws IOException {
		String result = "";
		int c=0;
		int h;
		int m;
		char ch = (char) 0;
		boolean estChiffre;

		// lire le premier charactère
		ch = readChar(fr);
		
		// si on est à la fin du fichier
		if (c == -1) {// fin du flux lu par le reader
			estChiffre = false;
		} else {
			ch = (char) c;
			estChiffre = estChiffre(ch);
		}
		
		if (!estChiffre) {
			throw new RuntimeException("'"+ ch + "' trouvé à la place d'un chiffre");
		}
		
		h = Character.getNumericValue(ch);
		//h = ch - '0';
		ch = readChar(fr);
		estChiffre = estChiffre(ch);

		if (estChiffre) {
			h = h * 10 + Character.getNumericValue(ch);
			result = result + h;
			ch = readChar(fr);
		}

		while (ch == ' ') {
			ch = readChar(fr);
			estChiffre = estChiffre(ch);
		}
		if (c != 'h') {
			throw new RuntimeException("'"+ ch + "' trouvé à la place de 'h'");
		} else {
			result = result + "h";
		}

		ch = readChar(fr);

		while (ch == ' ') {
			ch = readChar(fr);
		}

		estChiffre = estChiffre(ch);

		if (!estChiffre) {
			throw new RuntimeException("'"+ ch + "' trouvé à la place d'un chiffre");
		}

		m = ch -'0';
		ch = readChar(fr);
		estChiffre = estChiffre(ch);


		if (estChiffre) {
			m = m * 10 + Character.getNumericValue(c);
			result = result + m;
			ch = readChar(fr);
		}

		return result;
	}

	private static boolean estChiffre(char ch) {
		boolean estChiffre;
		estChiffre = Character.isDigit(ch);
		return estChiffre;
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
