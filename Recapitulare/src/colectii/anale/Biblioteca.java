package colectii.anale;

import java.util.ArrayList;
import java.util.Collections;
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

public class Biblioteca {
	Set<Carte> carti;
	// map de autor, lista de carti
	Map<String, Set<Carte>> cartiAutor;

	public Biblioteca() {
		carti = new HashSet<>();
		cartiAutor = new HashMap<>();
	}

	public void addCarte(Carte c) {
		this.carti.add(c);
		// pentru fiecare autor
		for (String autor : c.getAutori()) {
			// obtin lista de sa carti
			Set<Carte> cartiAutor = this.cartiAutor.get(autor);
			// daca lista nu exista
			if (cartiAutor == null) {
				// o creez
				cartiAutor = new HashSet<>();
				// o adaug la map
				this.cartiAutor.put(autor, cartiAutor);
			}
			// adaug cartea in lista de carti ale autorului
			cartiAutor.add(c);
		}
	}

	public List<Carte> getCartiSortateDupaNume() {
		// transform Set<Carte> in List<Carte>, pt ca o lista e sortabila dar un set nu
		List<Carte> result = new ArrayList<>(this.carti);
		// sortez lista (dupa ordinea naturala din clasa Carte, care implementata
		// Comparable)
		Collections.sort(result);
		return result;
	}

	public List<Carte> getCartiSortateDupaAutorPrincipal() {
		List<Carte> result = new ArrayList<>(this.carti);
		// sortez lista
		Collections.sort(result, new ComparatorCarteDupaAutorPrincipal());
		return result;
	}
}
