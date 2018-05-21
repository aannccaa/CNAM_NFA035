package ex2.corection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe utilitaire pour notre application.
 * <p>
 * En java 8, Files fournit presque tout ce qu'il faut.
 * 
 * @author rosmord
 *
 */
public class FilesUtils {

	public static String read(File f) throws FileNotFoundException, IOException {
		StringBuilder b = new StringBuilder();
		FileReader r = new FileReader(f);
		try { // On pourrait utiliser un try-with-ressources à la place de ce
				// try...finally...
			int c;
			while ((c = r.read()) != -1) {
				b.append((char) c);
			}
			return b.toString();
		} finally {
			r.close();
		}
	}

	public static void write(File f, String s) throws IOException {
		// Nous utilisons ici un try-with-ressource: le fichier est
		// automatiquement fermé.
		try (FileWriter w = new FileWriter(f)) {
			w.write(s);
		}
	}

}
