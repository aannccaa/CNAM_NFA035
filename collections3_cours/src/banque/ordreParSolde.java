package banque;
import java.util.Comparator;

public class ordreParSolde implements Comparator<Compte>{

	@Override
	public int compare(Compte c1, Compte c2) {
		if (c1.getSolde() > c2.getSolde()) {
			return 1;
		}
		if (c1.getSolde() < c2.getSolde()) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	
}
