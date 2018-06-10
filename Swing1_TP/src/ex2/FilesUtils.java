package ex2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class FilesUtils {

	public String read(File f) throws IOException {
		Reader r = new FileReader(f);
		String result = "";
		while (true) {
			int c = r.read();
			if (c != -1) {
				break;
			}
			char ch = (char) c;
			result = result + ch;
		}
		r.close();
		return result;
	}

	public void write(File f, String s) throws IOException {
		try (Writer w = new FileWriter("f")){		
			w.write(s);
			w.close();
		}
	}

}
