package myIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class MyInputStreamReader {

	private static void afficher(Reader r) throws IOException {
		while (true) {
			int c = r.read();
			if (c == -1) {
				break;
			}
			char ch = (char) c;
			System.out.print(ch);
		}
	}

	private static void afficherFileContent(String fileName)
			throws FileNotFoundException, UnsupportedEncodingException, IOException {
		InputStream input = null;
		Reader r = null;
		try {
			input = new FileInputStream(fileName);
			r = new InputStreamReader(input, "UTF-8");
			afficher(r);
		} finally {
			if (r != null) {
				r.close();
			}
			if (input != null) {
				input.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		afficherFileContent("input.txt");
	}

}
