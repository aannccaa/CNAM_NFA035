package colectii.anale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Cartea are un nume si o lista de autori (string: nume autor). Pt carte:
 - adauga autor
 - obtine autorul principal
 - obtine lista autori secundari
Biblioteca are o lista de carti. Pt. bibllioteca:
- construieste un map care pentru fiecare autor sa dea lista de carti Map<String, Carte>
- sorteaza lista de carti dupa nume carte
- ordoneaza lista de carti dupa autorul principal.
 */

public class Carte implements Comparable<Carte> {
	String nume;
	Map<String, Boolean> autori;

	public Carte(String nume) {
		this.nume = nume;
		this.autori = new HashMap<>();
	}

	public void addAutor(String nume, boolean autorPrincipal) {
		String key = nume;
		// daca e principal, ii fac secundari pe toti (inclusiv pe cel principal)
		if (autorPrincipal) {
			setAllAutoriSecundari();
		}
		// il fac principal pe autorul cu numele dat.
		this.autori.put(key, autorPrincipal);
	}

	private void setAllAutoriSecundari() {
		Set<Map.Entry<String, Boolean>> entries = this.autori.entrySet();
		for (Map.Entry<String, Boolean> e : entries) {
			String numeAutor = e.getKey();
			boolean autorPrincipal = e.getValue();
			if (autorPrincipal) {
				this.autori.put(numeAutor, false);
			}
		}
	}

	public String getAutorPrincipal() {
		Set<Map.Entry<String, Boolean>> entries = this.autori.entrySet();
		for (Map.Entry<String, Boolean> e : entries) {
			String nume = e.getKey();
			boolean autorPrincipal = e.getValue();
			if (autorPrincipal) {
				return nume;
			}
		}
		return null;
	}

	public Set<String> getAutoriSecundari() {
		Set<String> result = new HashSet<>();
		Set<Map.Entry<String, Boolean>> entries = this.autori.entrySet();
		for (Map.Entry<String, Boolean> e : entries) {
			boolean autorPrincipal = e.getValue();
			if (!autorPrincipal) {
				String numeAutor = e.getKey();
				result.add(numeAutor);
			}
		}
		return result;
	}

	public Set<String> getAutori() {
		return this.autori.keySet();
	}

	// compara dupa nume carte
	@Override
	public int compareTo(Carte o) {
		if (o == null) {
			return this.nume.compareTo(null);
		}
		return this.nume.compareTo(o.nume);
	}
}
