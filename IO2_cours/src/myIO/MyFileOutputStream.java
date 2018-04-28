package myIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class MyFileOutputStream {

	public static void writeOutputStream(OutputStream output) throws IOException {
		output.write(10);
		output.write(11);
		output.write(200);
		output.write('a');
		output.write('b');
		output.write('c');
	}

	public static void afficherAsciContent(Reader input) throws IOException {
		String s = "";
		int c = input.read();
		s = s + c + "\n";
		
		while (c != -1) {
			c = input.read();
			s = s + c + "\n";
		}
		System.out.println(s);
	}

	public static void main(String args[]) throws IOException {
		OutputStream output = new FileOutputStream("output.txt");
		writeOutputStream(output);
		
		InputStream input = new FileInputStream("output.txt");
		MyFileInputStream.afficherNbOctets(input);
		
		Reader r = new FileReader("output.txt");
		afficherAsciContent(r);
		
		output.close();
		input.close();
	}
}
