package myIO;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Mot {

	public static List<String> getMots(StringReader sr) throws IOException {		
		boolean dansMot = false;
		String motCourrant = "";

		List<String> mots = new ArrayList<>();
		int c;
		do {
			c = sr.read();
			char ch = (char) 0;
			boolean isLetter;
			if (c == -1) { // reader fini
				isLetter = false;
			} else {
				ch = (char) c;
				isLetter = Character.isLetter(ch);
			}

			if (dansMot) {
				if (isLetter) {
					motCourrant += ch;
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
		String s = "je sais: tu n'est pas là bas";
		StringReader sr = new StringReader(s);
		List<String> mots = getMots(sr);
		System.out.println(mots.toString());
	}

}
