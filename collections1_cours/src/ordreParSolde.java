import java.util.Comparator;

public class ordreParSolde implements Comparator<Compte> {
	public int compare(Compte o1, Compte o2) {
		if (o1.getSolde() < o2.getSolde()) {
			return -1;
		} else if (o1.getSolde() > o2.getSolde()) {
			return 1;
		} else {
			return 0;
		}
	}

}
