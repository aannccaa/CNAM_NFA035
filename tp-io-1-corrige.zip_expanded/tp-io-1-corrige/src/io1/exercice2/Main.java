package io1.exercice2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		FileReader r= new FileReader("demo1.txt");
		FileWriter w= new FileWriter("out2.txt");
		Exercice2.copieUneSurDeux(r, w);
	}
}
