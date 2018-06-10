package exo1;

import java.io.*;

public class Exercice1 {
	public static void afficher(Reader r) throws IOException {
		try {
			int c;
			c = r.read();
			while (c != -1) {
				System.out.print((char) c);
				c = r.read();
			}
		} finally {
			r.close();
		}
	}
	
	public static void main(String[] args) throws IOException{
		afficher(new FileReader("demo1.txt"));
	}
}
