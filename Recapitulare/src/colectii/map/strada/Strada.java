package colectii.map.strada;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Strada {
	String nume;
	Map<String, NumarStrada> numere;

	public Strada(String nume) {
		this.nume = nume;
		this.numere = new HashMap<>();
	}

	public String getNume() {
		return this.nume;
	}

	public String toString_parcurgEntrySet() {
		List<String> numere = new ArrayList<>();
		for (Map.Entry<String, NumarStrada> entry : this.numere.entrySet()) {
			NumarStrada numar = entry.getValue();
			numere.add(numar.toString());
		}
		return String.format("%s\n%s", this.getNume(), numere);
	}

	public String toString_parcurgKeySet() {
		List<String> numere = new ArrayList<>();
		for (String key : this.numere.keySet()) {
			NumarStrada numar = this.numere.get(key);
			numere.add(numar.toString());
		}
		return String.format("%s\n%s", this.getNume(), numere);
	}

	public String toString_orig() {
		List<String> numere = new ArrayList<>();
		for (NumarStrada n : this.numere.values()) {
			numere.add(n.toString());
		}
		return String.format("%s\n%s", this.getNume(), numere);
	}

	public NumarStrada getNumarStrada(String numar) {
		return this.numere.get(numar);
	}

	public NumarStrada addNumarStrada(String numar) {
		NumarStrada n = this.getNumarStrada(numar);
		if (n == null) {// daca NumarStrada nu exista, o creez
			n = new NumarStrada(this, numar);
			this.numere.put(numar, n); // o adaug la lista de numere
		}
		return n;
	}

	public Set<NumarStrada> findPersoana(String nume) {
		Set<NumarStrada> result = new HashSet<NumarStrada>();
		for (NumarStrada n : this.numere.values()) {
			for (Persoana p : n.persoane) {
				if (p.getNume() == nume) {
					result.add(n);
				}
			}
		}
		return result;
	}
}
