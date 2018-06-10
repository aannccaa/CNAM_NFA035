import java.util.HashSet;
import java.util.Set;

public class Demo2_HS_AdressesPostales {
	public static void afficheSet(Set<AdressePostale> c) {
		for (AdressePostale s : c) {
			System.out.println(s.toString());
		}
	}

	public static void main(String[] args) {
		AdressePostale a1 = new AdressePostale(2, "rue Conte", "Paris");
		AdressePostale a1bis = new AdressePostale(2, "rue Conte", "Paris");
		AdressePostale a2bis = new AdressePostale(6, "rue Conte", "Paris");
		AdressePostale a2 = new AdressePostale(6, "rue Conte", "Paris");
		AdressePostale a3 = new AdressePostale(4, "rue du Paradis", "Paris");
		AdressePostale a4 = new AdressePostale(120, "rue de la Gare", "Lyon");

		HashSet<AdressePostale> col = new HashSet<AdressePostale>();
		col.add(a1bis);
		col.add(a1);
		col.add(a2);
		col.add(a2bis);
		col.add(a3);
		col.add(a4);

		afficheSet(col);
	}
}
