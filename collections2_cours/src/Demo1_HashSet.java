
import java.util.HashSet;
import java.util.Set;

public class Demo1_HashSet {
	public static void afficheSet(Set<String> c) {
		for (String s : c) {
			System.out.print(" " + s);
		}
	}

	public static void main(String[] args) {
		HashSet<String> col = new HashSet<String>();
		col.add("Aa");
		col.add("Aa");
		col.add("Bb");
		col.add("Aa");
		col.add("Cc");

		afficheSet(col);
		System.out.println();
		String[] noms1 = { "Lucie", "Julien", "Remy", "Thomas", "Ali" };

		// Placer les noms de dans un ensemble
		HashSet<String> setNom1 = new HashSet<String>();
		// L'ordre d'accès n'est pas forcément celui d'insertion
		for (String s : noms1) {
			setNom1.add(s);
			System.out.print(" " + s);
		}
		System.out.println();
		afficheSet(setNom1);

	}
}
