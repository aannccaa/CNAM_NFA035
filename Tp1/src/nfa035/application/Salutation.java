package nfa035.application;
import nfa035.utils.Terminal;
//import nfa035.utils.*;

public class Salutation {

	public static void main(String[] args) {
		Terminal.ecrireString("Quel est votre nom? ");
		String nom = Terminal.lireString();
		String salutation = String.format("Bonjour %s", nom);
		System.out.println(salutation);
		

	}

}
