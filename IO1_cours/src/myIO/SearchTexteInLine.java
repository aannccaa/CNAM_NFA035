package myIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchTexteInLine {

	public static boolean existeTexteInLine(String[] param) throws IOException {
		String texte = param[0];
		String fichier = param[1];
		FileReader fr = new FileReader(fichier);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			if (line.contains(texte)) {
				return true;
			}
			line = br.readLine();
		}
		if (br != null) {
			br.close();
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		String[] param = new String[2];
		param[0] = "trois";
		param[1] = "demo.txt";
		boolean b = existeTexteInLine(param);
		System.out.println(b);
	}

}
