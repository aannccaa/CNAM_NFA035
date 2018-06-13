package colectii.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumarStrada {
	private Strada strada;
	private String numar;
	public final Set<Persoana> persoane;

	public NumarStrada(Strada strada, String numar) {
		this.strada = strada;
		this.numar = numar;
		this.persoane = new HashSet<>();
	}

	public String getNumar() {
		return this.numar;
	}

	public String toString() {
		List<String> persoane = new ArrayList<>();
		for (Persoana p : this.persoane) {
			persoane.add(p.toString());
		}
		return String.format("%s %s", this.getNumar(), this.strada.getNume());
	}

}
