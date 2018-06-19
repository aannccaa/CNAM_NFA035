package myIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileInputStream {

	public static void afficherNbOctets(InputStream input) throws IOException {
		int c = input.read();
		int nb = 0;
		while (c != -1) {
			nb++;
			c = input.read();
		}	
		System.out.println("nb octets: " + nb);
	}

	public static void main(String args[]) throws IOException {
		InputStream input = new FileInputStream("input.txt");
		afficherNbOctets(input);
		input.close();
	}

}
