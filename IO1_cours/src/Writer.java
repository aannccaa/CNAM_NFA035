import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void main(String[] args) throws IOException {
		char[] texte = { 'u', 'n', ' ', '2', '\n', 't', 'r', 'o', 'i', 's' , '\n', '3', ' ', 'l', 'i', 'g', 'n', 'e', 's'};
		// création d'un fichier s'il n'existe pas ou vidage du fichier s'il existe
		FileWriter w = new FileWriter("demo.txt");
		for (char c : texte) {
			w.write(c);
		}
		System.out.println("demo.txt sauvegardé");
		w.close();
	}
}
