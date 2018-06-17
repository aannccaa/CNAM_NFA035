package myIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class SearchTexteInLine {

	// lecture ligne par ligne avec un BufferedReader(FileReader)
	public static boolean existeTexteInLine(String textToFind, String nomFichier) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(nomFichier);
			br = new BufferedReader(fr);

			// lecture ligne par ligne
			String line = br.readLine();
			while (line != null) {
				if (line.contains(textToFind)) {
					return true;
				}
				line = br.readLine();
			}
		} finally {
			if (br != null) {
				br.close();
			}
			if (fr != null) {
				fr.close();
			}
		}
		return false;
	}

	public static void afficherLigneContainingString(String textToFind, String nomFichier) throws IOException {
		String result = "";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("demo.txt");
			br = new BufferedReader(fr);
			while (true) {
				result = br.readLine();
				if (result == null) {
					break;
				}
				if (result.contains(textToFind)) {
					System.out.println(result);
				}
				br.readLine();
			}

		} finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}

	public static void afficherLigneContainingString2(String textToFind, String texte) throws IOException {
		String result = "";
		StringReader sr = null;
		BufferedReader br = null;
		try {
			sr = new StringReader(texte);
			br = new BufferedReader(sr);
			while (true) {
				result = br.readLine();
				if (result == null) {
					break;
				}
				if (result.contains(textToFind)) {
					System.out.println(result);
				}
				br.readLine();
			}

		} finally {
			if (sr != null) {
				sr.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}

	public static void afficherLigneContainingString3(String textToFind, Reader r) throws IOException {
		String result = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(r);
			while (true) {
				result = br.readLine();
				if (result == null) {
					break;
				}
				if (result.contains(textToFind)) {
					System.out.println(result);
				}
				br.readLine();
			}

		} finally {
			if (r != null) {
				r.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {

		boolean b = existeTexteInLine("trois", "demo.txt");
		System.out.println(b);

		afficherLigneContainingString("trois", "demo.txt");
		
		afficherLigneContainingString2("deux", "Un deux \n trois \n vingt-deux");
		
		StringReader sr = new StringReader("Un deux \n trois \n vingt-deux");
		afficherLigneContainingString3("deux", sr);
		
		FileReader fr = new FileReader("demo.txt");
		afficherLigneContainingString3("ligne", fr);

		/*
		 * // fara nici o legatura, ca sa afisez args, in Run configs / Arguments scriu
		 * // "anca a obosit si vrea la culcare, nu mai are rabdare" if (args.length >
		 * 0) { for (String s : args) { System.out.println(s); } }
		 */
	}

}
