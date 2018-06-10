package myIO;

public class Exception extends RuntimeException{

	public static void myError(String e) {
		throw new RuntimeException("erreur de synthaxe " + e);
	}
}
