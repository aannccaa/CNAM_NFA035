package colectii.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Strada {
	String nume;
	Set<NumarStrada> numere;

	public Strada(String nume) {
		this.nume = nume;
		this.numere = new HashSet<>();
	}

	public String getNume() {
		return this.nume;
	}

	public String toString() {
		List<String> numere = new ArrayList<>();
		for (NumarStrada n : this.numere) {
			numere.add(n.toString());
		}
		return String.format("%s\n%s", this.getNume(), numere);
	}

	public NumarStrada getNumarStrada(String numar) {
		for (NumarStrada n : this.numere) {
			if (n.getNumar() == numar) {
				return n;
			}
		}
		return null;
	}

	public NumarStrada addNumarStrada(String numar) {
		NumarStrada n = this.getNumarStrada(numar);
		if (n == null) {// daca NumarStrada nu exista, o creez
			n = new NumarStrada(this, numar);
			this.numere.add(n); // o adaug la lista de numere
		}
		return n;
	}

	public Set<NumarStrada> findPersoana(String nume) {
		Set<NumarStrada> result = new HashSet<NumarStrada>();
		for (NumarStrada n : this.numere) {
			for (Persoana p : n.persoane) {
				if (p.getNume() == nume) {
					result.add(n);
				}
			}
		}
		return result;
	}
}
