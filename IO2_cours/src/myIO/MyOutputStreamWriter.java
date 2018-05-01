package myIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;


public class MyOutputStreamWriter {

	public static void writeIntoFile(String fileName, String texte) throws IOException, FileNotFoundException  {
		if(fileName == null) {
			throw new FileNotFoundException("Nom de fichier non spécifié !");
		}
		
		Writer w = null; 
		OutputStream output = null;
		
		try {
			output = new FileOutputStream(fileName);
			w = new OutputStreamWriter(output, "UTF-8");	
			w.write(texte);	
			
		} finally {			
			if (w != null) {
				w.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}
	
	public static String afficherToString(Reader r) throws IOException {
		String result="";
		while (true) {
			int c = r.read();
			if (c == -1) {
				break;
			}
			char ch = (char) c;
			result = result + ch;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		String texte = "J'écris une ligne et je passe déjà sur\nla deuxième.";
		String fileName = "streamOutputWriter.txt";
		writeIntoFile(fileName, texte);
		Reader r = new FileReader(fileName);
		String fileContent = afficherToString(r);
		System.out.println(fileContent);
	}

}
