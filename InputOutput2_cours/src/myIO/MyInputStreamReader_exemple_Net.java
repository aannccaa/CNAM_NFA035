package myIO;
//http://thecodersbreakfast.net/index.php?post/2012/01/15/java-io-explique-simplement

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

class DataClass implements Serializable {
	public int id;
	public String code;
	public String libelle;

	public String toString() {
		return String.format("%d %s %s", id, code, libelle);
	}
}

public class MyInputStreamReader_exemple_Net {

	public static void main(String[] args) throws IOException {

		// Lire les lignes d'un fichier texte, en comptant les lignes (LineNumberReader
		// → BufferedReader → FileReader) :
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		LineNumberReader counter = new LineNumberReader(br);
		String line = null;
		while ((line = counter.readLine()) != null) {
			int lineNum = counter.getLineNumber();
			System.out.println(lineNum + " : " + line);
		}
		counter.close();

		// Sérialiser un objet vers un tableau de bytes
		// (ObjectOutputStream → ByteArrayOutputStream) :
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// on peut aussi utiliser un FileOutputStream
		// FileOutputStream baos = new FileOutputStream("x.bin");

		ObjectOutputStream oos = new ObjectOutputStream(baos);
		DataClass d = new DataClass();
		d.id = 15;
		d.code = "c1";
		d.libelle = "lib c1";

		oos.writeObject("Hello World");
		oos.writeObject(d);
		oos.close();
		baos.close();

		byte[] tabBytes = baos.toByteArray();
		// lit le tableau de bytes et affiche chaque charactère
		// for (byte b:tabBytes) {
		// System.out.println(b);
		// }

		ByteArrayInputStream bais = new ByteArrayInputStream(tabBytes);
		// on peut aussi utiliser un FileInputStream
		// FileInputStream bais = new FileInputStream("x.bin");

		ObjectInputStream ois = new ObjectInputStream(bais);
		try {
			String s = (String) (ois.readObject());
			System.out.println("s" + s);
			DataClass d1 = (DataClass) (ois.readObject());
			System.out.println(d1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lire une ligne de texte saisie dans la console ;
		// attention, System.in est de type InputStream, il faut donc le convertir
		// (BufferedReader → InputStreamReader → InputStream fourni par System.in) :
		InputStream in = System.in;
		Charset charset = Charset.forName("UTF-8");
		InputStreamReader isr = new InputStreamReader(in, charset);
		BufferedReader br2 = new BufferedReader(isr);
		String line2 = br2.readLine();
		System.out.println(line2);
		br2.close();

	}
}
