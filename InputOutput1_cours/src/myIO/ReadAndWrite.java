package myIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ReadAndWrite {

	// lecture flux avec FileReader / écriture avec FileWriter
	public static String copyFileContentInOtherFile(FileReader fr, FileWriter fw) throws IOException {
		String texte = "";
		int c = fr.read();
		while (c != -1) {
			char ch = (char) c;
			fw.write(c);
			texte = texte + ch;
			c = fr.read();
		}
		return texte;
	}

	// lecture flux avec StringReader / écriture avec StringWriter
	public static String copyStringFromReader(StringReader sr, StringWriter sw) throws IOException {
		int c = sr.read();
		while (c != -1) {
			char ch = (char) c;
			sw.write(ch);
			c = sr.read();
		}
		String texte = sw.toString();
		return texte;
	}

	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		StringReader sr = null;
		StringWriter sw = null;
		try {
			fr = new FileReader("demo.txt");
			fw = new FileWriter("toto.txt");
			System.out.println(copyFileContentInOtherFile(fr, fw));
			System.out.println("==============");
			sr = new StringReader("un texte ");
			sw = new StringWriter();
			System.out.println(copyStringFromReader(sr, sw));
			System.out.println("==============");
		} finally {
			fr.close();
			fw.close();
			sr.close();
			sw.close();
			System.out.println("flux closed");
		}
	}
}
