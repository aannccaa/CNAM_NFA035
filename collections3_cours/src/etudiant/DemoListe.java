package etudiant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoListe {

	public static void main(String[] args) {
		List<Etudiant> etudiants = new ArrayList<>();
		etudiants.add(new Etudiant(55l, "toto", 1980));
		etudiants.add(new Etudiant(3l, "titi", 1985));
		etudiants.add(new Etudiant(20l, "tutu", 1990));
		etudiants.add(new Etudiant(10l, "titi", 1996));
		
		ListeComparator lc = new ListeComparator();
		Collections.sort(etudiants, lc);
		
		for(Etudiant e : etudiants) {
			System.out.print(e.toString());
		}
		
		
		
		
	}

}
