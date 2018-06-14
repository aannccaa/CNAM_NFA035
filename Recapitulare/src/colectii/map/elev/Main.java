package colectii.map.elev;

import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Elev toto = new Elev("Toto");
		toto.addNota("franceza", 10);
		toto.addNota("mate", 9.5);
		toto.addNota("franceza", 8);

		Clasa c5B = new Clasa("Clasa 5B");
		c5B.elevi.add(toto);

		Elev mimi = new Elev("Mimi");
		mimi.addNota("franceza", 5);
		mimi.addNota("mate", 7);
		mimi.addNota("franceza", 6);
		c5B.elevi.add(mimi);

		List<Nota> medii = toto.getMedii();
		for (Nota nota : medii) {
			System.out.println(nota.toString(true, true));
		}
		List<Nota> mediiClasa = c5B.getMedii();
		mediiClasa.sort(null);// foloseste ordinea din clasa Nota (elev, materie, nota, crescator)
		System.out.println(mediiClasa.toString());
		
		// implementez intr-o clasa anonima Comparator<Nota> pe care-l pasez ca param la sort.
		// comparatorul ordoneaza descrescator dupa nota si crescator dupa elev / materie
		mediiClasa.sort(new Comparator<Nota>() {
			public int compare(Nota n1, Nota n2) {
				// minus schimba ordinea (crescator -> descrescator)
				int result = - new Double(n1.nota).compareTo(n2.nota);
				if (result == 0) {
					result = n1.numeElev.compareTo(n2.numeElev);
				}
				if (result == 0) {
					result = n1.materie.compareTo(n2.materie);
				}
				return result;
			}
		});

		System.out.println(mediiClasa.toString());

	}
}
