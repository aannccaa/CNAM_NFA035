package myIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchTexteInLine {

	public static boolean existeTexteInLine(String textToFind, String nomFichier) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(nomFichier);
			br = new BufferedReader(fr);

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

	public static void main(String[] args) throws IOException {
		if(args.length > 0) {
			for(String s : args) {
				System.out.println(s);
			}
		}
		
		boolean b = existeTexteInLine("trois", "demo.txt");
		System.out.println(b);
	}

}
