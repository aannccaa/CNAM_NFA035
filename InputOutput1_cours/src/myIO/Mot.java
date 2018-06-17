package myIO;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Mot {

	public static List<String> getMots(Reader r) throws IOException {
		boolean dansMot = false;
		String motCourrant = "";

		List<String> mots = new ArrayList<>();
		int c;
		do {
			c = r.read();
			char ch = (char) c;
			boolean isLetter;
			if (c == -1) { // reader fini
				isLetter = false;
			} else {
				isLetter = Character.isLetter(ch);
			}

			if (dansMot) {
				if (isLetter) {
					motCourrant += ch; // echivalent cu motCourrant = motCourrant + ch;
				} else {
					mots.add(motCourrant);
					motCourrant = "";
					dansMot = false;
				}
			} else if (isLetter) {
				motCourrant += ch;
				dansMot = true;
			}
		} while (c != -1);
		// dernier mot correctement traité quand c = -1
		return mots;
	}

	public static void main(String[] args) throws IOException {
		String s = "je sais: tu n'es pas là bas";
		StringReader sr = new StringReader(s);
		List<String> mots = getMots(sr);
		System.out.println(mots.toString());
	}
}
