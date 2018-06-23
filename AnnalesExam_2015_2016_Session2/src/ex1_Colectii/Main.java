package ex1_Colectii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Logiciel java8 = new Logiciel("Java", 8);
		Logiciel java6 = new Logiciel("Java", 6);
		Logiciel netbeans = new Logiciel("Netbeans", 1);
		
		Set<Logiciel> dependances = new HashSet<Logiciel>();
		
		netbeans.ajoutDependance(java6);
		System.out.println("netbeans.dependDe(java6): " + netbeans.dependDe(java6));
		
		InstallMachine im = new InstallMachine();
		
		HashMap<String, Logiciel> installes = new HashMap<>();
		im.installer(java8);
		System.out.println(im.estInstalle(java8));
		System.out.println(im.estInstalle("Java"));
		System.out.println(im.estInstalle(java6));
		
		

	}

}
