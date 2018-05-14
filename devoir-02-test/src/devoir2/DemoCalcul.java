package devoir2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DemoCalcul {

	public static void main(String[] args) throws IOException {
		Reader r = new FileReader("operations.txt");
		CalcInterp calc = new CalcInterp();
		System.out.println(calc.calcule(r));
		
	}

}
